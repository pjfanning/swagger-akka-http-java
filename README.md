# swagger-akka-http-java

Sample Java-based Akka-HTTP application that exposes its API as Swagger JSON.

This sample is standalone while https://github.com/pjfanning/swagger-akka-http-sample-java uses https://github.com/swagger-akka-http/swagger-akka-http.

```sbt run```

curl http://localhost:8080/hello

curl http://localhost:8080/api-docs/swagger.json

## Swagger 2.0 / OpenAPI 3.0

See https://github.com/pjfanning/swagger-akka-http-java/tree/swagger-2.0 for a version of this sample that uses swagger 2.0.0-rc1 to produce OpenAPI 3.0 docs.
