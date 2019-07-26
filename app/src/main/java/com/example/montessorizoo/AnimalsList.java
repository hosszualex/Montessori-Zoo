package com.example.montessorizoo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class AnimalsList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AnimalAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager_Horizontal;
    private RecyclerView.LayoutManager mLayoutManager_Vertical;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    Button signout;
    Button changeViewType;

    final ArrayList<Animal_item> animalList = new ArrayList<>();
    public static boolean viewType = false;


    public static boolean returnBool () {
        return viewType;
    }

    public void sendInfoIntent(Intent info, int p){
        info.putExtra("NAME", animalList.get(p).getmName());
        info.putExtra("CLASS", animalList.get(p).getmDesc());
        info.putExtra("FOOD", animalList.get(p).getmFood());
        info.putExtra("FACTS", animalList.get(p).getmFunFacts());
        info.putExtra("IMAGE", animalList.get(p).getmImageAnimal());
        info.putExtra("MAP", animalList.get(p).getmImageMap());
        info.putExtra("DETAIL", animalList.get(p).getmDetails());
        info.putExtra("SOUND", animalList.get(p).getmAudioFile());
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Mammal", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammalasdddddddd", "Meat", "They hunt in packs",R.drawable.ic_android,
"The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal", "Meat", "They hunt in packs",R.drawable.ic_all_out,
"The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Mammal", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammalasdddddddd", "Meat", "They hunt in packs",R.drawable.ic_android,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal", "Meat", "They hunt in packs",R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Mammal", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammalasdddddddd", "Meat", "They hunt in packs",R.drawable.ic_android,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal", "Meat", "They hunt in packs",R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));


 //        viewType = false;
        changeViewType = findViewById(R.id.button_viewType);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager_Vertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager_Horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new AnimalAdapter(animalList);
        mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
        mRecyclerView.setAdapter(mAdapter);
        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(mRecyclerView);


        //changing view type
        changeViewType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewType==false)
                {
                    AnimalAdapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
                    mRecyclerView.setAdapter(mAdapter_change);
                    viewType = true;
                    mAdapter_change.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
                        @Override
                        public void onItemClick(int position) {
                            final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                            sendInfoIntent(animalpageIntent, position);
                            startActivity(animalpageIntent);
                        }
                    });

                }
                else
                    if(viewType==true)
                {
                    AnimalAdapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
                    mRecyclerView.setAdapter(mAdapter_change);
                    viewType = false;
                    mAdapter_change.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
                        @Override
                        public void onItemClick(int position) {
                            final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                            sendInfoIntent(animalpageIntent, position);
                            startActivity(animalpageIntent);
                        }
                    });

                }
            }
        });



        //clicking on an item from the list
        mAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
            @Override
            public void onItemClick(int position) {
                final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                sendInfoIntent(animalpageIntent, position);
                startActivity(animalpageIntent);
            }
        });


        //signout button
        signout = findViewById(R.id.button_signout);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //sign out button
                FirebaseAuth.getInstance().signOut();
                Intent isignout = new Intent(AnimalsList.this,UserLogin.class);
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //clear the user
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(isignout);
                finish();
            }
        });




    }
}
