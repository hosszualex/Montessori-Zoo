package com.example.montessorizoo;

import android.arch.lifecycle.MutableLiveData;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class Animal_itemRepository {

    DatabaseReference databaseAnimals; // for firebase storage of  data
    private static Animal_itemRepository instance;
    private ArrayList<Animal_item> dataSet = new ArrayList<>();


    public MutableLiveData<List<Animal_item>> getAnimal_item() {

        setAnimal_item();

        MutableLiveData<List<Animal_item>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;

    }

    private void setAnimal_item() {

        addToListAfrica();
        addToListJungle();
        addToListNorthAmerica();

    }



    public void addToListNorthAmerica() {
        dataSet.add(new Animal_item("https://www.wolf.org/wp-content/uploads/2019/04/5D3_3666.jpg",
                "Wolf", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "North America"));
        dataSet.add(new Animal_item("https://cdn.pixabay.com/photo/2014/07/08/12/38/mammal-386740__340.jpg",
                "Moose", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "North America"));
        dataSet.add(new Animal_item("https://i.cbc.ca/1.4689926.1553908134!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/cougar-stock.jpg",
                "Cougar", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "North America"));


    }


    public void addToListAfrica() {
        dataSet.add(new Animal_item("https://media.istockphoto.com/photos/lion-panthera-leo-10-years-old-isolated-on-white-picture-id877369086?k=6&m=877369086&s=612x612&w=0&h=0BMW4rBBkmoiU0MdMEHN7Qk_lHatvMTeOcdsJHWV8-M=",
                "Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Africa"));
        dataSet.add(new Animal_item("https://media.istockphoto.com/photos/lion-panthera-leo-10-years-old-isolated-on-white-picture-id877369086?k=6&m=877369086&s=612x612&w=0&h=0BMW4rBBkmoiU0MdMEHN7Qk_lHatvMTeOcdsJHWV8-M=",
                "Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Africa"));
        dataSet.add(new Animal_item("https://media.istockphoto.com/photos/lion-panthera-leo-10-years-old-isolated-on-white-picture-id877369086?k=6&m=877369086&s=612x612&w=0&h=0BMW4rBBkmoiU0MdMEHN7Qk_lHatvMTeOcdsJHWV8-M=",
                "Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Africa"));

    }

    public void addToListJungle() {
        dataSet.add(new Animal_item("https://images.pexels.com/photos/1463295/pexels-photo-1463295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Parrot", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
        dataSet.add(new Animal_item("https://images.pexels.com/photos/1463295/pexels-photo-1463295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Parrot", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
        dataSet.add(new Animal_item("https://images.pexels.com/photos/1463295/pexels-photo-1463295.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Parrot", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "wolf_sound", "Jungle"));
    }
}