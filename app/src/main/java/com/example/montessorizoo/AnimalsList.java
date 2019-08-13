package com.example.montessorizoo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AnimalsList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AnimalAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager_Horizontal;
    private RecyclerView.LayoutManager mLayoutManager_Vertical;
    final SnapHelper helperHorizontal = new PagerSnapHelper();
    final SnapHelper helperVertical = new LinearSnapHelper();
    private Menu menu;

    private AnimalsListViewModel mAnimalsListViewModel;

    private static String region_selected;

    Toolbar toolbar;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    private List<Animal_item> animalList = new ArrayList<>();
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
        info.putExtra("IMAGE_URL", animalList.get(p).getmImageAnimalURL());
        info.putExtra("MAP_URL", animalList.get(p).getmImageMapURL());
        info.putExtra("DETAIL", animalList.get(p).getmDetails());
        info.putExtra("SOUND", animalList.get(p).getmAudioFile());
    }

    public static String getFilter(){
        return region_selected;
    }


    public Observer <List<Animal_item>> onGetAnimalList = animal -> {

        mAdapter = new AnimalAdapter(animal);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.getFilter().filter(region_selected);
        mAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
            @Override
            public void onItemClick(int position) {
                final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                sendInfoIntent(animalpageIntent, position);
                startActivity(animalpageIntent);
            }
        });


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);


        databaseAnimals = FirebaseDatabase.getInstance().getReference("Region").child("Animal");


        //view model
        mAnimalsListViewModel = ViewModelProviders.of(AnimalsList.this).get(AnimalsListViewModel.class);
        mAnimalsListViewModel.init();
/*
        animalList = mAnimalsListViewModel.getAnimal_item().getValue() ;
*/




/*
        for(int i=0;i<animalList.size();i++){
            String id = databaseAnimals.push().getKey();
            databaseAnimals.child(id).setValue(animalList.get(i));

        }
*/



        //get the filter
        Intent iFilter = getIntent();
        region_selected = iFilter.getStringExtra("FILTER");

        mRecyclerView = findViewById(R.id.recyclerView_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager_Vertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager_Horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        viewType = sharedPreferences.getInt("TYPE", 0);


        if(viewType == 0)//set layout and orientation properly each time opening the screen, and the icon
        {mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
        }
        else
            if(viewType == 1) {
                mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
            }
            else
                if(viewType == 2){
                    mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
                }




 // calling the filter


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        helperVertical.attachToRecyclerView(mRecyclerView);


        //clicking on an item from the list





        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }


    public void connectViewModel(){
        mAnimalsListViewModel.getAnimal_item().observe(this, onGetAnimalList);

    }

    public void disconnectViewModel(){
        mAnimalsListViewModel.getAnimal_item().removeObserver(onGetAnimalList);

    }

    @Override
    protected void onResume() {
        super.onResume();
        connectViewModel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        disconnectViewModel();
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

            case  R.id.item_refresh:
                return true;


                default:
                    return super.onOptionsItemSelected(item);

        }

    }


}
