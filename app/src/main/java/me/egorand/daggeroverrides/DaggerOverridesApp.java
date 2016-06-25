package me.egorand.daggeroverrides;

import android.app.Application;

import dagger.ObjectGraph;
import me.egorand.daggeroverrides.di.module.AppModule;
import me.egorand.daggeroverrides.di.module.GreetingModule;

public class DaggerOverridesApp extends Application {

    private ObjectGraph graph;

    @Override public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(
                new AppModule(this),
                new GreetingModule());
    }

    public ObjectGraph graph() {
        return graph;
    }
}
