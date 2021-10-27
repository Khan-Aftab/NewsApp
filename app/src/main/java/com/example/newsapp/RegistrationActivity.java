package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    TextView textViewAlreadyRegistered;
    EditText editTextRegisterEmail, editTextRegisterPassword, editTextRegisterConfirmPassword;
    Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textViewAlreadyRegistered = findViewById(R.id.textViewAlreadyRegistered);
        editTextRegisterEmail = findViewById(R.id.editTextRegisterEmail);
        editTextRegisterPassword = findViewById(R.id.editTextRegisterPassword);
        editTextRegisterConfirmPassword = findViewById(R.id.editTextRegisterConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        textViewAlreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Intent intent2 = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent2);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuthentication();
            }
        });
    }

    private void performAuthentication() {
        String email = editTextRegisterEmail.getText().toString();
        String password = editTextRegisterPassword.getText().toString();
        String confirmPassword = editTextRegisterConfirmPassword.getText().toString();

        if(!email.matches(emailPattern))
            Toast.makeText(this, "Wrong email pattern !", Toast.LENGTH_SHORT).show();
        else if(password.isEmpty() || password.length()<8)
            Toast.makeText(this, "Password length must be atleast 8 characters", Toast.LENGTH_SHORT).show();
        else if(!password.equals(confirmPassword))
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        
        


        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    sendUserBackToLoginActivity();
                    Toast.makeText(RegistrationActivity.this, " Registration Successful", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(RegistrationActivity.this, "" +task.getException(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void sendUserBackToLoginActivity() {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}