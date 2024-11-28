package com.example.sleepapp1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SleepSchoola extends AppCompatActivity implements View.OnClickListener {

    Button sleepActiclebtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sleep_schoola);
        sleepActiclebtn1 = findViewById(R.id.sleeparticlebtn);
        sleepActiclebtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Showdialog();
    }

    private void Showdialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sleepschooldialoglayout);
        dialog.show();
    }
}