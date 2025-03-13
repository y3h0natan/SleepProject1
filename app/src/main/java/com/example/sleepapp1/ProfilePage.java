package com.example.sleepapp1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener {
    ImageView back, Logoutbtn, profileImage;
    TextView emailText, usernameTextView;



    private static final int PICK_IMAGE_REQUEST = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);

        emailText = findViewById(R.id.Email);
        usernameTextView = findViewById(R.id.Name);


        back = findViewById(R.id.backbtn);
        back.setOnClickListener(this);

        Logoutbtn = findViewById(R.id.Logout);
        Logoutbtn.setOnClickListener(this);

        profileImage = findViewById(R.id.profileImage);
        profileImage.setOnClickListener(v -> openGallery());

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();



        if (user != null) {
            String username = user.getDisplayName();
            usernameTextView.setText(username);
            String email = user.getEmail();
            emailText.setText(email);
        } else {
            usernameTextView.setText("No username found");
            emailText.setText("No email found");
        }


    }



    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();

            if (selectedImageUri != null) {
                profileImage.setImageURI(selectedImageUri);
            }
        }
    }

    @Override
    public void onClick(View view) {

        if (view == back) {
            Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
            startActivity(intent);
            finish();

        if(view == Logoutbtn) {
            FirebaseAuth.getInstance().signOut();
            Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        }

    }
}