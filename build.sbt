name := "kt-scala-akka-demo"
version := "0.1"
scalaVersion := "2.12.8"

val akkaVersion = "2.5.19"
val akkaHttVersion = "10.1.7"
libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,

  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
)