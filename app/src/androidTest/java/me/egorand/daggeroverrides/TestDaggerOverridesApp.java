package me.egorand.daggeroverrides;

import dagger.ObjectGraph;
import me.egorand.daggeroverrides.di.module.AppModule;
import me.egorand.daggeroverrides.di.module.MockGreetingModule;

public class TestDaggerOverridesApp extends DaggerOverridesApp {

    private ObjectGraph graph;

    @Override public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(
                new AppModule(this),
                new MockGreetingModule());
    }

    @Override public ObjectGraph graph() {
        return graph;
    }
}
