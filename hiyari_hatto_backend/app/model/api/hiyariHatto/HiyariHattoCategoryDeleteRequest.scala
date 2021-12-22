package model.api.hiyariHatto

import play.api.data.Form

object HiyariHattoCategoryDeleteRequest {

  import play.api.data.Forms._

  val hiyariHattoCategoryDeleteRequestForm = Form[HiyariHattoCategoryDeleteRequest](
    mapping(
      "id" -> nonEmptyText
    )(HiyariHattoCategoryDeleteRequest.apply)(HiyariHattoCategoryDeleteRequest.unapply)
  )
}

case class HiyariHattoCategoryDeleteRequest(id:String)
