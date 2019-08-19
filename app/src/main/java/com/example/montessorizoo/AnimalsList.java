package com.example.montessorizoo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

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

    private List<Animal> animalList = new ArrayList<>();
    public static int viewType;

    DatabaseReference databaseAnimals; // for firebase storage of  data

    public static final String SHARED_PREFS = "sharedPrefs";

    public static int returnViewType() {
        return viewType;
    }


    public void sendInfoIntent(Intent info, int p, List<Animal> animal) {
        info.putExtra("NAME", animal.get(p).getmName());
        info.putExtra("CLASS", animal.get(p).getmDesc());
        info.putExtra("FOOD", animal.get(p).getmFood());
        info.putExtra("FACTS", animal.get(p).getmFunFacts());
        info.putExtra("IMAGE_URL", animal.get(p).getmImageAnimalURL());
        info.putExtra("MAP_URL", animal.get(p).getmImageMapURL());
        info.putExtra("DETAIL", animal.get(p).getmDetails());
        info.putExtra("SOUND", animal.get(p).getmAudioFile());
    }


    public Observer<Integer> onGetViewType = view -> {
        viewType = view;
        helperHorizontal.attachToRecyclerView(null);
        helperVertical.attachToRecyclerView(null);
        if (viewType == 0) {
            mAdapter = new AnimalAdapter(animalList);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
            helperVertical.attachToRecyclerView(mRecyclerView);
        } else if (viewType == 1) {
            mAdapter = new AnimalAdapter(animalList);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
            helperHorizontal.attachToRecyclerView(mRecyclerView);
        } else if (viewType == 2) {
            mAdapter = new AnimalAdapter(animalList);
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            helperVertical.attachToRecyclerView(mRecyclerView);

        }
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.getFilter().filter(region_selected);
        mAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
            @Override
            public void onItemClick(int position) {
                final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                sendInfoIntent(animalpageIntent, position, animalList);
                startActivity(animalpageIntent);
            }
        });


    };

    public Observer<List<Animal>> onGetAnimalList = animal -> {


        viewType = mAnimalsListViewModel.getViewType().getValue();

        if (viewType == 0) {
            mAdapter = new AnimalAdapter(animal);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
            helperHorizontal.attachToRecyclerView(null);
            helperVertical.attachToRecyclerView(null);
            helperVertical.attachToRecyclerView(mRecyclerView);
        } else if (viewType == 1) {
            mAdapter = new AnimalAdapter(animal);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
            helperHorizontal.attachToRecyclerView(null);
            helperVertical.attachToRecyclerView(null);
            helperHorizontal.attachToRecyclerView(mRecyclerView);
        } else if (viewType == 2) {
            mAdapter = new AnimalAdapter(animal);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            helperHorizontal.attachToRecyclerView(null);
            helperVertical.attachToRecyclerView(null);
            helperVertical.attachToRecyclerView(mRecyclerView);

        }

        mAdapter.getFilter().filter(region_selected);
        mAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() { //clicking the item
            @Override
            public void onItemClick(int position) {
                final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPage.class);
                sendInfoIntent(animalpageIntent, position, animal);
                startActivity(animalpageIntent);
            }
        });

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);


        //view model
        mAnimalsListViewModel = ViewModelProviders.of(AnimalsList.this).get(AnimalsListViewModel.class);
        mAnimalsListViewModel.getAnimals();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        viewType = sharedPreferences.getInt("TYPE", 0);
        mAnimalsListViewModel.init_view(viewType);

        animalList = mAnimalsListViewModel.getAnimal_item().getValue();

        //get the filter
        Intent iFilter = getIntent();
        region_selected = iFilter.getStringExtra("FILTER");

        mRecyclerView = findViewById(R.id.recyclerView_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager_Vertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager_Horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);


        if (viewType == 0)//set layout and orientation properly each time opening the screen, and the icon
        {
            mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
        } else if (viewType == 1) {
            mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
        } else if (viewType == 2) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        }


        // calling the filter


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        helperVertical.attachToRecyclerView(mRecyclerView);


        //clicking on an item from the list


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
        mAnimalsListViewModel.send();
*/


    }


    public void connectViewModel() {
        mAnimalsListViewModel.getAnimal_item().observe(this, onGetAnimalList);
        mAnimalsListViewModel.getViewType().observe(this, onGetViewType);
    }

    public void disconnectViewModel() {
        mAnimalsListViewModel.getAnimal_item().removeObserver(onGetAnimalList);
        mAnimalsListViewModel.getViewType().removeObserver(onGetViewType);

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

        if (viewType == 0) {//set layout and orientation properly each time opening the screen, and the icon
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cardlayout));
        } else if (viewType == 1) {
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_gridlayout));
        } else if (viewType == 2) {
            menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_listlayout));
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_layoutswitch:
                if (viewType == 0)//if its list layout, transform to next layout
                {
                    mAnimalsListViewModel.setViewType(1);

                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_gridlayout));

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("TYPE", viewType);
                    editor.commit();


                } else if (viewType == 1) //if its in card layout, transform to next layout
                {
                    mAnimalsListViewModel.setViewType(2);


                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_listlayout));

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putInt("TYPE", viewType);
                    editor.commit();


                } else if (viewType == 2)//if its in grid layout, transform to next layout
                {

                    mAnimalsListViewModel.setViewType(0);

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
                Intent isignout = new Intent(AnimalsList.this, UserLogin.class);
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //clear the user
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(isignout);
                finish();

                return true;

            case R.id.item_refresh:
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }

    }


}
