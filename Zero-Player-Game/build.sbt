ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

ThisBuild / fork := true // Needed for ScalaFX and Akka to work well together

lazy val root = (project in file("."))
  .settings(
    name := "Zero-Player-Game"
  )
libraryDependencies += "org.scalafx" %% "scalafx" % "24.0.0-R35"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.8.5"
//libraryDependencies += "it.unibo.alice.tuprolog" % "tuprolog" % "3.3.0",