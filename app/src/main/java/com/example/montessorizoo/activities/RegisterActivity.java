package com.example.montessorizoo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.montessorizoo.R;
import com.google.firebase.FirebaseApp;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private EditText passRetyped;
    private Button registerBtn;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.edit_text_email);
        pass = findViewById(R.id.edit_text_password);
        passRetyped = findViewById(R.id.edit_text_password_retype);
        registerBtn = findViewById(R.id.button_register);
        checkBox = findViewById(R.id.checkbox_terms);

        FirebaseApp.initializeApp(this);

        registerBtn.setOnClickListener(v -> {
            registerUser();
        });
    }

    private void registerUser() {
        if (checkBox.isChecked()) {
            if (pass.getText().toString().equals(passRetyped.getText().toString())) {
                LoginActivity.mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        } else {
            Toast.makeText(RegisterActivity.this, "Please accept the terms of service in order to register.", Toast.LENGTH_LONG).show();
        }
    }
}
