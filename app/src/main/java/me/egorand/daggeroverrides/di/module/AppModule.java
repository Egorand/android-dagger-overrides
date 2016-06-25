package me.egorand.daggeroverrides.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import me.egorand.daggeroverrides.DaggerOverridesApp;
import me.egorand.daggeroverrides.di.qualifier.AppScope;

@Module(library = true)
public class AppModule {

    private final DaggerOverridesApp app;

    public AppModule(DaggerOverridesApp app) {
        this.app = app;
    }

    @Provides @AppScope Context provideAppContext() {
        return app;
    }
}
