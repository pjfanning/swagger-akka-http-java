package com.example.akka;

import static ch.megard.akka.http.cors.javadsl.CorsDirectives.cors;

import com.fasterxml.jackson.core.JsonProcessingException;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.PathMatchers;
import akka.http.javadsl.server.Route;
import ch.megard.akka.http.cors.javadsl.settings.CorsSettings;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.jaxrs2.Reader;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;

class SwaggerDocService extends AllDirectives {
  SwaggerConfiguration readerConfig = new SwaggerConfiguration();

  Route createRoute() {
    final Route route = route(path(PathMatchers.segment("api-docs").slash("swagger.json"), () -> get(() -> complete(swaggerJson()))));
    final CorsSettings settings = CorsSettings.defaultSettings();
    return cors(settings, () -> route);
  }

  private String swaggerJson() {
    try {
      final OpenAPI openAPI = new OpenAPI();
      final Reader reader = new Reader(readerConfig.openAPI(openAPI));
      final OpenAPI swagger = reader.read(HttpServerMinimalExample.class);
      return Json.pretty().writeValueAsString(swagger);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
