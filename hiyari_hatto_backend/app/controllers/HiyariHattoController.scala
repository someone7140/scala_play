package controllers

import model.api.hiyariHatto.HiyariHattoCategoryListResponse
import play.api.i18n.I18nSupport
import play.api.libs.json.Json

import javax.inject._
import play.api.mvc._

@Singleton
class HiyariHattoController @Inject()(val controllerComponents: ControllerComponents) extends BaseController with I18nSupport {

  import model.api.hiyariHatto.HiyariHattoCategoryCreateRequest.hiyariHattoCategoryCreateRequestForm
  import model.api.hiyariHatto.HiyariHattoCategoryDeleteRequest.hiyariHattoCategoryDeleteRequestForm
  import model.api.hiyariHatto.HiyariHattoCategoryUpdateRequest.hiyariHattoCategoryUpdateRequestForm
  import model.api.hiyariHatto.HiyariHattoPostRegsiterRequest.hiyariHattoRegsiterRequestForm
  import useCase.AuthUserUseCase.withUser
  import useCase.HiyariHattoUseCase._

  def createPost() = Action(parse.multipartFormData) { implicit request =>
    hiyariHattoRegsiterRequestForm.bindFromRequest().fold(
      errors => BadRequest(errors.errorsAsJson),
      form => {
        Ok("Hello")
      }
    )
  }

  def createCategory() = Action { implicit request: Request[AnyContent] =>
    withUser { authUser => {
      hiyariHattoCategoryCreateRequestForm.bindFromRequest().fold(
        errors => BadRequest(errors.errorsAsJson),
        form => {
          createHiyariHattoCategory(form, authUser).fold(InternalServerError("Failed create"))(_ => Ok)
        }
      )
    }
    }
  }

  def updateCategory() = Action { implicit request: Request[AnyContent] =>
    withUser { authUser => {
      hiyariHattoCategoryUpdateRequestForm.bindFromRequest().fold(
        errors => BadRequest(errors.errorsAsJson),
        form => {
          updateHiyariHattoCategory(
            form.id, form.name, authUser.id
          ).fold(InternalServerError("Failed update"))(_ => Ok)
        }
      )
    }
    }
  }

  def deleteCategory() = Action { implicit request: Request[AnyContent] =>
    withUser { authUser => {
      hiyariHattoCategoryDeleteRequestForm.bindFromRequest().fold(
        errors => BadRequest(errors.errorsAsJson),
        form => {
          if (deleteHiyariHattoCategory(form.id, authUser.id)) Ok else InternalServerError("Failed delete")
        }
      )
    }
    }
  }

  def listCategory() = Action { implicit request: Request[AnyContent] =>
    withUser { authUser => {
      val categories = listHiyariHattoCategory(authUser.id).map(c => {
        HiyariHattoCategoryListResponse(
          c.id, c.name, c.registerDateTime
        )
      })
      Ok(Json.toJson(categories))
    }
    }
  }

  def list() = Action { implicit request: Request[AnyContent] =>
    Ok("Hello")
  }
}