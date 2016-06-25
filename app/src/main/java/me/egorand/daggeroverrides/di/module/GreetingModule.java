package me.egorand.daggeroverrides.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.egorand.daggeroverrides.model.GreetingGenerator;
import me.egorand.daggeroverrides.model.HelloGreetingGenerator;
import me.egorand.daggeroverrides.ui.activity.MainActivity;

@Module(injects = MainActivity.class)
public class GreetingModule {

    @Provides @Singleton GreetingGenerator provideGreetingGenerator() {
        return new HelloGreetingGenerator();
    }
}
