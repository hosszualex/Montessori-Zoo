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
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager_Horizontal;
    private RecyclerView.LayoutManager mLayoutManager_Vertical;

    public static boolean viewType;

    public static boolean returnBool () {
        return viewType;
    }



    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    Button signout;
    Button changeViewType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        final ArrayList<Animal_item> animalList = new ArrayList<>();
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFS", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammalasdddddddd"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_android, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_android, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_android, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_android, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_android, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_block, "Wolf", "Mammal"));


        viewType = false;
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


        changeViewType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewType==false)
                {
                    RecyclerView.Adapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(mLayoutManager_Horizontal);
                    mRecyclerView.setAdapter(mAdapter_change);
                    viewType = true;

                }
                else
                    if(viewType==true)
                {
                    RecyclerView.Adapter mAdapter_change;
                    mAdapter_change = new AnimalAdapter(animalList);
                    mRecyclerView.setLayoutManager(mLayoutManager_Vertical);
                    mRecyclerView.setAdapter(mAdapter_change);
                    viewType = false;
                }
            }
        });



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
            }
        });




    }
}
