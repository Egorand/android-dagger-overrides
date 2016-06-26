/*
 * Copyright 2016 Egor Andreevici
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.egorand.daggeroverrides;

import me.egorand.daggeroverrides.di.component.AppComponent;
import me.egorand.daggeroverrides.di.component.DaggerAppComponent;
import me.egorand.daggeroverrides.di.module.AppModule;
import me.egorand.daggeroverrides.model.GreetingGenerator;

import static org.mockito.Mockito.mock;

public class TestDaggerOverridesApp extends DaggerOverridesApp {

    private AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this) {

                    final GreetingGenerator mockGreetingGenerator = mock(GreetingGenerator.class);

                    @Override public GreetingGenerator provideGreetingGenerator() {
                        return mockGreetingGenerator;
                    }
                })
                .build();
    }

    @Override public AppComponent appComponent() {
        return appComponent;
    }
}
