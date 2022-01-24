package model.domain

import play.api.libs.json.Json

object HiyariHattoReferenceUrl {
  implicit val jsonWrites = Json.writes[HiyariHattoReferenceUrl]
  implicit val jsonReads = Json.reads[HiyariHattoReferenceUrl]
}

case class HiyariHattoReferenceUrl(id: Option[String] = None,
                                   siteName: String = "",
                                   url: String = "")
