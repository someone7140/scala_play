package model.api.hiyariHatto

import play.api.data.Form

object HiyariHattoCategoryCreateRequest {

  import play.api.data.Forms._

  val hiyariHattoCategoryCreateRequestForm = Form[HiyariHattoCategoryCreateRequest](
    mapping(
      "name" -> nonEmptyText
    )(HiyariHattoCategoryCreateRequest.apply)(HiyariHattoCategoryCreateRequest.unapply)
  )
}

case class HiyariHattoCategoryCreateRequest(name: String)
