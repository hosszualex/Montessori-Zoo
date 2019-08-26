package com.example.montessorizoo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;

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
    private String imageURL;

    private StorageReference mStorageRefrence;
    private FirebaseStorage mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page);

        mStorageRefrence = FirebaseStorage.getInstance().getReference();

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

        imageURL = iInformation.getString("IMAGE_URL");
        Picasso.get().load(imageURL).into(imageView_item);


        button_details = findViewById(R.id.buttonDetail);
        button_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_details.setSelected(!button_details.isSelected());

                if (button_details.isSelected()) {
                    textView_details = findViewById(R.id.textViewDetails);
                    textView_details.setText(iInformation.getString("DETAIL"));
                } else {
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
                    String url = iInformation.getString("MAP_URL");
                    Picasso.get().load(url).into(imageView_item);
                    button_map_animal.setText("Animal");
                } else {
                    String url = iInformation.getString("IMAGE_URL");
                    Picasso.get().load(url).into(imageView_item);
                    button_map_animal.setText("Map");

                }

            }
        });

        //sound button
        file_name = iInformation.getString("SOUND");
        button_sound = findViewById(R.id.buttonSound);
        button_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
            }
        });


    }

    public void playSound(){
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource(file_name);
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
