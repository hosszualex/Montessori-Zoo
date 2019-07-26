package com.example.montessorizoo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class AnimalPage extends AppCompatActivity {

    private TextView textView_name;
    private TextView textView_class;
    private TextView textView_food;
    private TextView textView_facts;
    private ImageView imageView_item;
    private Button button_map_animal;
    private Button button_sound;
    private Button button_details;
    private TextView textView_details;
    private String file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page);

        final Bundle iInformation = getIntent().getExtras();

        textView_name = findViewById(R.id.textView_name);
        textView_name.setText(iInformation.getString("NAME"));

        textView_class = findViewById(R.id.textView_class);
        textView_class.setText(iInformation.getString("CLASS"));

        textView_food = findViewById(R.id.textView_food);
        textView_food.setText(iInformation.getString("FOOD"));

        textView_facts = findViewById(R.id.textView_facts);
        textView_facts.setText(iInformation.getString("FACTS"));

        imageView_item = findViewById(R.id.image_item);
        imageView_item.setImageResource(iInformation.getInt("IMAGE"));


        button_details = findViewById(R.id.buttonDetail);
        button_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_details.setSelected(!button_details.isSelected());

                if (button_details.isSelected()) {
                    textView_details = findViewById(R.id.textViewDetails);
                    textView_details.setText(iInformation.getString("DETAIL"));
                }
                else {
                    textView_details.setText("Details");
                }
            }
        });


        //switching from map to animal image and vice versa (its a toggle)
        button_map_animal = findViewById(R.id.buttonMapAnimal);
        button_map_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button_map_animal.setSelected(!button_map_animal.isSelected());

                if (button_map_animal.isSelected()) {
                    imageView_item.setImageResource(iInformation.getInt("MAP"));
                    button_map_animal.setText("Animal");
                }
                else {
                    imageView_item.setImageResource(iInformation.getInt("IMAGE"));
                    button_map_animal.setText("Map");

                }

            }
        });

        //sound button
        file_name = iInformation.getString("SOUND");
        int resID = AnimalPage.this.getResources().getIdentifier(file_name,"raw",AnimalPage.this.getPackageName());
        button_sound = findViewById(R.id.buttonSound);
        final MediaPlayer mp = MediaPlayer.create(this, resID);
        button_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });




    }
}
