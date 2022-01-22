package model.api.hiyariHatto

import model.domain.HiyariHattoReferenceUrl
import org.joda.time.DateTime
import play.api.data.Form

object HiyariHattoPostCreateRequest {

  import play.api.data.Forms._
  import play.api.data.JodaForms._

  val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

  val hiyariHattoPostCreateRequestForm = Form[HiyariHattoPostCreateRequest](
    mapping(
      "title" -> nonEmptyText,
      "detail" -> optional(text),
      "categoryIds" -> seq(text),
      "occurDateTime" -> optional(jodaDate(dateFormat)),
      "referenceUrls" -> seq(mapping(
        "id" -> optional(text),
        "siteName" -> nonEmptyText,
        "url" -> nonEmptyText
      )(HiyariHattoReferenceUrl.apply)(HiyariHattoReferenceUrl.unapply)),
      "referenceFileTitles" -> seq(text),
    )(HiyariHattoPostCreateRequest.apply)(HiyariHattoPostCreateRequest.unapply)
  )
}

case class HiyariHattoPostCreateRequest(title: String,
                                        detail: Option[String],
                                        categoryIds: Seq[String],
                                        occurDateTime: Option[DateTime],
                                        referenceUrls: Seq[HiyariHattoReferenceUrl],
                                        referenceFileTitles: Seq[String]
                                         )
