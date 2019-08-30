package com.example.montessorizoo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class AnimalPage extends AppCompatActivity {

    private TextView textView_name;
    private ImageView imageView_item;
    private String file_name;
    private String imageURL;
    private ImageView imageInfo;
    private ImageView imageSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page);

        final Bundle iInformation = getIntent().getExtras();

        textView_name = findViewById(R.id.textView_name);
        textView_name.setText(iInformation.getString("NAME"));

        imageView_item = findViewById(R.id.image_item);
        imageURL = iInformation.getString("IMAGE_URL");
        Picasso.get().load(imageURL).into(imageView_item);


        imageInfo = findViewById(R.id.imageInfo);
        imageInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AnimalDetailPage.class);
                intent.putExtra("BUNDLE", iInformation);
                startActivity(intent);
            }
        });

        //sound button
        file_name = iInformation.getString("SOUND");
        imageSound = findViewById(R.id.imageSound);
        imageSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
            }
        });

    }

    public void playSound() {
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
