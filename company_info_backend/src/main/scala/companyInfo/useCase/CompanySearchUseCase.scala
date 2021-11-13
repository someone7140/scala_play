package companyInfo.useCase

import akka.actor.ActorSystem
import companyInfo.model.api.InitialResponse
import companyInfo.model.rest.GbizResponse
import companyInfo.rest.CompanyRestClient
import companyInfo.rest.query.CompanyQueryBuilder
import io.circe.generic.auto._
import io.circe.parser._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object CompanySearchUseCase {

  implicit val system = ActorSystem()
  implicit val executionContext = system.dispatcher

  def getInitialDisplayCompanyInfo(): Either[Throwable, InitialResponse] = {
    val sortKeys = Seq[String]("npmr", "roa", "roe", "equityRatio")
    val futureSeq = Future.sequence(sortKeys.map(k => CompanyRestClient.sendRequestToGbiz(
      CompanyQueryBuilder.getQuery(sort = k)
    )))

    val initialRes = InitialResponse()
    var exceptionSeq = Seq.empty[Throwable]

    val result = Await.ready(futureSeq, Duration.Inf).value.get
    result.foreach(seq => seq.zipWithIndex.foreach(res => {
      res._1 match {
        case Success(r) => {
          decode[GbizResponse](r) match {
            case Right(bizRes) => {
              val companyResponses = bizRes.results.bindings.map(_.convertCompanyResponse())
              if (res._2 == 0) {
                initialRes.byNpmrSortCompanies = companyResponses
              } else if (res._2 == 1) {
                initialRes.byEquityRatioCompanies = companyResponses
              } else if (res._2 == 2) {
                initialRes.byRoaCompanies = companyResponses
              } else {
                initialRes.byRoeCompanies = companyResponses
              }
            }
            case Left(ex) => exceptionSeq :+= ex
          }
        }
        case Failure(ex) => exceptionSeq :+= ex
      }
    }))

    if (exceptionSeq.isEmpty) {
      Right(initialRes)
    } else {
      Left(exceptionSeq.head)
    }
  }

}
