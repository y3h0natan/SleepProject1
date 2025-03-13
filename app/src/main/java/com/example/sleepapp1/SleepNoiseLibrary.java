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

        final MediaPlayer[] mediaPlayer = {MediaPlayer.create(this, R.raw.rainsounds)};


        Button StopAudioButton = dialog.findViewById(R.id.Stopbtn);
        Button PauseAudioButton = dialog.findViewById(R.id.Pausebtn);
        Button playAudioButton = dialog.findViewById(R.id.Playbtn);



        StopAudioButton.setOnClickListener(v -> {
            if (mediaPlayer[0].isPlaying()) {
                mediaPlayer[0].stop();
                mediaPlayer[0].release();
                mediaPlayer[0] = MediaPlayer.create(this,R.raw.rainsounds);
                Toast.makeText(SleepNoiseLibrary.this, "Stopping Audio", Toast.LENGTH_SHORT).show();
            }
        });

        PauseAudioButton.setOnClickListener(v -> {
            if (mediaPlayer[0].isPlaying()) {
                mediaPlayer[0].pause();

            }
        });

        playAudioButton.setOnClickListener(v -> {
            if (!mediaPlayer[0].isPlaying()) {
                mediaPlayer[0].start();
                mediaPlayer[0].setLooping(true);
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

        final MediaPlayer[] mediaPlayer = {MediaPlayer.create(this, R.raw.oceanwaves)};


        Button StopAudioButton = dialog.findViewById(R.id.Stopbtn);
        Button PauseAudioButton = dialog.findViewById(R.id.Pausebtn);
        Button playAudioButton = dialog.findViewById(R.id.Playbtn);



        StopAudioButton.setOnClickListener(v -> {
            if (mediaPlayer[0].isPlaying()) {
                mediaPlayer[0].stop();
                mediaPlayer[0].release();
                mediaPlayer[0] = MediaPlayer.create(this,R.raw.oceanwaves);
                Toast.makeText(SleepNoiseLibrary.this, "Stopping Audio", Toast.LENGTH_SHORT).show();
            }
        });

        PauseAudioButton.setOnClickListener(v -> {
            if (mediaPlayer[0].isPlaying()) {
                mediaPlayer[0].pause();

            }
        });

        playAudioButton.setOnClickListener(v -> {
            if (!mediaPlayer[0].isPlaying()) {
                mediaPlayer[0].start();
                mediaPlayer[0].setLooping(true);
                Toast.makeText(SleepNoiseLibrary.this, "Playing Audio", Toast.LENGTH_SHORT).show();
            }
        });




        ImageView closedialog = dialog.findViewById(R.id.Closedialogbtn);
        closedialog.setOnClickListener(view -> dialog.dismiss());


        dialog.show();
    }
}
