package com.example.montessorizoo.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
import android.widget.Toast;

import com.example.montessorizoo.Animal;
import com.example.montessorizoo.AnimalAdapter;
import com.example.montessorizoo.AnimalsListViewModel;
import com.example.montessorizoo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AnimalsListActivity extends AppCompatActivity {

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

    private TextToSpeech ttName = null;


    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    private List<Animal> animalList = new ArrayList<>();
    public static int viewType;

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

    public void setAdapter(List<Animal> animal, Integer view) {

        viewType = view;
        if (animal == null || animal.isEmpty()) {
            return;
        }

        mAdapter = new AnimalAdapter(animal);
        mRecyclerView.setAdapter(mAdapter);

        helperHorizontal.attachToRecyclerView(null);
        helperVertical.attachToRecyclerView(null);

        if (viewType == 0) {
            mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
            helperVertical.attachToRecyclerView(mRecyclerView);
        } else if (viewType == 1) {
            mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
            helperHorizontal.attachToRecyclerView(mRecyclerView);
        } else if (viewType == 2) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            helperVertical.attachToRecyclerView(mRecyclerView);
        }

        mAdapter.getFilter().filter(region_selected);
        mAdapter.setOnItemClickListener(position -> {         //clicking the item

            playTextToSpeech(animal.get(position).getmName());

            final Intent animalpageIntent = new Intent(getApplicationContext(), AnimalPageActivity.class);
            sendInfoIntent(animalpageIntent, position, animal);
            startActivity(animalpageIntent);
        });

    }

    public Observer<Integer> onGetViewType = view -> {
        List<Animal> animalList = mAnimalsListViewModel.getAnimal_item().getValue();
        setAdapter(animalList, view);

    };

    public Observer<List<Animal>> onGetAnimalList = animal -> {
        setAdapter(animal, mAnimalsListViewModel.getViewType().getValue());
    };

    private Observer<Void> onError = error -> {
        Toast.makeText(this, "Failed to get animals", Toast.LENGTH_LONG).show();
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);


        //view model
        mAnimalsListViewModel = ViewModelProviders.of(AnimalsListActivity.this).get(AnimalsListViewModel.class);
        mAnimalsListViewModel.getAnimals();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        viewType = sharedPreferences.getInt("TYPE", 0);
        mAnimalsListViewModel.init_view(viewType);
        //get the filter
        Intent iFilter = getIntent();
        region_selected = iFilter.getStringExtra("FILTER");

        mRecyclerView = findViewById(R.id.recyclerView_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager_Vertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager_Horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        initTextToSpeech();

        if (viewType == 0)  //set layout and orientation properly each time opening the screen, and the icon
        {
            mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
        } else if (viewType == 1) {
            mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
        } else if (viewType == 2) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        }

        helperVertical.attachToRecyclerView(mRecyclerView);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


    }


    public void connectViewModel() {
        mAnimalsListViewModel.onError().observe(this, onError);
        mAnimalsListViewModel.getAnimal_item().observe(this, onGetAnimalList);
        mAnimalsListViewModel.getViewType().observe(this, onGetViewType);
    }

    public void disconnectViewModel() {
        mAnimalsListViewModel.onError().removeObserver(onError);
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
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (item.getItemId()) {
            case R.id.item_layoutswitch:
                if (viewType == 0)//if its list layout, transform to next layout
                {
                    mAnimalsListViewModel.setViewType(1);
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_gridlayout));

                } else if (viewType == 1) //if its in card layout, transform to next layout
                {
                    mAnimalsListViewModel.setViewType(2);
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_listlayout));

                } else if (viewType == 2)//if its in grid layout, transform to next layout
                {
                    mAnimalsListViewModel.setViewType(0);
                    menu.getItem(1).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_cardlayout));
                }

                editor.putInt("TYPE", viewType);
                editor.apply();
                return true;

            case R.id.item_signout:

                editor.putInt("TYPE", 0);
                editor.commit();

                FirebaseAuth.getInstance().signOut();
                Intent isignout = new Intent(AnimalsListActivity.this, LoginActivity.class);
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //clear the user
                isignout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(isignout);
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void initTextToSpeech() {
       ttName = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                ttName.setLanguage(Locale.ENGLISH);
            }
        });
    }

    private void playTextToSpeech(String text) {
        ttName.setSpeechRate((float) 0.7);
        ttName.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if(ttName != null ){
            ttName.stop();
            ttName.shutdown();
        }
        super.onDestroy();
    }

}

