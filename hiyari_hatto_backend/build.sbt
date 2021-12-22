name := """hiyari_hatto_backend"""
organization := "com.hiyariHatto"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.7"

libraryDependencies += guice
libraryDependencies += "com.github.jwt-scala" %% "jwt-core" % "9.0.2"
libraryDependencies += "com.google.api-client" % "google-api-client" % "1.32.2"
libraryDependencies += "com.google.apis" % "google-api-services-oauth2" % "v2-rev157-1.25.0"
libraryDependencies += "com.google.cloud" % "google-cloud-storage" % "2.2.1"
libraryDependencies += "com.typesafe.play" %% "play-joda-forms" % "2.8.8"
libraryDependencies += "com.typesafe.play" %% "play-json-joda" % "2.10.0-RC5"
libraryDependencies += "joda-time" % "joda-time" % "2.10.13"
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.4.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.hiyariHatto.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.hiyariHatto.binders._"
