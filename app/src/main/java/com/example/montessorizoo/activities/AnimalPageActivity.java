package com.example.montessorizoo.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.example.montessorizoo.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class AnimalPageActivity extends AppCompatActivity {

    private TextView textView_name;
    private ImageView imageView_item;
    private String file_name;
    private String imageURL;
    private ImageView imageInfo;
    private ImageView imageSound;
    private PulsatorLayout pulsatorSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page);

        final Bundle iInformation = getIntent().getExtras();

        textView_name = findViewById(R.id.textView_name);
        textView_name.setText(iInformation.getString("NAME"));


        pulsatorSound = findViewById(R.id.pulsator_sound);


        imageView_item = findViewById(R.id.image_item);
        imageURL = iInformation.getString("IMAGE_URL");
        Picasso.get().load(imageURL).into(imageView_item);


        imageInfo = findViewById(R.id.imageInfo);
        imageInfo.setOnClickListener( v -> {
            Intent intent = new Intent(getApplicationContext(), AnimalDetailPageActivity.class);
            intent.putExtra("BUNDLE", iInformation);
            startActivity(intent);
        });

        //sound button
        file_name = iInformation.getString("SOUND");
        imageSound = findViewById(R.id.imageSound);
        imageSound.setOnClickListener( v -> {
            pulsatorSound.start();
            playSound();
        });
    }

    private void playSound() {
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
