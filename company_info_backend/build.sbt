name := "company_info_backend"
version := "0.1"
scalaVersion := "2.13.6"

libraryDependencies ++= {
  val akkaHttpV      = "10.2.6"
  val akkaV          = "2.6.17"
  val scalaTestV     = "3.2.10"
  val circeV         = "0.14.1"
  val akkaHttpCirceV = "1.38.2"

  Seq(
    "io.circe"          %% "circe-core" % circeV,
    "io.circe"          %% "circe-parser" % circeV,
    "io.circe"          %% "circe-generic" % circeV,
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  ) ++ Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "de.heikoseeberger" %% "akka-http-circe" % akkaHttpCirceV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % "test"
  )

}
