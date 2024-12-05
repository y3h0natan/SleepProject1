package com.example.sleepapp1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.channels.ChannelResult;

public class SleepSchoola extends AppCompatActivity implements View.OnClickListener {

    Button SleepArticlebtn1;
    Button SleepArticlebtn2;
    Button SleepArticlebtn3;
    Button SleepArticlebtn4;
    ImageView Backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sleep_schoola);

        SleepArticlebtn1 = findViewById(R.id.sleeparticlebtn);
        SleepArticlebtn1.setOnClickListener(this);

        SleepArticlebtn2 = findViewById(R.id.Sleeptips);
        SleepArticlebtn2.setOnClickListener(this);

        SleepArticlebtn3 = findViewById(R.id.BluelightArticle);
        SleepArticlebtn3.setOnClickListener(this);

        SleepArticlebtn4 = findViewById(R.id.sleepimportant);
        SleepArticlebtn4.setOnClickListener(this);

        Backbtn = findViewById(R.id.ImageBack);
        Backbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == Backbtn){
            Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
            startActivity(intent);
            finish();
        }

        if (view == SleepArticlebtn1) {
            Showdialog();
        }

        if (view == SleepArticlebtn2) {
            Showdialog2();
        }

        if (view == SleepArticlebtn3){
            Showdialog3();
        }
        
        if (view == SleepArticlebtn4){
            Showdialog4();
        }
    }
    
    private void Showdialog4(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.whysleepimportant);
        
        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {dialog.dismiss();}
        });
        

        dialog.show();
    }
    
    
    private void Showdialog3(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.bluelightarticle);

        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {dialog.dismiss();}
        });


        dialog.show();
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

