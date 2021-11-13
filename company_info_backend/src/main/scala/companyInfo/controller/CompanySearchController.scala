package companyInfo.controller

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, failWith}
import akka.http.scaladsl.server.StandardRoute
import companyInfo.model.api.{CompanyResponse, InitialResponse}
import companyInfo.useCase.CompanySearchUseCase
import io.circe.Encoder
import io.circe.generic.semiauto.deriveEncoder
import io.circe.syntax._

object CompanySearchController {

  implicit val encodeCompanyResponse: Encoder[CompanyResponse] = deriveEncoder[CompanyResponse]
  implicit val encodeInitialResponse: Encoder[InitialResponse] = deriveEncoder[InitialResponse]

  def getInitialCompanyFetch(): StandardRoute = {

    CompanySearchUseCase.getInitialDisplayCompanyInfo() match {
      case Left(ex) => failWith(ex)
      case Right(initialRes) =>
        val res = initialRes.asJson
        complete(HttpEntity(
          ContentTypes.`application/json`,
          s"$res"
        ))
    }
  }

}
