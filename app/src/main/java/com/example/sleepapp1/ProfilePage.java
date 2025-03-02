package com.example.sleepapp1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);

        back = findViewById(R.id.backbtn);
        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == back) {
            Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
            startActivity(intent);
            finish();

        }

    }
}