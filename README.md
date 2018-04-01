# swagger-akka-http-java

Sample Java-based Akka-HTTP application that exposes its API as Swagger JSON. The sample now supports Swagger 2.0 / OpenAPI 3.0.

This sample is standalone while https://github.com/pjfanning/swagger-akka-http-sample-java uses https://github.com/swagger-akka-http/swagger-akka-http.

```sbt run```

curl http://localhost:8080/hello

curl http://localhost:8080/api-docs/swagger.json

## Swagger 1.5 / OpenAPI 2.0

See https://github.com/pjfanning/swagger-akka-http-java/tree/swagger-1.5 for a version of this sample that uses swagger 1.5.X to produce OpenAPI 2.0 docs.
