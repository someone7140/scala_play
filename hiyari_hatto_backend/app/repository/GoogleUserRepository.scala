package repository

import com.typesafe.config.ConfigFactory
import model.db.UserCollection
import org.joda.time.{DateTime, DateTimeZone}
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.{Document, MongoCollection}
import play.api.libs.json.Json

object GoogleUserRepository {

  import model.db.UserCollection._
  import repository.CommonMongoDBRepository._

  val config = ConfigFactory.load()
  val USER_COLLECTION = "user"

  // googleIdからUserを取得する
  def findUserByGoogleId(googleId: String): Option[UserCollection] = {
    val findUserByGoogleIdFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        col.find(equal("google_id", googleId)).first().results
      }
    executeCmd(USER_COLLECTION, findUserByGoogleIdFunc).collectFirst(d => {
      Json.parse(d.toJson()).validate[UserCollection].asOpt
    }).flatten
  }

  // Userを登録する
  def insertUserByGoogleId(name: String, googleId: String): Option[UserCollection] = {
    val uuid = java.util.UUID.randomUUID.toString
    val nowDate = DateTime.now(DateTimeZone.UTC)
    val userCollection = UserCollection(
      id = uuid,
      name = name,
      googleId = Some(googleId),
      authDate = Some(nowDate)
    )
    val userCollectionJson = Json.toJson(userCollection).toString()
    val insertUserByGoogleIdFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        val document = Document(userCollectionJson)
        val results = col.insertOne(document).results
        if (results.isEmpty) {
          Seq.empty
        } else {
          Seq(document)
        }
      }
    executeCmd(USER_COLLECTION, insertUserByGoogleIdFunc).collectFirst(_ => userCollection)
  }

  // Userの名前と認証日を登録する
  def updateUserNameAndAuthDate(id: String, name: String, googleId: String): Option[UserCollection] = {
    val nowDate = DateTime.now(DateTimeZone.UTC)
    val updateUserByIdFunc: MongoCollection[Document] => Seq[Document] =
      (col: MongoCollection[Document]) => {
        val results = col.updateOne(
          equal("_id", id),
          combine(set("name", name), set("auth_date", nowDate.toString()))
        ).results
        if (results.isEmpty) {
          Seq.empty
        } else {
          Seq(Document())
        }
      }
    executeCmd(USER_COLLECTION, updateUserByIdFunc).collectFirst(_ => UserCollection(
      id = id,
      name = name,
      googleId = Some(googleId),
      authDate = Some(nowDate)
    ))
  }
}
