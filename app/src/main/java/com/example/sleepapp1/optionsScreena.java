package com.example.sleepapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class optionsScreena extends AppCompatActivity implements View.OnClickListener {

    ImageView CogWheel;
    Button SleepSchooled, SoundsLib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_options_screena);
        SoundsLib = findViewById(R.id.Soundslib);
        SleepSchooled = findViewById(R.id.sleepEDbtn);
        CogWheel = findViewById(R.id.CogBtn);

        CogWheel.setOnClickListener(this);
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
        if (view == CogWheel) {
            Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
            startActivity(intent);
            finish();
        }

    }
}