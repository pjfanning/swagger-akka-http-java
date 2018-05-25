name := "swagger-akka-http-java"

scalaVersion := "2.12.6"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.5.12"
val akkaHttpVersion = "10.1.1"

libraryDependencies ++= Seq(
  "io.swagger.core.v3" % "swagger-jaxrs2" % "2.0.2",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "javax.ws.rs" % "javax.ws.rs-api" % "2.0.1",
  "ch.megard" %% "akka-http-cors" % "0.3.0",
  "org.slf4j" % "slf4j-simple" % "1.7.25"
)
