package com.example.montessorizoo;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    final SnapHelper helperHorizontal = new PagerSnapHelper();
    final SnapHelper helperVertical = new LinearSnapHelper();
    private Menu menu;

    Toolbar toolbar;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    Button signout;
    Button changeViewType;

    final ArrayList<Animal_item> animalList = new ArrayList<>();
    public static int viewType = 0;


    public static int returnViewType () {
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

        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Forest", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Tundra", "Meat", "They hunt in packs",R.drawable.ic_android,
"The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Ocean", "Meat", "They hunt in packs",R.drawable.ic_all_out,
"The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Forest", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Tundra", "Meat", "They hunt in packs",R.drawable.ic_android,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Ocean", "Meat", "They hunt in packs",R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Forest", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Tundra", "Meat", "They hunt in packs",R.drawable.ic_android,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Ocean", "Meat", "They hunt in packs",R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Forest", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Tundra", "Meat", "They hunt in packs",R.drawable.ic_android,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Ocean", "Meat", "They hunt in packs",R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Forest", "Meat", "They hunt in packs", R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Tundra", "Meat", "They hunt in packs",R.drawable.ic_android,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "cow_sound"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Ocean", "Meat", "They hunt in packs",R.drawable.ic_all_out,
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It is the largest extant member of its family, with males averaging 43–45 kg (95–99 lb) and females 36–38.5 kg (79–85 lb). It is distinguished from other Canis species by its larger size and less pointed features, particularly on the ears and muzzle. Its winter fur is long and bushy and predominantly a mottled gray in color, although nearly pure white, red and brown to black also occur. Mammal Species of the World (3rd ed., 2005), a standard reference work in zoology, recognises 38 subspecies of C. lupus.",
                "wolf_sound"));


        mRecyclerView = findViewById(R.id.recyclerView_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager_Vertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager_Horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new AnimalAdapter(animalList);
        mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
        mRecyclerView.setAdapter(mAdapter);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        helperVertical.attachToRecyclerView(mRecyclerView);

        //clicking on an item from the list
        mAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
            @Override
            public void onItemClick(int position) {
                final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                sendInfoIntent(animalpageIntent, position);
                startActivity(animalpageIntent);
            }
        });




        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_layoutswitch:
                if(viewType==0)
                {
                    AnimalAdapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
                    mRecyclerView.setAdapter(mAdapter_change);
                    viewType = 1;
                    mAdapter_change.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
                        @Override
                        public void onItemClick(int position) {
                            final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                            sendInfoIntent(animalpageIntent, position);
                            startActivity(animalpageIntent);
                        }
                    });

                    //needs to put the previous snaphelper to null, in order for conflict to not appear
                    helperHorizontal.attachToRecyclerView(null);
                    helperVertical.attachToRecyclerView(null);
                    helperHorizontal.attachToRecyclerView(mRecyclerView);

                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_gridlayout));

                }
                else
                if(viewType==1) //right now its in card layout
                {
                    AnimalAdapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
                    mRecyclerView.setAdapter(mAdapter_change);
                    viewType = 2;
                    mAdapter_change.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
                        @Override
                        public void onItemClick(int position) {
                            final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                            sendInfoIntent(animalpageIntent, position);
                            startActivity(animalpageIntent);
                        }
                    });

                    //needs to put the previous snaphelper to null, in order for conflict to not appear
                    helperHorizontal.attachToRecyclerView(null);
                    helperVertical.attachToRecyclerView(null);
                    helperVertical.attachToRecyclerView(mRecyclerView);

                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_listlayout));

                }
                else
                    if(viewType==2)
                    {
                        AnimalAdapter mAdapter_change;
                        mAdapter_change = new AnimalAdapter(animalList);
                        mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
                        mRecyclerView.setAdapter(mAdapter_change);
                        viewType = 0;
                        mAdapter_change.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
                            @Override
                            public void onItemClick(int position) {
                                final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                                sendInfoIntent(animalpageIntent, position);
                                startActivity(animalpageIntent);
                            }
                        });

                        //needs to put the previous snaphelper to null, in order for conflict to not appear
                        helperHorizontal.attachToRecyclerView(null);
                        helperVertical.attachToRecyclerView(null);
                        helperVertical.attachToRecyclerView(mRecyclerView);

                        menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cardlayout));
                    }
                return true;

            case R.id.item_signout:

                FirebaseAuth.getInstance().signOut();
                Intent isignout = new Intent(AnimalsList.this,UserLogin.class);
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
