package com.example.sleepapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class loginscreena extends AppCompatActivity implements View.OnClickListener {

    Button LoginbtnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginscreena);

        LoginbtnLog = findViewById(R.id.LoginbtnLog);
        LoginbtnLog.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == LoginbtnLog) {
            Intent intent = new Intent(getApplicationContext(), OptionsScreen.class);
            startActivity(intent);
            finish();
        }
    }


}