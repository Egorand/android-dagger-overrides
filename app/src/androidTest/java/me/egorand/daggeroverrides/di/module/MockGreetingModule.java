package me.egorand.daggeroverrides.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.egorand.daggeroverrides.model.GreetingGenerator;
import me.egorand.daggeroverrides.test.GreetingTest;
import me.egorand.daggeroverrides.ui.activity.MainActivity;

import static org.mockito.Mockito.mock;

@Module(injects = {MainActivity.class, GreetingTest.class})
public class MockGreetingModule {

    @Provides @Singleton GreetingGenerator provideGreetingGenerator() {
        return mock(GreetingGenerator.class);
    }
}
