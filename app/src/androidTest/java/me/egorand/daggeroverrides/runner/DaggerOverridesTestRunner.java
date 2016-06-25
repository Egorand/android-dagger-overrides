package me.egorand.daggeroverrides.runner;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import me.egorand.daggeroverrides.TestDaggerOverridesApp;

public class DaggerOverridesTestRunner extends AndroidJUnitRunner {

    @Override public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String testAppClassName = TestDaggerOverridesApp.class.getCanonicalName();
        return super.newApplication(cl, testAppClassName, context);
    }
}
