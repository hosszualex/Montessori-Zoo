package com.example.montessorizoo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class MapZoo extends AppCompatActivity {


    ImageView image_northamerica;
    ImageView image_africa;
    ImageView image_jungle;
    ImageView image_ocean;

    ImageView TEST;
    Bitmap bitmap;
    String URL = "https://s7img.ftdi.com/is/image/ProvideCommerce/PF_19_R299_LAY_SHP_V2?$proflowers-tile-wide-mv-new$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_zoo);


        image_northamerica = findViewById(R.id.imageNorthAmerica);

        image_northamerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
                mainIntent.putExtra("FILTER", "North America");
                MapZoo.this.startActivity(mainIntent);
            }
        });

        image_africa = findViewById(R.id.imageAfrica);

        image_africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
                mainIntent.putExtra("FILTER", "Africa");
                MapZoo.this.startActivity(mainIntent);
            }
        });

        image_jungle = findViewById(R.id.imageJungle);

        image_jungle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
                mainIntent.putExtra("FILTER", "Jungle");
                MapZoo.this.startActivity(mainIntent);

            }
        });

        image_ocean = findViewById(R.id.imageOcean);

        image_ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent mainIntent = new Intent(MapZoo.this, AnimalsList.class);
                mainIntent.putExtra("FILTER", "Ocean");
                MapZoo.this.startActivity(mainIntent);
            }
        });


        TEST = findViewById(R.id.TEST);



    }


}
