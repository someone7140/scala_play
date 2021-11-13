package companyInfo.rest

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{FormData, HttpMethods, HttpRequest}
import akka.http.scaladsl.unmarshalling.Unmarshal

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object CompanyRestClient {

  implicit val system = ActorSystem()
  implicit val executionContext = system.dispatcher

  val GBIZ_URL = "https://api.info.gbiz.go.jp/sparql"

  def sendRequestToGbiz(query: String)(implicit ec: ExecutionContext): Future[Try[String]] = {
    val req = HttpRequest(
      method = HttpMethods.POST,
      uri = GBIZ_URL,
      entity = FormData("query" -> query).toEntity
    )
    Http().singleRequest(req)
      .map(res => Success(Await.result(Unmarshal(res.entity).to[String], Duration.Inf))
    ).recover { case e => Failure(e) }
  }

}
