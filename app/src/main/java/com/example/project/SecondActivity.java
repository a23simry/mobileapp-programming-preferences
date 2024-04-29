package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get a reference to the shared preference
        myPreferenceRef = getSharedPreferences("MyPreferenceName", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        // Display preferences DONT NEED?
        //TextView prefTextRef=new TextView(this);
        //prefTextRef=(TextView)findViewById(R.id.prefText);
       // prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));

    }

    public void savePref(View v){

        // Get the text
        EditText newPrefText=new EditText(this);
        newPrefText=(EditText)findViewById(R.id.settingseditview);

        // Store the new preference
        myPreferenceEditor.putString("MyAppPreferenceString", newPrefText.getText().toString());
        myPreferenceEditor.apply();

        // Display the new preference
        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.prefText);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));

        // Clear the EditText
        newPrefText.setText("");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}