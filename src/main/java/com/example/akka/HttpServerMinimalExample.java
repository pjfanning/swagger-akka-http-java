package com.example.akka;

import static ch.megard.akka.http.cors.javadsl.CorsDirectives.cors;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.ContentTypes;
import akka.http.javadsl.model.HttpEntities;
import akka.http.javadsl.model.HttpEntity;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import ch.megard.akka.http.cors.javadsl.settings.CorsSettings;
import io.swagger.oas.annotations.Operation;
import io.swagger.oas.annotations.media.Content;
import io.swagger.oas.annotations.responses.ApiResponse;

@Path("/")
public class HttpServerMinimalExample extends AllDirectives {

  public static void main(String[] args) throws Exception {
    // boot up server using the route as defined below
    ActorSystem system = ActorSystem.create("routes");

    final Http http = Http.get(system);
    final ActorMaterializer materializer = ActorMaterializer.create(system);

    // In order to access all directives we need an instance where the routes
    // are define.
    HttpServerMinimalExample app = new HttpServerMinimalExample();

    final Route routes = app.route(app.createRoute(), new SwaggerDocService().createRoute());
    final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = routes.flow(system, materializer);
    final CompletionStage<ServerBinding> binding = http.bindAndHandle(routeFlow, ConnectHttp.toHost("localhost", 8080), materializer);

    System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
    System.in.read(); // let it run until user presses return

    binding.thenCompose(ServerBinding::unbind) // trigger unbinding from the port
        .thenAccept(unbound -> system.terminate()); // and shutdown when done
  }

  @GET
  @Path("/hello")
  @Produces("text/html")
  @Operation(summary = "hello", description = "hello",
    responses = {
      @ApiResponse(responseCode = "200", description = "HTML response", content = @Content(mediaType = "text/html")),
      @ApiResponse(responseCode = "500", description = "Internal server error")
    })
  public Route createRoute() {
    HttpEntity.Strict entity = HttpEntities.create(ContentTypes.TEXT_HTML_UTF8, "<h1>Say hello to akka-http</h1>");
    final Route route = route(path("hello", () -> get(() -> complete(entity))));
    final CorsSettings settings = CorsSettings.defaultSettings();
    return cors(settings, () -> route);
  }
}