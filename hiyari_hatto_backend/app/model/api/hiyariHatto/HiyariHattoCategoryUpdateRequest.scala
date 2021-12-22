package model.api.hiyariHatto

import play.api.data.Form

object HiyariHattoCategoryUpdateRequest {

  import play.api.data.Forms._

  val hiyariHattoCategoryUpdateRequestForm = Form[HiyariHattoCategoryUpdateRequest](
    mapping(
      "id" -> nonEmptyText,
      "name" -> nonEmptyText
    )(HiyariHattoCategoryUpdateRequest.apply)(HiyariHattoCategoryUpdateRequest.unapply)
  )
}

case class HiyariHattoCategoryUpdateRequest(id:String, name: String)
