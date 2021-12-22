package repository

import com.typesafe.config.ConfigFactory
import org.mongodb.scala.{Document, MongoClient, MongoCollection, Observable}

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object CommonMongoDBRepository {
  val config = ConfigFactory.load()

  implicit class DocumentObservable[C](val observable: Observable[Document]) extends ImplicitObservable[Document] {
    override val converter: (Document) => String = (doc) => doc.toJson()
  }

  implicit class GenericObservable[C](val observable: Observable[C]) extends ImplicitObservable[C] {
    override val converter: (C) => String = (doc) => doc.toString
  }

  trait ImplicitObservable[C] {
    val observable: Observable[C]
    val converter: (C) => String

    def results: Seq[C] = Await.result(observable.toFuture(), Duration(10, TimeUnit.SECONDS))
  }

  def executeCmd(collectionName: String,
                 cmdFunc: MongoCollection[Document] => Seq[Document]): Seq[Document] = {
    val mongoClient = MongoClient(config.getString("mongo.db.url"))
    val database = mongoClient.getDatabase(config.getString("mongo.db.database"))
    val collection = database.getCollection(collectionName)

    val result = cmdFunc(collection)
    mongoClient.close
    result
  }

}
