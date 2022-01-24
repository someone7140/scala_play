package repository

import model.db.{HiyariHattoPostCollection, HiyariHattoReferenceFileForCollection, HiyariHattoReferenceUrlForCollection}
import model.domain.{HiyariHattoReferenceFile, HiyariHattoReferenceUrl}
import org.joda.time.{DateTime, DateTimeZone}
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.model.Sorts.descending
import org.mongodb.scala.{Document, MongoCollection}
import play.api.libs.json.Json

object HiyariHattoPostRepository {

  import model.db.HiyariHattoPostCollection._
  import repository.CommonMongoDBRepository._

  val POST_COLLECTION = "hiyari_hatto_post"

  def insertPost(title: String,
                 detail: Option[String],
                 userId: String,
                 categoryIds: Seq[String],
                 occurDateTime: Option[DateTime],
                 referenceUrls: Seq[HiyariHattoReferenceUrl],
                 referenceFiles: Seq[HiyariHattoReferenceFile]): Option[HiyariHattoPostCollection] = {
    val uuid = java.util.UUID.randomUUID.toString
    val nowDate = DateTime.now(DateTimeZone.UTC)
    val postCollection = HiyariHattoPostCollection(
      id = uuid,
      title = title,
      detail = detail,
      postUserId = userId,
      postDate = nowDate,
      categories = categoryIds,
      occurDate = occurDateTime,
      referenceUrls = referenceUrls.map(url =>
        HiyariHattoReferenceUrlForCollection(
          java.util.UUID.randomUUID.toString,
          url.siteName,
          url.url
        )
      ),
      referenceFiles = referenceFiles.map(file =>
        HiyariHattoReferenceFileForCollection(
          java.util.UUID.randomUUID.toString,
          file.title,
          file.fileUrl
        )
      ),
    )
    val postCollectionJson = Json.toJson(postCollection).toString()
    val insertPostFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        val document = Document(postCollectionJson)
        val results = col.insertOne(document).results
        if (results.isEmpty) {
          Seq.empty
        } else {
          Seq(document)
        }
      }
    executeCmd(POST_COLLECTION, insertPostFunc).collectFirst(_ => postCollection)
  }

  def getPostList(userId: String): Seq[HiyariHattoPostCollection] = {
    val getPostListFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        col.find(equal("post_user_id", userId))
          .sort(descending("occur_date"))
          .limit(200)
          .results
      }
    val resultDocs = executeCmd(POST_COLLECTION, getPostListFunc)

    for {
      doc <- resultDocs
      col <- Json.parse(doc.toJson()).validate[HiyariHattoPostCollection].asOpt
    } yield col

  }
}
