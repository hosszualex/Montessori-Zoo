package com.example.montessorizoo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Map;

public class MapZoo extends AppCompatActivity {

    ImageView image_forest;
    ImageView image_ocean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_zoo);

        image_forest = findViewById(R.id.imageForest);

        image_forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
                MapZoo.this.startActivity(mainIntent);
            }
        });

        image_ocean = findViewById(R.id.imageOcean);

        image_ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
                MapZoo.this.startActivity(mainIntent);
            }
        });

    }
}
