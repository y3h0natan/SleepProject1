package com.example.sleepapp1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInScreena extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    Button SigninSig;
    ImageView Backbtn;
    EditText editTextName, editTextTextEmailAddress, editTextTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in_screena);

        editTextName = findViewById(R.id.editTextName);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        SigninSig = findViewById(R.id.SignInBtn);
        SigninSig.setOnClickListener(this);

        Backbtn = findViewById(R.id.backbtn);
        Backbtn.setOnClickListener(this);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if (view == SigninSig) {
            // Get the values from EditText correctly
            String email = editTextTextEmailAddress.getText().toString();
            String name = editTextName.getText().toString();  // 'name' captured from 'editTextName'
            String password = editTextTextPassword.getText().toString();

            // Ensure the fields are not empty
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignInScreena.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // Firebase registration (create user)
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignInScreena.this, "Authentication successful.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), optionsScreena.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignInScreena.this, "Authentication failed: " + task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

        if (view == Backbtn) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
