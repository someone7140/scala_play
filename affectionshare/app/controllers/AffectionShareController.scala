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
import commonlogic.util.CacheUtil
import play.api.cache._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class AffectionShareController @Inject()( cache: SyncCacheApi,  cc: ControllerComponents ) extends AbstractController(cc) with I18nSupport {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  

  // 最新投稿確認画面の表示
  def displayAffectionTop() = Action { implicit request =>
    // セッションのチェック
    CacheUtil.getSessionUser(cache , request.session.get("sessionKey")) match {
      case Some(user) =>
        // Cacheのセッションの時間を更新するため再セット
        CacheUtil.setSessionUser(cache, user , request.session.get("sessionKey"))
        // 最新投稿確認画面へ遷移
        Ok( views.html.affectionTop( "（" + user.username + "さんでログインしています）"  , user.usercategory) )
      case None =>
        // ログイン画面へ遷移
        Redirect("./login")
    }
  }
  
  
}
