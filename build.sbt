ThisBuild / organization := "it.unibo.scalabluff"
ThisBuild / scalaVersion := "3.6.4"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaBluff",
    // Dipendenze test
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test,
    // (Opzionale) warning utili
    scalacOptions ++= Seq("-deprecation", "-feature")
  )
