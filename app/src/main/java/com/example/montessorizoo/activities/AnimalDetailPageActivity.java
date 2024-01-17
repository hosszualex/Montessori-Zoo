package com.example.montessorizoo.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montessorizoo.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class AnimalDetailPageActivity extends AppCompatActivity {
    private ImageView imageMap;
    private TextView textView_class;
    private TextView textView_food;
    private TextView textView_facts;
    private TextView textView_name;
    private String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail_page);
       final Bundle iInformation = getIntent().getBundleExtra("BUNDLE");

        textView_name = findViewById(R.id.textView_name);
        textView_name.setText(iInformation.getString("NAME"));

        textView_class = findViewById(R.id.textView_classcontent);
        textView_class.setText(iInformation.getString("CLASS"));

        textView_food = findViewById(R.id.textView_foodcontent);
        textView_food.setText(iInformation.getString("FOOD"));

        textView_facts = findViewById(R.id.textView_factscontent);
        textView_facts.setText(iInformation.getString("FACTS"));

        imageMap = findViewById(R.id.image_map);
        url = iInformation.getString("MAP_URL");
        Picasso.get().load(url).into(imageMap);

    }

}