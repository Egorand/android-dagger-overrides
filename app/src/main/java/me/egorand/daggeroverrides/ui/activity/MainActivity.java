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

package me.egorand.daggeroverrides.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import me.egorand.daggeroverrides.DaggerOverridesApp;
import me.egorand.daggeroverrides.R;
import me.egorand.daggeroverrides.model.GreetingGenerator;

public class MainActivity extends AppCompatActivity {

    @Inject GreetingGenerator greetingGenerator;

    private EditText nameInput;
    private TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerOverridesApp) getApplication()).graph().inject(this);

        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.name_input);
        console = (TextView) findViewById(R.id.console);
    }

    public void onGenerateGreeting(View view) {
        String name = nameInput.getText().toString();
        console.setText(greetingGenerator.generateGreeting(name));
    }
}
