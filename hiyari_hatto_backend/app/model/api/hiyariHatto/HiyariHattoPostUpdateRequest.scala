package model.api.hiyariHatto

import model.domain.HiyariHattoReferenceUrl
import org.joda.time.DateTime
import play.api.data.Form

object HiyariHattoPostUpdateRequest {

  import play.api.data.Forms._
  import play.api.data.JodaForms._

  val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

  val hiyariHattoPostUpdateRequestForm = Form[HiyariHattoPostUpdateRequest](
    mapping(
      "id" -> nonEmptyText,
      "title" -> nonEmptyText,
      "detail" -> optional(text),
      "categoryIds" -> seq(text),
      "occurDateTime" -> optional(jodaDate(dateFormat)),
      "referenceUrls" -> seq(mapping(
        "id" -> optional(text),
        "siteName" -> nonEmptyText,
        "url" -> nonEmptyText
      )(HiyariHattoReferenceUrl.apply)(HiyariHattoReferenceUrl.unapply)),
      "referenceFileInfos" -> seq(mapping(
        "id" -> optional(text),
        "title" -> nonEmptyText,
        "fileUpdateFlag" -> optional(text),
      )(HiyariHattoReferenceFileForUpdate.apply)(HiyariHattoReferenceFileForUpdate.unapply)),
    )(HiyariHattoPostUpdateRequest.apply)(HiyariHattoPostUpdateRequest.unapply)
  )
}

case class HiyariHattoPostUpdateRequest(id: String,
                                        title: String,
                                        detail: Option[String],
                                        categoryIds: Seq[String],
                                        occurDateTime: Option[DateTime],
                                        referenceUrls: Seq[HiyariHattoReferenceUrl],
                                        referenceFileInfos: Seq[HiyariHattoReferenceFileForUpdate]
                                       )

case class HiyariHattoReferenceFileForUpdate(id: Option[String],
                                             title: String = "",
                                             fileUpdateFlag: Option[String])