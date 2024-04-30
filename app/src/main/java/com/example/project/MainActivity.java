package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.EditTextPreference;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences myPreferenceRef;
    private Button button;
    private TextView prefTextRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPreferenceRef = getSharedPreferences("MyAppPreferenceString",MODE_PRIVATE);

        prefTextRef = new TextView(this);
        prefTextRef = findViewById(R.id.prefText);

        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));

        button = findViewById(R.id.goToSecond);
        button.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }



}
