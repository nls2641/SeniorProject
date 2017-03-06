package com.example.nat.essle;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.R.id.message;

public class DisplayTranslatedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_translated);

        Intent intent = getIntent();
        message = intent.getStringExtra(HomeActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_translated);
        layout.addView(textView);

    }

    public void saveMessage(){
        try {
            //open file for writing
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("save.txt", MODE_PRIVATE));

            //write information to file
            EditText text = (EditText)findViewById(R.id.message);
            String text2 = text.getText().toString();
            out.write(text2);
            out.write('\n');

            //close file

            out.close();
            Toast.makeText(this,"Text Saved",Toast.LENGTH_LONG).show();

        } catch (java.io.IOException e) {
            //if caught
            Toast.makeText(this, "Text Could not be added",Toast.LENGTH_LONG).show();
        }

    }

