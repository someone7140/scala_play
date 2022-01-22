package model.db

import model.domain.{HiyariHattoPost, HiyariHattoReferenceFile, HiyariHattoReferenceUrl}
import org.joda.time.{DateTime, DateTimeZone}
import play.api.libs.json.JodaReads.DefaultJodaDateTimeReads
import play.api.libs.json.JodaWrites.JodaDateTimeWrites
import play.api.libs.functional.syntax.unlift
import play.api.libs.json._
import play.api.libs.functional.syntax._

object HiyariHattoPostCollection {

  implicit val hiyariHattoReferenceUrlForCollectionFormat = (
    (__ \ "_id").format[String] ~
      (__ \ "site_name").format[String] ~
      (__ \ "url").format[String]
    ) (HiyariHattoReferenceUrlForCollection.apply, unlift(HiyariHattoReferenceUrlForCollection.unapply))

  implicit val hiyariHattoReferenceImageForCollectionFormat = (
    (__ \ "_id").format[String] ~
      (__ \ "title").format[String] ~
      (__ \ "file_url").format[String]
    ) (HiyariHattoReferenceFileForCollection.apply, unlift(HiyariHattoReferenceFileForCollection.unapply))

  implicit val hiyariHattoPostCollectionFormat = (
    (__ \ "_id").format[String] ~
      (__ \ "title").format[String] ~
      (__ \ "detail").formatNullable[String] ~
      (__ \ "post_user_id").format[String] ~
      (__ \ "post_date").format[DateTime] ~
      (__ \ "categories").format[Seq[String]] ~
      (__ \ "occur_date").formatNullable[DateTime] ~
      (__ \ "reference_urls").format[Seq[HiyariHattoReferenceUrlForCollection]] ~
      (__ \ "reference_files").format[Seq[HiyariHattoReferenceFileForCollection]]
    ) (HiyariHattoPostCollection.apply, unlift(HiyariHattoPostCollection.unapply))

  def makeFromDomainModel(post: HiyariHattoPost): HiyariHattoPostCollection = {
    HiyariHattoPostCollection(
      id = if (post.id.isEmpty) java.util.UUID.randomUUID.toString else post.id,
      title = post.title,
      detail = post.detail,
      postUserId = post.userId,
      postDate = DateTime.now(DateTimeZone.UTC),
      categories = post.categoryIds,
      occurDate = post.occurDateTime,
      referenceUrls = post.referenceUrls.map(url =>
        HiyariHattoReferenceUrlForCollection(
          url.id.getOrElse(java.util.UUID.randomUUID.toString),
          url.siteName,
          url.url
        )
      ),
      referenceFiles = post.referenceFiles.map(image =>
        HiyariHattoReferenceFileForCollection(
          if (image.id.isEmpty) java.util.UUID.randomUUID.toString else image.id,
          image.title,
          image.fileUrl
        )
      ),
    )
  }
}

case class HiyariHattoPostCollection(id: String = "",
                                     title: String = "",
                                     detail: Option[String] = None,
                                     postUserId: String,
                                     postDate: DateTime,
                                     categories: Seq[String] = Seq.empty,
                                     occurDate: Option[DateTime],
                                     referenceUrls: Seq[HiyariHattoReferenceUrlForCollection] = Seq.empty,
                                     referenceFiles: Seq[HiyariHattoReferenceFileForCollection] = Seq.empty) {
  def transferToDomainModel(): HiyariHattoPost = {
    HiyariHattoPost(
      id = id,
      title = title,
      detail = detail,
      userId = postUserId,
      categoryIds = categories,
      occurDateTime = occurDate,
      referenceUrls = referenceUrls.map(url =>
        HiyariHattoReferenceUrl(Some(url.id), url.siteName, url.url)
      ),
      referenceFiles = referenceFiles.map(file =>
        HiyariHattoReferenceFile(file.id, file.title, file.fileUrl)
      ),
    )
  }
}

case class HiyariHattoReferenceUrlForCollection(id: String = "", siteName: String = "", url: String = "")

case class HiyariHattoReferenceFileForCollection(id: String = "", title: String, fileUrl: String)
