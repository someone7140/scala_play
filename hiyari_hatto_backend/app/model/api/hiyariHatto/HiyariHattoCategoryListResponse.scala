package model.api.hiyariHatto

import org.joda.time.DateTime
import play.api.libs.json.JodaReads.DefaultJodaDateTimeReads
import play.api.libs.json.JodaWrites.JodaDateTimeWrites
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json

object HiyariHattoCategoryListResponse {
  implicit val jsonWrites = Json.writes[HiyariHattoCategoryListResponse]
  implicit val jsonReads = Json.reads[HiyariHattoCategoryListResponse]
}

case class HiyariHattoCategoryListResponse(id: String, name: String, registerDateTime: DateTime)
