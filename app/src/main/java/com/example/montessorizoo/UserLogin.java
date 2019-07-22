package com.example.montessorizoo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_login);

        Button loginButton = findViewById(R.id.button_login);


        final EditText email = findViewById(R.id.edit_text_email);
        final EditText pass = findViewById(R.id.edit_text_password);
        final TextView error = findViewById(R.id.textview_error);

        final String PREFS_NAME = "PrefsFile";
        final SharedPreferences mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        final CheckBox keepSigned = findViewById(R.id.checkBox_sign);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        final Intent loginIntent = new Intent(getApplicationContext(), HomeScreen.class);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        // sets the texts back to gray
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setText("");
                email.setHintTextColor(Color.GRAY);
                pass.setHintTextColor(Color.GRAY);
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setText("");
                email.setHintTextColor(Color.GRAY);
                pass.setHintTextColor(Color.GRAY);
            }
        });





        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) { //login button
                        if (task.isSuccessful()) {

                            if(keepSigned.isChecked()){
                                Boolean isChecked = keepSigned.isChecked();
                                SharedPreferences.Editor editor = mPrefs.edit();
                                editor.putBoolean("prefs_check",isChecked);
                                editor.apply();
                                startActivity(loginIntent);
                                finish();
                            }
                            else
                            {
                                mPrefs.edit().clear().apply();
                            }




                            loginIntent.putExtra("KEY",email.getText().toString());
                            startActivity(loginIntent);
                        } else {
                            Toast.makeText(UserLogin.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }

                });

            }
        });

        SharedPreferences sp = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        if(sp.contains("prefs_check")){
            Boolean b = sp.getBoolean("prefs_check", false);
            keepSigned.setChecked(b);
        }
        if(firebaseAuth.getCurrentUser() != null && sp.contains("prefs_check")){ //keep me signed in

            loginIntent.putExtra("KEY",firebaseAuth.getCurrentUser().getEmail()); //send from firebase, because if we send text, we do not know what to send
            startActivity(loginIntent);
            finish();
        }


    }
}

