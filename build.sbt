name := "swagger-akka-http-java"

scalaVersion := "2.13.6"

//resolvers += Resolver.sonatypeRepo("snapshots")

val akkaVersion = "2.6.17"
val akkaHttpVersion = "10.2.7"

libraryDependencies ++= Seq(
  "io.swagger.core.v3" % "swagger-jaxrs2-jakarta" % "2.1.11",
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "jakarta.ws.rs" % "jakarta.ws.rs-api" % "3.0.0",
  "ch.megard" %% "akka-http-cors" % "1.1.2",
  "org.slf4j" % "slf4j-simple" % "1.7.32"
)
