package com.example.sleepapp1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SleepSchoola extends AppCompatActivity implements View.OnClickListener {

    Button sleepActiclebtn1;
    Button SleepArticlebtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sleep_schoola);

        sleepActiclebtn1 = findViewById(R.id.sleeparticlebtn);
        sleepActiclebtn1.setOnClickListener(this);

        SleepArticlebtn2 = findViewById(R.id.Sleeptips);
        SleepArticlebtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == sleepActiclebtn1) {
            Showdialog();
        }

        if (view == SleepArticlebtn2) {
            Showdialog2();
        }
    }

    private void Showdialog2() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sleeptips);

        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }



    private void Showdialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.sleepschooldialoglayout);

        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }



}

