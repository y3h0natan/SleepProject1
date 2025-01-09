package com.example.sleepapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class optionsScreena extends AppCompatActivity implements View.OnClickListener {


    Button SleepSchooled, SoundsLib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_options_screena);
        SoundsLib = findViewById(R.id.Soundslib);
        SleepSchooled = findViewById(R.id.sleepEDbtn);

        SoundsLib.setOnClickListener(this);
        SleepSchooled.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == SleepSchooled) {
            Intent intent = new Intent(getApplicationContext(), SleepSchoola.class);
            startActivity(intent);
            finish();
        }

        if (view == SoundsLib) {
            Intent intent = new Intent(getApplicationContext(), SleepNoiseLibrary.class);
            startActivity(intent);
            finish();
        }

    }
}