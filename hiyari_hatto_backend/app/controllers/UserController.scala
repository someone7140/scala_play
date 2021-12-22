package controllers

import play.api.i18n.I18nSupport
import play.api.libs.json.Json
import play.api.mvc._

import model.api.user.LoginResponse

import javax.inject._

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents) extends BaseController with I18nSupport {

  import model.api.user.LoginByAccountCodeRequest.loginByAccountCodeRequestForm
  import useCase.AuthUserUseCase._

  def loginByAccountCode() = Action { implicit request: Request[AnyContent] =>
    loginByAccountCodeRequestForm.bindFromRequest().fold(
      errors => BadRequest(errors.errorsAsJson),
      form => {
        authByGoogleAuthCode(form.accountCode).fold(InternalServerError("Failed authentication"))(u =>
          Ok(Json.toJson(LoginResponse(
            u.name,
            u.getToken()
          )))
        )
      }
    )
  }

  def loginCheckByToken() = Action { implicit request: Request[AnyContent] =>
    withUser { authUser => {
      Ok(Json.toJson(LoginResponse(
        authUser.name,
        authUser.getToken()
      )))
    }
    }
  }
}
