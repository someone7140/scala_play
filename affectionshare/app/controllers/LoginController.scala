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
import commonlogic.logicservice.tablemodel.LoginUserTable
import models.LoginUser
import commonlogic.logicservice.UserService
import play.api.cache._
import models.LoginUser
import commonlogic.util.CacheUtil
import java.util.UUID

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class LoginController @Inject()( cache: SyncCacheApi, cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  var loginUserTable:LoginUserTable = null
  
  // ログインフォーム
  // 空白チェックにオリジナルメッセージを設定してみる
  val loginUserForm = Form( mapping("userid" -> text.verifying("ユーザIDを入力してください" , {!_.isEmpty()}) 
                                                    .verifying("ユーザが未登録・もしくは利用停止の状態です。", validateUser(_) )
      , 
                                    "userpw" -> text.verifying("パスワードを入力してください" , {!_.isEmpty()})
                                                    .verifying("パスワードが登録されているものと異なります。",validatePw(_))
                                    )
                                    (LoginUser.apply)(LoginUser.unapply) 


                           )
  
  // ユーザのチェック
  def validateUser(inputUserid:String):Boolean={
		  // 空白の場合はfalse
		  if(inputUserid.isEmpty()){
			  false
		  }else{
			  loginUserTable = UserService.getUserIdObject(inputUserid)
				// null・もしくは利用区分が停止の場合はfalse
				if(loginUserTable == null || loginUserTable.usercategory == UserService.STOP_USER){
					false
				// それ以外はtrue
				}else{
					true
				}
		  }

  }

  // パスワードのチェック
  def validatePw(inputUserPw:String):Boolean={
		  // PWが空白・ユーザオブジェクトがnullの場合はfalse
		  if(inputUserPw.isEmpty() || loginUserTable == null){
			  false
		  }else{
				//PWがオブジェクトのものと違う場合はfalse
				if(inputUserPw != loginUserTable.userpw){
					false
				// それ以外はtrue
				}else{
					true
				}
		  }

  }
  
  // ログイン画面の初期表示
  def loginInit() = Action { implicit request =>
     // セッションを初期化してログイン画面へ遷移
     CacheUtil.deleteSessionUser(cache , request.session.get("sessionKey"))
     Ok( views.html.login(loginUserForm) ).withNewSession
  }
  
  // ログイン画面のSubmit
  def loginSubmit() = Action { implicit request: Request[AnyContent] =>
     loginUserForm.bindFromRequest.fold(
         // 入力チェックNG
         errors => {           
           BadRequest( views.html.login(errors) )
         },
         // 入力チェックOK
         success => {
           // ログイン日時の更新
           UserService.updateLastLogin(loginUserTable.userid)
           // セッションキーを設定
           val sessionKey = UUID.randomUUID().toString;
           //CacheにUserをセット
           CacheUtil.setSessionUser(cache, loginUserTable ,sessionKey)
           // セッションにユーザをセットしてTop画面へ遷移
           Redirect("./affectionTop").withSession("sessionKey" -> sessionKey)
         }
         
     )
     
     
  }
  
  


}
