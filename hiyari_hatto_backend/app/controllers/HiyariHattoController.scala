package controllers

import model.api.hiyariHatto.{HiyariHattoCategoryListResponse, HiyariHattoPostListResponse}
import org.joda.time.DateTimeZone
import play.api.i18n.I18nSupport
import play.api.libs.json.Json

import javax.inject._
import play.api.mvc._
import useCase.GoogleCloudStorageUseCase

@Singleton
class HiyariHattoController @Inject()(val controllerComponents: ControllerComponents, val env: play.api.Environment) extends BaseController with I18nSupport {

  import model.api.hiyariHatto.HiyariHattoCategoryCreateRequest.hiyariHattoCategoryCreateRequestForm
  import model.api.hiyariHatto.HiyariHattoCategoryDeleteRequest.hiyariHattoCategoryDeleteRequestForm
  import model.api.hiyariHatto.HiyariHattoCategoryUpdateRequest.hiyariHattoCategoryUpdateRequestForm
  import model.api.hiyariHatto.HiyariHattoPostCreateRequest.hiyariHattoPostCreateRequestForm
  import useCase.AuthUserUseCase.withUser
  import useCase.HiyariHattoUseCase._

  def createPost() = Action(parse.multipartFormData) { implicit request =>
    withUser { authUser => {
      hiyariHattoPostCreateRequestForm.bindFromRequest().fold(
        errors => BadRequest(errors.errorsAsJson),
        form => {
          val imageUploadResult =
            GoogleCloudStorageUseCase.uploadFilesToGcs(request.body.files, form.referenceFileTitles, env)
          imageUploadResult.fold(
            e => InternalServerError(e.getMessage()),
            images => {
              createHiyariHattoPost(
                form.title,
                form.detail,
                authUser.id,
                form.categoryIds,
                form.occurDateTime.map(d => d.withZone(DateTimeZone.UTC)),
                form.referenceUrls,
                images
              ).fold(InternalServerError("Failed create"))(_ => Ok)
            })
        }
      )
    }
    }
  }

  def listPost() = Action { implicit request: Request[AnyContent] =>
    withUser { authUser => {
      val posts = listHiyariHattoPost(authUser.id).map(p => {
        HiyariHattoPostListResponse(
          p.id,
          p.title,
          p.detail,
          p.userId,
          p.categoryIds,
          p.occurDateTime,
          p.referenceUrls,
          p.referenceFiles
        )
      })
      Ok(Json.toJson(posts))
    }
    }
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

}
