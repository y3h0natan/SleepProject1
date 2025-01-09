package com.example.sleepapp1;

import android.app.Dialog;
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

public class SleepNoiseLibrary extends AppCompatActivity implements View.OnClickListener {

    ImageView Backbtn;
    Button Rain, Beach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sleep_noise_library);

        Backbtn = findViewById(R.id.backbtn);
        Backbtn.setOnClickListener(this);

        Rain = findViewById(R.id.HveavyRainBtn);
        Rain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == Backbtn) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }

        if(view == Rain){
            Showdialog();
        }
    }

    private void Showdialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.audioplayerlayout);

        Button Stop, pause, play;

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
