package com.example.sleepapp1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class loginscreena extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    Button LoginbtnLog;
    ImageView Backbtn;
    EditText LoginEmail, Loginpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginscreena);

        LoginEmail = findViewById(R.id.editTextTextEmailAddress);
        Loginpassword = findViewById(R.id.editTextTextPassword);

        LoginbtnLog = findViewById(R.id.LoginbtnLog);
        LoginbtnLog.setOnClickListener(this);

        Backbtn = findViewById(R.id.backbtn);
        Backbtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == LoginbtnLog) {
            String email = LoginEmail.getText().toString();
            String password = Loginpassword.getText().toString();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(loginscreena.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

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