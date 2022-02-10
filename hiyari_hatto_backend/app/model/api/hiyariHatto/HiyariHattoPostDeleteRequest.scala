package model.api.hiyariHatto

import play.api.data.Form

object HiyariHattoPostDeleteRequest {

  import play.api.data.Forms._

  val hiyariHattoPostDeleteRequestForm = Form[HiyariHattoPostDeleteRequest](
    mapping(
      "id" -> nonEmptyText
    )(HiyariHattoPostDeleteRequest.apply)(HiyariHattoPostDeleteRequest.unapply)
  )
}

case class HiyariHattoPostDeleteRequest(id:String)
