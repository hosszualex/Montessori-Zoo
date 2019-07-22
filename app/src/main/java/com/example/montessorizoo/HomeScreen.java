package com.example.montessorizoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final TextView welcome = findViewById(R.id.textview_welcome);

        Intent iUsername = getIntent();
        final String email_passed = iUsername.getStringExtra("KEY");

        final String username = email_passed.substring(0,email_passed.indexOf("@"));

        welcome.setText("Welcome to the ZOO, " +username+ "!");

        signout = findViewById(R.id.button_signout);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //sign out button
                FirebaseAuth.getInstance().signOut();
                Intent isignout = new Intent(HomeScreen.this,UserLogin.class);
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //clear the user
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(isignout);
            }
        });


    }
}
