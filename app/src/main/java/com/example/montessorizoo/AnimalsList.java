package com.example.montessorizoo;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AnimalsList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AnimalAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager_Horizontal;
    private RecyclerView.LayoutManager mLayoutManager_Vertical;
    final SnapHelper helperHorizontal = new PagerSnapHelper();
    final SnapHelper helperVertical = new LinearSnapHelper();
    private Menu menu;


    private static String region_selected;

    Toolbar toolbar;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    final ArrayList<Animal_item> animalList = new ArrayList<>();
    public static int viewType;

    DatabaseReference databaseAnimals; // for firebase storage of  data

    public static final String SHARED_PREFS = "sharedPrefs";

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

    public void addToListNorthAmerica (){
        animalList.add(new Animal_item(R.drawable.wolf, "Wolf", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "North America"));
        animalList.add(new Animal_item(R.drawable.moose, "Moose", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "North America"));
        animalList.add(new Animal_item(R.drawable.cougar, "Cougar", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "North America"));



    }

    public void addToListAfrica(){
        animalList.add(new Animal_item(R.drawable.lion, "Lion", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Africa"));
        animalList.add(new Animal_item(R.drawable.african_elephant, "African Elephant", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Africa"));
        animalList.add(new Animal_item(R.drawable.zebra, "Zebra", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Africa"));

    }

    public void addToListJungle(){
        animalList.add(new Animal_item(R.drawable.chameleon, "Chameleon", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
        animalList.add(new Animal_item(R.drawable.parrot, "Parrot", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
        animalList.add(new Animal_item(R.drawable.python, "Python", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
        animalList.add(new Animal_item(R.drawable.tree_frog, "Tree Frog", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
        animalList.add(new Animal_item(R.drawable.jaguar, "Jaguar", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
    }

    public void addToListOcean(){
        ArrayList<Animal_item> animal_ocean = new ArrayList<>();
        animal_ocean.add(new Animal_item(R.drawable.jaguar, "Jaguar", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Ocean"));
        animal_ocean.add(new Animal_item(R.drawable.jaguar, "FISH", "Mammal", "Meat", "They hunt in packs",R.drawable.wolf_map, "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Ocean"));
        int i;
        for(i = 0; i < 2; i++)
        {
            databaseAnimals.child(animal_ocean.get(i).getmRegion()).child(animal_ocean.get(i).getmName()).setValue(animal_ocean.get(i));
        }

    }

    public static String getFilter(){
        return region_selected;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        //firebase testing workspace

        databaseAnimals = FirebaseDatabase.getInstance().getReference("Region");
        addToListOcean();




        addToListNorthAmerica();
        addToListAfrica();
        addToListJungle();

        //get the filter
        Intent iFilter = getIntent();
        region_selected = iFilter.getStringExtra("FILTER");

        mRecyclerView = findViewById(R.id.recyclerView_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager_Vertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager_Horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new AnimalAdapter(animalList);


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        viewType = sharedPreferences.getInt("TYPE", 0);


        if(viewType == 0)//set layout and orientation properly each time opening the screen, and the icon
        {mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
           // menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_gridlayout));
        }
        else
            if(viewType == 1) {
                mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
               // menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_listlayout));
            }
            else
                if(viewType == 2){
                    mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
                    //menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cardlayout));
                }




        mRecyclerView.setAdapter(mAdapter);
        mAdapter.getFilter().filter(region_selected); // calling the filter


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

        if(viewType == 0){//set layout and orientation properly each time opening the screen, and the icon
             menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cardlayout));
        }
        else
        if(viewType == 1) {
             menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_gridlayout));
        }
        else
        if(viewType == 2){
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_listlayout));
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_layoutswitch:
                if(viewType==0)//if its list layout, transform to next layout
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

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("TYPE", viewType);
                    editor.commit();


                }
                else
                if(viewType==1) //if its in card layout, transform to next layout
                {
                    AnimalAdapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
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

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putInt("TYPE", viewType);
                    editor.commit();



                }
                else
                    if(viewType==2)//if its in grid layout, transform to next layout
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

                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putInt("TYPE", viewType);
                        editor.commit();


                    }
                return true;

            case R.id.item_signout:

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("TYPE", 0);
                editor.commit();

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
