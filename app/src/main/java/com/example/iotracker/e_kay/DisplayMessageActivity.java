package com.example.iotracker.e_kay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NAME);
        String age = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_AGE);

        TextView textViewName = new TextView(this);
        textViewName.setTextSize(40);
        textViewName.setText(name);

        TextView textViewAge = new TextView(this);
        textViewAge.setTextSize(40);
        textViewAge.setText(age);

        LinearLayout relativeLayout = (LinearLayout) findViewById (R.id.content);
        relativeLayout.addView(textViewName);
        relativeLayout.addView(textViewAge);
    }
}