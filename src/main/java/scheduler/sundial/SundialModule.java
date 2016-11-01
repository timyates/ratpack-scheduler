package scheduler.sundial;

import com.google.inject.AbstractModule;

public class SundialModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SundialService.class).asEagerSingleton();
    }
}
