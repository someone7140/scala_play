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
import commonlogic.logicservice.tablemodel.CategoryTable
import commonlogic.logicservice.CategoryService
import models.Category
import play.api.data.validation._
import java.time.ZonedDateTime
import scala.util.Try
import commonlogic.logicservice.viewmodel.CategoryForList

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class CategoryController @Inject()( cache: SyncCacheApi,  cc: ControllerComponents ) extends AbstractController(cc) with I18nSupport {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  var categoryTable:CategoryTable = null
  
  // カテゴリーフォーム
  // 空白チェックにオリジナルメッセージを設定してみる
  val categoryForm = Form( mapping( "categoryid" -> text.verifying("dummy" , {setCategoryIdforValidate(_)}) ,
                                    "categoryname" -> text.verifying("カテゴリー名を入力してください" , {!_.isEmpty()}) 
                                                    .verifying("カテゴリー名が重複しています。", validateDupulicateCategoryName(_) ), 
                                    "categorysort" -> text.verifying( "ソート番号を入力してください。" , {!_.isEmpty()})
                                                    .verifying( "半角英数だけで入力してください。" , _.matches("[0-9a-zA-Z]+") )
                                                    .verifying( "ソート番号が重複しています。",validateDupulicateCategorySort(_) )
                                    )
                                    (Category.apply)(Category.unapply) 
                           )

  // カテゴリー一覧画面の表示
  def displayCategoryList() = Action { implicit request =>
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // Cacheのセッションの時間を更新するため再セット
        CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
        // 管理者権限のチェック
        if(user.usercategory == UserService.ADMIN_USER){
           // カテゴリーの一覧をリスト取得
           var categoryList:List[CategoryForList] = getCategoryListForDisplay()
           
           // カテゴリー一覧画面へ遷移
           Ok( views.html.categoryList("（" + user.username + "さんでログインしています）"  , categoryList , user.usercategory ,"") )
        }else{
           // 最新投稿確認画面へ遷移
           Ok( views.html.affectionTop( "（" + user.username + "さんでログインしています）"  , user.usercategory) )
        }
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
  }
  
  // カテゴリー追加画面の表示
  def registCategoryDisplay(categoryIdParam: Option[String]) = Action { implicit request =>
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // Cacheのセッションの時間を更新するため再セット
        CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
        // 管理者権限のチェック
        if(user.usercategory == UserService.ADMIN_USER){
           categoryIdParam match {
             case Some(categoryIdString) =>
               // DBからカテゴリーテーブル取得
               var categoryTableFromId = CategoryService.getCategoryById(categoryIdString)
               if( categoryTableFromId != null){ 
                 // formにセット
                 val categoryFilledForm = categoryForm.fill(Category(categoryIdString , categoryTableFromId.categoryname , categoryTableFromId.categorysort))
                 // formの値を埋めてカテゴリー追加画面へ遷移
                 Ok( views.html.categoryRegist(categoryFilledForm ,  "（" + user.username + "さんでログインしています）" ,categoryIdString,"" ) )
               }else{
                 // カテゴリー追加画面へ遷移
                 Ok( views.html.categoryRegist(categoryForm ,  "（" + user.username + "さんでログインしています）" ,"","" ) )
               }
             case None =>
               // カテゴリー追加画面へ遷移
               Ok( views.html.categoryRegist(categoryForm ,  "（" + user.username + "さんでログインしています）" ,"","" ) )
           
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
  
  // カテゴリー追加画面からのsubmit
  def categorySubmit() = Action { implicit request: Request[AnyContent] =>
     // セッションのチェック
     CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
       case Some(user) =>
         // Cacheのセッションの時間を更新するため再セット
         CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
         // 管理者権限のチェック
         if(user.usercategory == UserService.ADMIN_USER){
           categoryForm.bindFromRequest.fold(
             // 入力チェックNG
             errors => {
               // フォームのカテゴリー情報
               var categoryId:String = request.body.asFormUrlEncoded.get("categoryid")(0).asInstanceOf[String]
               BadRequest( views.html.categoryRegist(errors ,  "（" + user.username + "さんでログインしています）" ,categoryId ,"") )
             },
             // 入力チェックOK
             success => {
               // フォームのカテゴリー情報
               var category = categoryForm.bindFromRequest.get
               if(category.categoryid != ""){
                 // カテゴリーをアップデートしてオブジェクトを取得
                 categoryTable = CategoryService.updateCategory(category.categoryid , category.categoryname , category.categorysort)
               }else{
                 // カテゴリーをインサートしてオブジェクトを取得
                 categoryTable = CategoryService.insertCategory(category.categoryname , category.categorysort)
               }
               // カテゴリーIDを文字列化
               var categoryIdString = ""
               // カテゴリーテーブルのNULL判定でメッセージを分ける
               if(categoryTable != null){                 
                 categoryTable.categoryid match {
                   case Some(id) =>
                     categoryIdString = id.toString
                     // formにセット
                     val categoryFilledForm = categoryForm.fill(Category(categoryIdString , categoryTable.categoryname , categoryTable.categorysort))
                     // 完了メッセージを表示しカテゴリー追加画面へ遷移
                     Ok( views.html.categoryRegist(categoryFilledForm ,  "（" + user.username + "さんでログインしています）",categoryIdString ,Messages("info.category.update")) )
                   case None =>
                     // エラーメッセージを表示しカテゴリー追加画面へ遷移
                     Ok( views.html.categoryRegist(categoryForm ,  "（" + user.username + "さんでログインしています）" ,"" ,Messages("error.category.update")) )
                 
                 }
               }else{
                 // エラーメッセージを表示しカテゴリー追加画面へ遷移
                 Ok( views.html.categoryRegist(categoryForm ,  "（" + user.username + "さんでログインしています）" ,"" ,Messages("error.category.update")) )
               }
             }
         )
        }else{
          // 最新投稿確認画面へ遷移
          Ok( views.html.affectionTop( "（" + user.username + "さんでログインしています）"  , user.usercategory) )
        }
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
    
  }

  // カテゴリー一覧の表示用リストを取得する
  def getCategoryListForDisplay():List[CategoryForList]={
	var categoryList:List[CategoryForList] = List.empty[CategoryForList]
    val categoryTableList:List[CategoryTable] = CategoryService.getCategoryList()
    for (item <- categoryTableList) {
      // カテゴリーIDの文字列化
      var categoryidString = ""
      item.categoryid match {
        case Some(categoryid) =>
          categoryidString = categoryid.toString
        case None =>
          //何もしない
      }
      // 日付の文字列化
      var lastupdateString = "%tY-%<tm-%<td" format item.lastupdate
      var tempCategory:CategoryForList = new CategoryForList(categoryidString , item.categoryname , lastupdateString , item.categorysort)
      categoryList = categoryList :+ tempCategory
    }
    return categoryList
  }
  
  // カテゴリーIDを一時的にcategoryTableに入れる
  def setCategoryIdforValidate(categoryId:String):Boolean={
	categoryTable = new CategoryTable(Try{categoryId.toLong}.toOption , "", ZonedDateTime.now , "")
	true
  }
  
  // カテゴリー名の重複チェック
  def validateDupulicateCategoryName(inputCategoryName:String):Boolean={
		  // 空白の場合はfalse
		  if(inputCategoryName.isEmpty()){
			  false
		  }else{
			  val checkCategoryTable = CategoryService.getCategoryByName(inputCategoryName)
			  // nullの場合はture
			  if(checkCategoryTable == null){
				true
			  // それ以外
			  }else{
			    // カテゴリーIDが元のと同じ
			    if(checkCategoryTable.categoryid == categoryTable.categoryid){
			      true
			    }else{
			      false
			    }
			  }
		  }
  }
  
  // カテゴリーソートの重複チェック
  def validateDupulicateCategorySort(inputCategorySort:String):Boolean={
		  // 空白の場合はfalse
		  if(inputCategorySort.isEmpty()){
			  false
		  }else{
			  val checkCategoryTable = CategoryService.getCategoryBySort(inputCategorySort)
              // nullの場合はture
              if(checkCategoryTable == null){
                true
              // それ以外
              }else{
                // カテゴリーIDが元のと同じ
                if(checkCategoryTable.categoryid == categoryTable.categoryid){
                  true
                }else{
                  false
                }
              }
		   }
  }
  
  // カテゴリーの削除
  def categoryDelete() = Action { implicit request: Request[AnyContent] =>
    // リクエストからhiddenのカテゴリーIDを取得
    val categoryIdParam = request.body.asFormUrlEncoded.get("categoryIdParam")(0)
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // 管理者権限のチェック
        if(user.usercategory == UserService.ADMIN_USER){
          // delete処理・成功判定
          if( CategoryService.deleteCategory(categoryIdParam) ){
            // カテゴリーの一覧をリスト取得
            var categoryList:List[CategoryForList] = getCategoryListForDisplay()
            // 正常でカテゴリー一覧画面へ遷移
            Ok( views.html.categoryList("（" + user.username + "さんでログインしています）"  , categoryList , user.usercategory ,Messages("info.category.delete")) )
          }else{
            // カテゴリーの一覧をリスト取得
            var categoryList:List[CategoryForList] = getCategoryListForDisplay()
            // エラーでカテゴリー一覧画面へ遷移
            Ok( views.html.categoryList("（" + user.username + "さんでログインしています）"  , categoryList , user.usercategory ,Messages("error.category.delete")) )
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
  
}
