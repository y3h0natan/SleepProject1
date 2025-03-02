package com.example.sleepapp1;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

        Beach = findViewById(R.id.BeachSoundsBtn);
        Beach.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        if (view == Backbtn) {
            Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
            startActivity(intent);
            finish();

        }

        if(view == Rain){
            Showdialog1();
        }

        if(view == Beach){
            Showdialog2();
        }
    }

    private void Showdialog1() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.audioplayerlayout);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.rainsounds);


        Button playAudioButton = dialog.findViewById(R.id.Playbtn);
        playAudioButton.setOnClickListener(v -> {





            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                Toast.makeText(SleepNoiseLibrary.this, "Playing Audio", Toast.LENGTH_SHORT).show();
            }
        });

        Button closeButton = dialog.findViewById(R.id.Stopbtn);
        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(view -> dialog.dismiss());


        dialog.show();
    }

    private void Showdialog2() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.audioplayerlayout);

        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(view -> dialog.dismiss());


        dialog.show();
    }
}
