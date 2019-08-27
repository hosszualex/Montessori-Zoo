package com.example.montessorizoo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MapZoo extends AppCompatActivity {


    ImageView image_northamerica;
    ImageView image_africa;
    ImageView image_jungle;
    ImageView image_ocean;
    ImageView image_australia;

    public void sendToNextIntent(String region) {
        final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
        mainIntent.putExtra("FILTER", region);
        MapZoo.this.startActivity(mainIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_zoo);


        image_northamerica = findViewById(R.id.imageNorthAmerica);
        image_northamerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToNextIntent("North America");
            }
        });

        image_africa = findViewById(R.id.imageAfrica);
        image_africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToNextIntent("Africa");
            }
        });

        image_jungle = findViewById(R.id.imageJungle);
        image_jungle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToNextIntent("Jungle");

            }
        });

        image_ocean = findViewById(R.id.imageOcean);
        image_ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToNextIntent("Ocean");
            }
        });

        image_australia = findViewById(R.id.imageAustralia);
        image_australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToNextIntent("Australia");
            }
        });
    }
}
