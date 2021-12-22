package model.api.hiyariHatto

import model.domain.ReferenceUrl
import org.joda.time.DateTime
import play.api.data.Form

object HiyariHattoPostRegsiterRequest {

  import play.api.data.Forms._
  import play.api.data.JodaForms._

  val hiyariHattoRegsiterRequestForm = Form[HiyariHattoPostRegsiterRequest](
    mapping(
      "title" -> nonEmptyText,
      "detail" -> text,
      "categoryIds" -> seq(text),
      "occurDateTime" -> jodaDate,
      "referenceUrls" -> seq(mapping(
        "id" -> text,
        "siteName" -> nonEmptyText,
        "url" -> nonEmptyText
      )(ReferenceUrl.apply)(ReferenceUrl.unapply)),
      "referenceImageTitles" -> seq(text),
      "deleteUrlIds" -> seq(text),
      "deleteImageIds" -> seq(text)
    )(HiyariHattoPostRegsiterRequest.apply)(HiyariHattoPostRegsiterRequest.unapply)
  )
}

case class HiyariHattoPostRegsiterRequest(title: String,
                                          detail: String,
                                          categoryIds: Seq[String],
                                          occurDateTime: DateTime,
                                          referenceUrls: Seq[ReferenceUrl],
                                          referenceImageTitles: Seq[String],
                                          deleteUrlIds: Seq[String],
                                          deleteImageIds: Seq[String]
                                         )
