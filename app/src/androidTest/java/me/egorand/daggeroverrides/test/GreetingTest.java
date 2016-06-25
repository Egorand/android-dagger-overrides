package me.egorand.daggeroverrides.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

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

    @Inject GreetingGenerator mockGreetingGenerator;

    @Before public void setUp() {
        DaggerOverridesApp app = (DaggerOverridesApp) InstrumentationRegistry.getTargetContext().getApplicationContext();
        app.graph().inject(this);
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
