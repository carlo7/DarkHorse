package com.example.DarkHorse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    private EditText editLogEmail,
            editLogPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        editLogEmail = findViewById(R.id.logEmailAddress);
        editLogPassword = findViewById(R.id.editTextTextPassword3);
        Button button = findViewById(R.id.btnLog);
        TextView btn = findViewById(R.id.TextViewSignUp);


       //When clicked the button logs_in in the user after Auth
        button.setOnClickListener(view -> loginUser()

        );
        //When clicked the button redirects the User to the Register Page
        btn.setOnClickListener(view ->
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class))


        );


    }
    private void loginUser(){
        String email = editLogEmail.getText().toString();
        String password = editLogPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            editLogEmail.setError("email cannot be empty");
            editLogEmail.requestFocus();

        } else if (TextUtils.isEmpty(password)) {
            editLogPassword.setError("password cannot be empty");
            editLogPassword.requestFocus();

        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Error:" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }

    }


    }

