package scheduler;

import ratpack.func.Action;
import ratpack.func.Function;
import ratpack.guice.Guice;
import ratpack.handling.Chain;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;
import scheduler.sundial.SundialModule;

public class Main {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(spec ->
                spec.registry(getRegistry())
                        .handlers(getHandlers())
        );
    }

    private static Action<Chain> getHandlers() {
        return chain -> chain.all(ctx -> ctx.render("Hi"));
    }

    private static Function<Registry, Registry> getRegistry() {
        return Guice.registry(bindings -> bindings.module(SundialModule.class));
    }
}
