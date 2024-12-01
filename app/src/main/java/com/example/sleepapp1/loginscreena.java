package com.example.sleepapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class loginscreena extends AppCompatActivity implements View.OnClickListener {

    Button LoginbtnLog;
    ImageButton Backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginscreena);

        LoginbtnLog = findViewById(R.id.LoginbtnLog);
        LoginbtnLog.setOnClickListener(this);

        Backbtn = findViewById(R.id.backbtn);
        Backbtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == LoginbtnLog) {
            Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
            startActivity(intent);
            finish();
        }
        if (view == Backbtn) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


}