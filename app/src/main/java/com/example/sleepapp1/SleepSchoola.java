package com.example.sleepapp1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.coroutines.channels.ChannelResult;

public class SleepSchoola extends AppCompatActivity implements View.OnClickListener {

    Button SleepArticlebtn1, SleepArticlebtn2, SleepArticlebtn3, SleepArticlebtn4;
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
            showArticle1Dialog();
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




    private void showArticle1Dialog() {
        String jsonData = loadJSONFromAsset();

            try {

                JSONObject jsonObject = new JSONObject(jsonData);
                JSONArray articlesArray = jsonObject.getJSONArray("articles");

                // Load the first article (modify index to show different articles)
                JSONObject article = articlesArray.getJSONObject(0);
                String title = article.getString("title");
                String content = article.getString("content");


                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.sleepschooldialoglayout);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                // Set data in dialog
                TextView titleTextView = dialog.findViewById(R.id.articleTitle);
                TextView contentTextView = dialog.findViewById(R.id.articleContent);
                ImageView closeButton = dialog.findViewById(R.id.closeButton);

                titleTextView.setText(title);
                contentTextView.setText(content);

                closeButton.setOnClickListener(v -> dialog.dismiss());

                dialog.show();

            } catch (Exception e) {
                Log.e("JSON Error", "Error parsing JSON", e);
            }
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("LackOfSleep.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (Exception e) {
            Log.e("JSON Error", "Error loading JSON", e);
        }
        return json;
    }




}







