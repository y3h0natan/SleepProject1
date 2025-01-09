package com.example.sleepapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Loginbuttonmain;
    Button Signinbuttonmain, Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button = findViewById(R.id.button);
        Loginbuttonmain = findViewById(R.id.LoginBtn);
        Signinbuttonmain = findViewById(R.id.SignInBtn);

        Button.setOnClickListener(this);
        Loginbuttonmain.setOnClickListener(this);
        Signinbuttonmain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == Loginbuttonmain) {
            Intent intent = new Intent(getApplicationContext(), loginscreena.class);
            startActivity(intent);
            finish();
        }
        if (view == Signinbuttonmain) {
            Intent intent = new Intent(getApplicationContext(), SignInScreena.class);
            startActivity(intent);
            finish();
        }

        if (view == Button) {
            Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
            startActivity(intent);
            finish();
        }


    }
}