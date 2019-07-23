package com.example.montessorizoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.*;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final TextView welcome = findViewById(R.id.textview_welcome);

        Intent iUsername = getIntent();
        final String email_passed = iUsername.getStringExtra("KEY");

        final String username = email_passed.substring(0,email_passed.indexOf("@"));

        welcome.setText("Welcome to the ZOO, " +username+ "!");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(HomeScreen.this, AnimalsList.class);
                HomeScreen.this.startActivity(mainIntent);
                HomeScreen.this.finish();
            }
        }, 1000);

    }


}
