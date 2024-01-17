package com.example.montessorizoo;

import android.support.annotation.NonNull;

import com.example.montessorizoo.interfaces.IAnimalRepository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Animal_itemRepository implements IAnimalRepository {

    DatabaseReference databaseAnimals; // for firebase storage of  data
    ValueEventListener listener;
    List<String> regions = new ArrayList<>();

    @Override
    public void onRemoveEventListeners() {
        databaseAnimals.removeEventListener(listener);

    }

    @Override
    public void getAnimals(OnGetAnimalsListener listener) {
        databaseAnimals = FirebaseDatabase.getInstance().getReference();
        addRegions();
        databaseAnimals.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Animal> animals = new ArrayList<>();
                for (int i = 0; i < regions.size(); i++) {
                    for (DataSnapshot ds : dataSnapshot.child(regions.get(i)).getChildren()) {
                        animals.add(ds.getValue(Animal.class));
                    }
                }
                listener.onSuccess(animals);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onError(databaseError.getMessage());
            }
        });
    }
    public void addRegions() {
        regions.add("North America");
        regions.add("Africa");
        regions.add("Jungle");
        regions.add("Ocean");
        regions.add("Australia");
        regions.add("Arctic");
        regions.add("Farm");
        regions.add("Asia");
        regions.add("Bird");
    }

}