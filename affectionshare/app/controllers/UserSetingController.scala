package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import play.api.data.validation.Valid
import play.api.data.validation.Constraint
import play.api.data.validation.Invalid
import play.api.i18n.I18nSupport
import play.api.i18n._
import commonlogic.logicservice.tablemodel.LoginUserTable
import commonlogic.util.CacheUtil
import play.api.cache._
import commonlogic.logicservice.UserService
import play.api.data.validation._
import java.time.ZonedDateTime
import scala.util.Try
import commonlogic.logicservice.viewmodel.UserForList
import java.util.Date

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class UserSetingController @Inject()( cache: SyncCacheApi,  cc: ControllerComponents ) extends AbstractController(cc) with I18nSupport {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  
  // ユーザフォーム
  // 空白チェックにオリジナルメッセージを設定してみる
  val userForm = Form( mapping( "registCategory" -> number.verifying("不正なアクセスです" , {setRegistCategory(_)}) ,
                                "userid" -> text.verifying("ユーザIDを入力してください。" , {!_.isEmpty()}) 
                                                .verifying("ユーザIDを半角英数字で入力してください。" , {_.matches("[0-9a-zA-Z]+")}) 
                                                .verifying("ユーザIDが重複しています。" , {validateDupulicateUserId(_)}) ,
                                "userpw" -> text.verifying("パスワードを入力してください。" , {validateUserPwEmpty(_)}) ,
                                "username" -> text.verifying("ユーザ名称を入力してください。" , {validateUserNameEmpty(_)}) ,
                                "usercategory" -> optional(number) ,
                                "gender" -> text,
                                "email" -> text.verifying( "メールの形式で入力してください。" , {validateEmailFormat(_)}),
                                "lineid" -> text.verifying( "半角英数だけで入力してください。" , {validateLineIdFormat(_)}),
                                "telephone" -> text.verifying( "数字のみで入力してください。" , {validateTelephoneFormat(_)}),
                                "birhtdate" -> optional(date)
                               )
                               (UserForRegist.apply)(UserForRegist.unapply) 
                           )
  // 登録区分
  val REGIST_CATEGORY_NEW = 0
  val REGIST_CATEGORY_CHANGE = 1
  
  var loginUserTable:LoginUserTable = null
  var usercategoryLoginUser = 0
  var registCategory = 0
  
   // 登録区分のセット＆チェック
  def setRegistCategory(inputsetRegistCategory:Int):Boolean={
	// 定められた値以外
	if(inputsetRegistCategory == REGIST_CATEGORY_NEW || 
	   inputsetRegistCategory == REGIST_CATEGORY_CHANGE){
	  // グローバル変数にセット
	  registCategory = inputsetRegistCategory
	  true

	}else{
	  false
	}
  }
  

  // ユーザの重複チェック
  def validateDupulicateUserId(inputuserId:String):Boolean={
    // nullの場合
	if(inputuserId == null){
	  false
	// 変更の場合
	}else if(registCategory == REGIST_CATEGORY_CHANGE){
	  true
	}else{
	  // DBでチェック
	  if(UserService.getUserIdObject(inputuserId) == null){
	    // nullの場合はtrue
	    true
	  }else{
	    false
	  }
	}
  }
  
  // パスワードの空白チェック
  def validateUserPwEmpty(inputuserPw:String):Boolean={
    // 変更の場合
    if(registCategory == REGIST_CATEGORY_CHANGE){
      true
    }
    // nullの場合
	else if(inputuserPw == null){
	  false
	}else{
	  true
	}
  }

  // ユーザ名称の空白チェック
  def validateUserNameEmpty(inputuserName:String):Boolean={
    // 変更の場合
    if(registCategory == REGIST_CATEGORY_CHANGE){
      true
    }
    // nullの場合
	else if(inputuserName == null){
	  false
	}else{
	  true
	}
  }
  
  // emailのフォーマットチェック
  def validateEmailFormat(inputuseremail:String):Boolean={
    // nullの場合はtrue
    if(inputuseremail == null){
	  true
	}else{
	  // emailの正規表現
	  inputuseremail.matches("|^[0-9a-z_./?-]+@([0-9a-z-]+\\.)+[0-9a-z-]+$|")
	}
  }
  
  // lineidのフォーマットチェック
  def validateLineIdFormat(inputlineid:String):Boolean={
    // nullの場合はtrue
    if(inputlineid == null){
	  true
	}else{
	  // 半角英数の正規表現
	  inputlineid.matches("[0-9a-zA-Z]+")
	}
  }
  
  // telephoneのフォーマットチェック
  def validateTelephoneFormat(inputtelephone:String):Boolean={
    // nullの場合はtrue
    if(inputtelephone == null){
	  true
	}else{
	  // 半角数の正規表現
	  inputtelephone.matches("[0-9]+")
	}
  }
  
  // ユーザー一覧画面の表示
  def displayUserList() = Action { implicit request =>
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // Cacheのセッションの時間を更新するため再セット
        CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
        // 管理者権限のチェック
        if(user.usercategory == UserService.ADMIN_USER){
           // ユーザの一覧をリスト取得
           var userList:List[UserForList] = getUserListForDisplay()
           // ユーザ一覧画面へ遷移
           Ok( views.html.userList("（" + user.username + "さんでログインしています）" , user.usercategory  , userList ) )
        }else{
           // 最新投稿確認画面へ遷移
           Ok( views.html.affectionTop( "（" + user.username + "さんでログインしています）"  , user.usercategory) )
        }
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
  }
  
  // ユーザー一覧の表示用リストを取得する
  def getUserListForDisplay():List[UserForList]={
	var userList:List[UserForList] = List.empty[UserForList]
    val userTableList:List[LoginUserTable] = UserService.getUserList()
    for (item <- userTableList) {
      // ユーザ区分の文字列化
      var categoryString = ""
      // 管理者ユーザ
      if(item.usercategory == UserService.ADMIN_USER){
        categoryString = UserService.ADMIN_USER_NAME
      // 通常ユーザ
      }else if(item.usercategory == UserService.ADMIN_USER){
        categoryString = UserService.COMMON_USER_NAME
      // 利用停止
      }else{
        categoryString = UserService.STOP_USER_NAME
      }
      
      // 日付の文字列化
      var lastloginString = "%tY-%<tm-%<td" format item.lastlogin
      var tempUser:UserForList = new UserForList(item.userid , item.username  , categoryString, lastloginString)
      userList = userList :+ tempUser
    }
    return userList
  }
  
  // ユーザ変更画面（管理者）の表示
  def changeUserForAdmin(userIdParam: Option[String]) = Action { implicit request =>
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // Cacheのセッションの時間を更新するため再セット
        CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
        // 管理者権限のチェック
        if(user.usercategory == UserService.ADMIN_USER){
           userIdParam match {
             case Some(userIdParam) =>
               // DBからユーザテーブル取得
               var loginUserTableFromId = UserService.getUserIdObject(userIdParam)
               if( loginUserTableFromId != null){ 
                 // formにセット
                 val userFilledForm = userForm.fill(UserForRegist(REGIST_CATEGORY_CHANGE , loginUserTableFromId.userid , "" 
                                                  , loginUserTableFromId.username , Option(loginUserTableFromId.usercategory) , loginUserTableFromId.gender
                                                  , loginUserTableFromId.email , loginUserTableFromId.lineid , loginUserTableFromId.telephone , Option(loginUserTableFromId.birhtdate)
                                                   ))
                 // formの値を埋めてカテゴリー登録画面へ遷移
                 Ok( views.html.userRegist(userFilledForm ,  "（" + user.username + "さんでログインしています）" , user.usercategory , REGIST_CATEGORY_CHANGE,"" ) )
               }else{
                 // ユーザの一覧をリスト取得
                 var userList:List[UserForList] = getUserListForDisplay()
                 // ユーザ一覧画面へ遷移
                 Ok( views.html.userList("（" + user.username + "さんでログインしています）" , user.usercategory  , userList ) )
               }
             case None =>
               // ユーザの一覧をリスト取得
               var userList:List[UserForList] = getUserListForDisplay()
               // ユーザ一覧画面へ遷移
               Ok( views.html.userList("（" + user.username + "さんでログインしています）" , user.usercategory  , userList ) )
           
           }
        }else{
           // 最新投稿確認画面へ遷移
           Ok( views.html.affectionTop( "（" + user.username + "さんでログインしています）"  , user.usercategory) )
        }
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
  }
  
  
    // ユーザ追加画面（管理者）の表示
  def addUserForAdmin() = Action { implicit request =>
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // Cacheのセッションの時間を更新するため再セット
        CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
        // 管理者権限のチェック
        if(user.usercategory == UserService.ADMIN_USER){
           // カテゴリー登録画面へ遷移
           Ok( views.html.userRegist(userForm ,  "（" + user.username + "さんでログインしています）" , user.usercategory , REGIST_CATEGORY_NEW,"" ) )
        }else{
           // 最新投稿確認画面へ遷移
           Ok( views.html.affectionTop( "（" + user.username + "さんでログインしています）"  , user.usercategory) )
        }
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
  }
  
  // ユーザ追加・変更画面からのPOST
  def userRegistSubmit() = Action { implicit request: Request[AnyContent] =>
     // セッションのチェック
     CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
       case Some(user) =>
         // Cacheのセッションの時間を更新するため再セット
         CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
         userForm.bindFromRequest.fold(
             // 入力チェックNG
             errors => {
               // フォームのユーザ設定区分
               var registCategoryString:String = request.body.asFormUrlEncoded.get("registCategory")(0)
               var registCategory:Int = registCategoryString.toInt
               BadRequest( views.html.userRegist(errors ,  "（" + user.username + "さんでログインしています）" , user.usercategory , registCategory,"" )  )
             },
             // 入力チェックOK
             success => {
               // フォームのユーザ情報
               var userObject = userForm.bindFromRequest.get
               // formにセット
               val userFilledForm = userForm.fill(UserForRegist(userObject.registCategory , userObject.userid , "" 
                                                  , userObject.username , userObject.usercategory , userObject.gender
                                                  , userObject.email , userObject.lineid , userObject.telephone , userObject.birhtdate
                                                   ))
               // 変更の場合
               if(userObject.registCategory == REGIST_CATEGORY_CHANGE){
                 // ユーザをアップデート
                 if( UserService.updateUser(userObject.userid , userObject.userpw , userObject.username, userObject.usercategory , userObject.gender
                                          , userObject.email , userObject.lineid , userObject.telephone, userObject.birhtdate) ){
                   // 変更の成功メッセージ
                   Ok( views.html.userRegist(userFilledForm ,  "（" + user.username + "さんでログインしています）" , user.usercategory , REGIST_CATEGORY_CHANGE,"変更が完了しました。" ) )
                 }else{
                   // 変更の失敗メッセージ
                   Ok( views.html.userRegist(userFilledForm ,  "（" + user.username + "さんでログインしています）" , user.usercategory , REGIST_CATEGORY_CHANGE,"変更が失敗しました、再度変更ボタンを押してください。" ) )
                 }
               }else{
                 // ユーザをインサート
                 if( UserService.insertUser(userObject.userid , userObject.userpw , userObject.username, userObject.usercategory , userObject.gender
                                          , userObject.email , userObject.lineid , userObject.telephone, userObject.birhtdate) ){
                   // 追加の成功メッセージ
                   Ok( views.html.userRegist(userFilledForm ,  "（" + user.username + "さんでログインしています）" , user.usercategory , REGIST_CATEGORY_CHANGE,"追加が完了しました。" ) )
                 }else{
                   // 追加の失敗メッセージ
                   Ok( views.html.userRegist(userFilledForm ,  "（" + user.username + "さんでログインしています）" , user.usercategory , REGIST_CATEGORY_NEW,"追加が失敗しました、再度追加ボタンを押してください。" ) )
                 }
               }
             }
         )
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
  }
  
}
