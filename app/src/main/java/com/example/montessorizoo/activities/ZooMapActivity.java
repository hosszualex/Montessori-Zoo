package com.example.montessorizoo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.montessorizoo.R;
import com.google.firebase.auth.FirebaseAuth;

public class ZooMapActivity extends AppCompatActivity {


    private ImageView image_northamerica;
    private ImageView image_africa;
    private ImageView image_jungle;
    private ImageView image_ocean;
    private ImageView image_australia;
    private ImageView image_bird;
    private ImageView image_farm;
    private ImageView image_arctic;
    private ImageView image_asia;

    private Menu menu;
    private Toolbar toolbar;

    public void sendToNextIntent(String region) {
        final Intent mainIntent = new Intent(ZooMapActivity.this, AnimalsListActivity.class);
        mainIntent.putExtra("FILTER", region);
        ZooMapActivity.this.startActivity(mainIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_zoo);


        image_northamerica = findViewById(R.id.imageNorthAmerica);
        image_northamerica.setOnClickListener(v -> sendToNextIntent("North America"));

        image_africa = findViewById(R.id.imageAfrica);
        image_africa.setOnClickListener(v -> sendToNextIntent("Africa"));

        image_jungle = findViewById(R.id.imageJungle);
        image_jungle.setOnClickListener(v -> sendToNextIntent("Jungle"));

        image_ocean = findViewById(R.id.imageOcean);
        image_ocean.setOnClickListener(v -> sendToNextIntent("Ocean"));

        image_australia = findViewById(R.id.imageAustralia);
        image_australia.setOnClickListener(v -> sendToNextIntent("Australia"));

        image_bird = findViewById(R.id.imageBird);
        image_bird.setOnClickListener(v -> sendToNextIntent("Bird"));

        image_farm = findViewById(R.id.imageFarm);
        image_farm.setOnClickListener(v -> sendToNextIntent("Farm"));

        image_arctic = findViewById(R.id.imageAntarctica);
        image_arctic.setOnClickListener(v -> sendToNextIntent("Arctic"));

        image_asia = findViewById(R.id.imageAsia);
        image_asia.setOnClickListener(v -> sendToNextIntent("Asia"));

        toolbar = findViewById(R.id.toolbarMap);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_signout:
                FirebaseAuth.getInstance().signOut();
                Intent isignout = new Intent(ZooMapActivity.this, LoginActivity.class);
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //clear the user
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(isignout);
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
