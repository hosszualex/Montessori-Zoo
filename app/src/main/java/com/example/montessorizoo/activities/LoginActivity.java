package com.example.montessorizoo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.montessorizoo.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;


    public static FirebaseAuth mAuth;

    public void setTextToGrey() {
        email.setHintTextColor(Color.GRAY);
        pass.setHintTextColor(Color.GRAY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Button loginButton = findViewById(R.id.button_login);
        Button registerButton = findViewById(R.id.button_registerActivity);


        email = findViewById(R.id.edit_text_email);
        pass = findViewById(R.id.edit_text_password);

        final String PREFS_NAME = "PrefsFile";
        final SharedPreferences mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        final CheckBox keepSigned = findViewById(R.id.checkBox_sign);

        FirebaseApp.initializeApp(this);

        final Intent loginIntent = new Intent(getApplicationContext(), SplashScreenActivity.class);
        final Intent registerIntent = new Intent(getApplicationContext(), RegisterActivity.class);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        // sets the texts back to gray
        email.setOnClickListener(v -> setTextToGrey());

        pass.setOnClickListener(v -> setTextToGrey());

        registerButton.setOnClickListener(v -> {
            startActivity(registerIntent);
        });

        loginButton.setOnClickListener(v -> {
            if (!email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()) {

                mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {

                                if (keepSigned.isChecked()) {
                                    Boolean isChecked = keepSigned.isChecked();
                                    SharedPreferences.Editor editor = mPrefs.edit();
                                    editor.putBoolean("prefs_check", isChecked);
                                    editor.apply();
                                    startActivity(loginIntent);
                                    finish();
                                } else {
                                    mPrefs.edit().clear().apply();
                                }
                                loginIntent.putExtra("KEY", email.getText().toString());
                                startActivity(loginIntent);
                            } else {
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }

                        });
            }
            else{
                Toast.makeText(LoginActivity.this, "Please input an email and password.", Toast.LENGTH_SHORT).show();
            }

        });

        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if (sp.contains("prefs_check")) {
            Boolean b = sp.getBoolean("prefs_check", false);
            keepSigned.setChecked(b);
        }
        if (firebaseAuth.getCurrentUser() != null && sp.contains("prefs_check")) { //keep me signed in

            loginIntent.putExtra("KEY", firebaseAuth.getCurrentUser().getEmail()); //send from firebase, because if we send text, we do not know what to send
            startActivity(loginIntent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAuth = FirebaseAuth.getInstance();
    }

}

