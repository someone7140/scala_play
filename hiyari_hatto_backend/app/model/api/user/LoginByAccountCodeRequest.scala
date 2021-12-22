package model.api.user

import play.api.data.Form

object LoginByAccountCodeRequest {

  import play.api.data.Forms._

  val loginByAccountCodeRequestForm = Form[LoginByAccountCodeRequest](
    mapping(
      "accountCode" -> nonEmptyText
    )(LoginByAccountCodeRequest.apply)(LoginByAccountCodeRequest.unapply)
  )

}

case class LoginByAccountCodeRequest(accountCode: String)
