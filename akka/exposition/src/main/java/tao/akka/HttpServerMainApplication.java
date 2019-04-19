package tao.akka;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import tao.akka.equity.EquityRoutes;

import java.io.IOException;

public class HttpServerMainApplication extends AllDirectives {

    private final EquityRoutes equityRoutes;

    HttpServerMainApplication() {
        this.equityRoutes = new EquityRoutes();
    }

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("routes");

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        HttpServerMainApplication app = new HttpServerMainApplication();

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = app.createRoute().flow(system, materializer);
        http.bindAndHandle(routeFlow,
                ConnectHttp.toHost("localhost", 8080), materializer);
    }

    private Route createRoute() {
        return equityRoutes.route();
    }

}
