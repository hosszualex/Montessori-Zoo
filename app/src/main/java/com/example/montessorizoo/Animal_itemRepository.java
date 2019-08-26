package com.example.montessorizoo;

import android.support.annotation.NonNull;

import com.example.montessorizoo.repository.IAnimalRepository;
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

    private List<Animal> getLocalAnimals() {
        List<Animal> dataset = new ArrayList<>();
        addToListAfrica(dataset);
        addToListJungle(dataset);
        addToListNorthAmerica(dataset);
        addToListOcean(dataset);
        return dataset;
    }


    public void addToListNorthAmerica(List<Animal> dataSet) {
        dataSet.add(new Animal("https://www.wolf.org/wp-content/uploads/2019/04/5D3_3666.jpg",
                "Wolf", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://cdn.pixabay.com/photo/2014/07/08/12/38/mammal-386740__340.jpg",
                "Moose", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/whale_sound.wav?alt=media&token=9dd6a99e-b812-41ec-93d7-e066717ec74b", "North America"));
        dataSet.add(new Animal("https://i.cbc.ca/1.4689926.1553908134!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/cougar-stock.jpg",
                "Cougar", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));

    }


    public void addToListAfrica(List<Animal> dataSet) {
        dataSet.add(new Animal("https://media.istockphoto.com/photos/lion-panthera-leo-10-years-old-isolated-on-white-picture-id877369086?k=6&m=877369086&s=612x612&w=0&h=0BMW4rBBkmoiU0MdMEHN7Qk_lHatvMTeOcdsJHWV8-M=",
                "Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://media.istockphoto.com/photos/lion-panthera-leo-10-years-old-isolated-on-white-picture-id877369086?k=6&m=877369086&s=612x612&w=0&h=0BMW4rBBkmoiU0MdMEHN7Qk_lHatvMTeOcdsJHWV8-M=",
                "Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://media.istockphoto.com/photos/lion-panthera-leo-10-years-old-isolated-on-white-picture-id877369086?k=6&m=877369086&s=612x612&w=0&h=0BMW4rBBkmoiU0MdMEHN7Qk_lHatvMTeOcdsJHWV8-M=",
                "Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));

    }

    public void addToListJungle(List<Animal> dataSet) {
        dataSet.add(new Animal("https://images.pexels.com/photos/1463295/pexels-photo-1463295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Parrot", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://images.pexels.com/photos/1463295/pexels-photo-1463295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Parrot1", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://images.pexels.com/photos/1463295/pexels-photo-1463295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Parrot", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
    }
    public void addToListOcean(List<Animal> dataSet){
        dataSet.add(new Animal("https://amp.thenational.ae/image/policy:1.822664:1549456902/lf06-feb-green-planet.jpg?f=16x9&w=1200&$p$f$w=cf32817",
                "Piranha", "Fish", "Meat", "They have been living in South America for millions of years",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "A piranha or piraña (/pɪˈrɑːnjə/, /pɪˈrænjə/, or /pɪˈrɑːnə/; Portuguese: [piˈɾɐ̃ɲɐ], Spanish: [piˈɾaɲa]), a member of family Characidae[1] in order Characiformes, is a freshwater fish that inhabits South American rivers, floodplains, lakes and reservoirs. Although often described as extremely predatory and mainly feeding on fish, their dietary habits vary extensively, and they will also take plant material,[2] leading to their classification as omnivorous.[3]",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147","Ocean"));
    }

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

    @Override
    public void uploadAnimals(OnUploadAnimalsListener listener) {
        List<Animal> dataSet = getLocalAnimals();
        databaseAnimals = FirebaseDatabase.getInstance().getReference();

        databaseAnimals.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (int i = 0; i < dataSet.size(); i++) {
                    int ok = 0;
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        if (ds.child(dataSet.get(i).getmRegion()).child(dataSet.get(i).getmName()).exists()) {
                            ok = 1;
                            break;
                        }


                    }
                    if (ok == 0) {
                        databaseAnimals.child(dataSet.get(i).getmRegion()).child(dataSet.get(i).getmName()).setValue(dataSet.get(i));

                    }
                }
                listener.onSuccess();
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
    }

}