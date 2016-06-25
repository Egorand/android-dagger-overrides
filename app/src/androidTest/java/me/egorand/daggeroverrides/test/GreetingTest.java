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

package me.egorand.daggeroverrides.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.egorand.daggeroverrides.DaggerOverridesApp;
import me.egorand.daggeroverrides.R;
import me.egorand.daggeroverrides.model.GreetingGenerator;
import me.egorand.daggeroverrides.ui.activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class GreetingTest {

    @Rule public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    private GreetingGenerator mockGreetingGenerator;

    @Before public void setUp() {
        DaggerOverridesApp app = (DaggerOverridesApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        mockGreetingGenerator = app.graph().get(GreetingGenerator.class);
    }

    @Test public void shouldGenerateCorrectGreeting() {
        String name = "Joe";
        String greeting = "Hi Joe!";
        when(mockGreetingGenerator.generateGreeting(name)).thenReturn(greeting);

        onView(withId(R.id.name_input)).perform(typeText(name));
        onView(withText(R.string.greet)).perform(click());

        onView(withId(R.id.console)).check(matches(withText(greeting)));
    }
}
