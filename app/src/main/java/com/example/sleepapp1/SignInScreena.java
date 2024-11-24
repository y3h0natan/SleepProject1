package com.example.sleepapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class SignInScreena extends AppCompatActivity implements View.OnClickListener {

    Button SigninSig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in_screena);
        SigninSig = findViewById(R.id.SignInBtn);
        SigninSig.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == SigninSig) {
            Intent intent = new Intent(getApplicationContext(), OptionsScreen.class);
            startActivity(intent);
            finish();
        }

    }
}