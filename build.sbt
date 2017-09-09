name := "swagger-akka-http-java"

scalaVersion := "2.12.3"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.5.4"
val akkaHttpVersion = "10.0.10"

libraryDependencies ++= Seq(
  "io.swagger" % "swagger-jaxrs2" % "2.0.0-rc1",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.megard" %% "akka-http-cors" % "0.2.1",
  "org.slf4j" % "slf4j-simple" % "1.7.25"
)
