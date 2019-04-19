package tao.akka.equity;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class EquityRoutes extends AllDirectives {
    public Route route() {
        return route(
                welcome(),
                path("tao/akka/equity", () -> get(
                        ()-> complete("a")
                ))
        );
    }

    private Route welcome() {
        return path("hello", () ->
                get(() -> complete("<h1>Say hello to akka-http</h1>"))
        );
    }
}
