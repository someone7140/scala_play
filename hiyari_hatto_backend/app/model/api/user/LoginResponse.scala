package model.api.user

import play.api.libs.json.Json

case class LoginResponse(name: String = "", token: String = "")

object LoginResponse {
  implicit val jsonWrites = Json.writes[LoginResponse]
}
