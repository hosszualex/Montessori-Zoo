package com.example.montessorizoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class AnimalsList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    Button signout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        ArrayList<Animal_item> animalList = new ArrayList<>();
        animalList.add(new Animal_item(R.drawable.ic_android, "WolfSDFSDFSDFSDFSDFFSDFDSFSDFDSFSDFSDFSDFSDFFDFSFFFF", "Mammal"));
        animalList.add(new Animal_item(R.drawable.ic_all_out, "Wolf", "Mammalasddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
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



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AnimalAdapter(animalList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);




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
