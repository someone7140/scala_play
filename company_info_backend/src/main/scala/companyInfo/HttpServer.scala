package companyInfo

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import companyInfo.controller.CompanySearchController

import scala.concurrent.ExecutionContext

object HttpServer {

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem()
    implicit val executor: ExecutionContext = system.dispatcher

    val routes =
      path("initialCompanyFetch") {
        get {
          CompanySearchController.getInitialCompanyFetch()
        }
      }

    val host = "localhost"
    val port = 8080

    Http().newServerAt(host, port).bindFlow(routes)
  }

}
