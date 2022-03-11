package com.example.DarkHorse;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private EditText editName, editRegEmail,
            editRegPassword, editConReg;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.editTextTextPersonName);
        editRegEmail = findViewById(R.id.editTextTextEmailAddress);
        editRegPassword = findViewById(R.id.editTextTextPassword);
        editConReg = findViewById(R.id.editTextTextPassword2);

        mAuth=FirebaseAuth.getInstance();

        Button btnReg = findViewById(R.id.btnReg);
        TextView btn = findViewById(R.id.TextViewSignIn);


        btn.setOnClickListener(view -> startActivity(new Intent
                (RegisterActivity.this, LoginActivity.class)));



        btnReg.setOnClickListener(view -> {
            createUser();

        });

    }

    private void createUser() {
        String name = editName.getText().toString();
        String email = editRegEmail.getText().toString();
        String password = editRegPassword.getText().toString();
        String passwordC = editConReg.getText().toString();

        if (TextUtils.isEmpty(name)) {
            editName.setError("username cannot be empty");
            editName.requestFocus();

        } else if (TextUtils.isEmpty(email)) {
            editRegEmail.setError("email cannot be empty");
            editRegEmail.requestFocus();
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editRegEmail.setError("email cannot be empty");
                editRegEmail.requestFocus();
            }

        } else if (TextUtils.isEmpty(password)) {
            editRegPassword.setError("password cannot be empty");
            editRegPassword.requestFocus();
        } else if (TextUtils.isEmpty(passwordC)&&password.equals(passwordC)) {
            editConReg.setError("confirm your password re-entry");
            editConReg.requestFocus();
        }

        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,"Register Successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"Register Error:"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}












