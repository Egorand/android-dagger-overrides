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
