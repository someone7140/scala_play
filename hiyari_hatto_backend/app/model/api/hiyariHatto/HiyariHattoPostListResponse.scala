package model.api.hiyariHatto

import model.domain.{HiyariHattoReferenceFile, HiyariHattoReferenceUrl}
import org.joda.time.DateTime
import play.api.libs.json.JodaReads.DefaultJodaDateTimeReads
import play.api.libs.json.JodaWrites.JodaDateTimeWrites
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json

object HiyariHattoPostListResponse {
  implicit val jsonWrites = Json.writes[HiyariHattoPostListResponse]
  implicit val jsonReads = Json.reads[HiyariHattoPostListResponse]
}


case class HiyariHattoPostListResponse(id: String,
                                       title: String,
                                       detail: Option[String],
                                       userId: String,
                                       categoryIds: Seq[String],
                                       occurDateTime: Option[DateTime],
                                       referenceUrls: Seq[HiyariHattoReferenceUrl],
                                       referenceFiles: Seq[HiyariHattoReferenceFile])
