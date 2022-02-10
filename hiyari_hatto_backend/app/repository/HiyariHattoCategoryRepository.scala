package repository

import model.db.HiyariHattoCategoryCollection
import org.joda.time.{DateTime, DateTimeZone}
import org.mongodb.scala.model.Filters.{and, equal}
import org.mongodb.scala.model.Sorts.descending
import org.mongodb.scala.model.Updates.set
import org.mongodb.scala.{Document, MongoCollection}
import play.api.libs.json.Json

object HiyariHattoCategoryRepository {

  import model.db.HiyariHattoCategoryCollection._
  import repository.CommonMongoDBRepository._

  val CATEGORY_COLLECTION = "hiyari_hatto_category"

  def insertCategory(name: String, userId: String): Option[HiyariHattoCategoryCollection] = {
    val uuid = java.util.UUID.randomUUID.toString
    val nowDate = DateTime.now(DateTimeZone.UTC)
    val categoryCollection = HiyariHattoCategoryCollection(
      id = uuid,
      name = name,
      registerUserId = userId,
      registerDate = nowDate
    )
    val categoryCollectionJson = Json.toJson(categoryCollection).toString()
    val insertCategoryFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        val document = Document(categoryCollectionJson)
        val results = col.insertOne(document).results
        if (results.isEmpty) {
          Seq.empty
        } else {
          Seq(document)
        }
      }
    executeCmd(CATEGORY_COLLECTION, insertCategoryFunc).collectFirst(_ => categoryCollection)
  }

  def updateCategory(id:String, name: String, userId: String): Option[HiyariHattoCategoryCollection]  = {
    val updateCategoryByIdFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        val results = col.updateOne(
          and(equal("_id", id), equal("register_user_id", userId)),
          set("name", name)
        ).results
        if (results.isEmpty) {
          Seq.empty
        } else {
          Seq(Document())
        }
      }
    executeCmd(CATEGORY_COLLECTION, updateCategoryByIdFunc).collectFirst(_ => HiyariHattoCategoryCollection(
      id = id,
      name = name,
      registerUserId = userId
    ))
  }

  def deleteCategory(id:String, userId: String): Boolean = {
    val deleteCategoryByIdFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        val results = col.deleteOne(
          and(equal("_id", id), equal("register_user_id", userId))
        ).results
        if (results.isEmpty) {
          Seq.empty
        } else {
          Seq(Document())
        }
      }
    executeCmd(CATEGORY_COLLECTION, deleteCategoryByIdFunc).collectFirst(_ => true).getOrElse(false)
  }

  def getCategoryList(userId: String): Seq[HiyariHattoCategoryCollection] = {
    val getCategoryListFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        col.find(equal("register_user_id", userId)).sort(descending("register_date")).results
      }
    val resultDocs = executeCmd(CATEGORY_COLLECTION, getCategoryListFunc)

    for {
      doc <- resultDocs
      col <- Json.parse(doc.toJson()).validate[HiyariHattoCategoryCollection].asOpt
    } yield col

  }
}
