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
        addToListAustralia(dataset);
        return dataset;
    }


    public void addToListNorthAmerica(List<Animal> dataSet) {
        dataSet.add(new Animal("https://www.wolf.org/wp-content/uploads/2019/04/5D3_3666.jpg",
                "Wolf", "Mammal", "Carnivora", "They travel and hunt in packs. The average pack size is 5 to 8 wolfs. The average travel speed is 8 km/h.",
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
        dataSet.add(new Animal("http://d279m997dpfwgl.cloudfront.net/wp/2019/08/0812-coyote-masswildlife-1000x561.jpg",
                "Coyote", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://a57.foxnews.com/media2.foxnews.com/BrightCove/694940094001/2019/02/13/931/524/694940094001_6001731668001_6001731174001-vs.jpg?ve=1&tl=1",
                "Deer", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://scx1.b-cdn.net/csz/news/800/2018/atelunoranch.jpg",
                "Bison", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://www.manitobapost.com/media/imager/201807/109060-posts.feature_md.jpg",
                "Black Bear", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://cottagelife.com/wp-content/uploads/2017/10/shutterstock_129952142-1200x801.jpg",
                "Raccoon", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://i.cbc.ca/1.4689926.1553908134!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/cougar-stock.jpg",
                "Squirrel", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://i.cbc.ca/1.4689926.1553908134!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/cougar-stock.jpg",
                "Porcupine", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://www.wildlifetrusts.org/sites/default/files/styles/node_hero_default/public/2018-10/Beaverwalksingrassymeadow0375.jpg?h=35dc75a1&itok=0Dx7qsV5",
                "Beaver", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://news.wttw.com/sites/default/files/field/image/Alligators_0711.jpg",
                "Alligator", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://upload.wikimedia.org/wikipedia/commons/d/d3/Fischotter%2C_Lutra_Lutra.JPG",
                "Otter", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://media.nature.com/w700/magazine-assets/d41586-018-01681-3/d41586-018-01681-3_15440080.jpg",
                "Rattlesnake", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "North America"));
        dataSet.add(new Animal("https://www.thesprucepets.com/thmb/6rn5Z6DsIDG-OO0xhk8bZiN6tnA=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/SprayingSkunk200352420-001-56a9c2153df78cf772aa4b07.jpg",
                "Skunk", "Mammal", "Meat", "They hunt in packs",
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
        dataSet.add(new Animal("https://www.abc.net.au/news/image/10418702-3x2-940x627.jpg",
                "African Elephant", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://thumbs-prod.si-cdn.com/2QJ2cOtSBwOEfBwZoyTw3li0wKA=/800x600/filters:no_upscale()/https://public-media.si-cdn.com/filer/32/f2/32f24473-b380-43f5-94df-da0e58644439/16301090250_acf80be87f_o.jpg",
                "Giraffe", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://s.abcnews.com/images/GMA/190227_gma_oquendo2_0731_hpMain_16x9_992.jpg",
                "Rhinoceros", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://resize.hswstatic.com/w_907/gif/hippo-sunscreen.jpg",
                "Hippopotamus", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fjvchamary%2Ffiles%2F2016%2F01%2Fzebra-1200x800.jpg",
                "Zebra", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://thenypost.files.wordpress.com/2018/05/180507-hunting-jaguar-uganda-feature.jpg?quality=90&strip=all&w=618&h=410&crop=1",
                "Leopard", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fjvchamary%2Ffiles%2F2016%2F01%2Fzebra-1200x800.jpg",
                "Cheetah", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://www.lionworldtravel.com/sites/default/files/styles/large/public/blog/Wildbeest-Looking-Hero.jpg?itok=QfvoxGZl",
                "Wildebeest", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://cdn.vox-cdn.com/thumbor/mptDAdyvyYZ72PoJkJcp9KkcVC0=/0x0:659x463/1200x800/filters:focal(375x256:479x360)/cdn.vox-cdn.com/uploads/chorus_image/image/60096783/Screen_Shot_2018_06_18_at_11.21.26_AM.0.png",
                "Hyena", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://assets3.thrillist.com/v1/image/2782161/size/tmg-article_tall;jpeg_quality=20.jpg",
                "Gorilla", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://upload.wikimedia.org/wikipedia/commons/3/35/Olive_baboon_Ngorongoro.jpg",
                "Baboon", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("http://www.krugerpark.co.za/images/1-warthog-gc590a.jpg",
                "Warthog", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://www.thoughtco.com/thmb/X2tigzLPQ7Fos9_LjzqSWwiBQiI=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-822539340-5c80189c46e0fb00019b8ec4.jpg",
                "Crocodile", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://cdn.britannica.com/20/154120-004-6FEE3A9C.jpg",
                "Lemur", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Africa"));
        dataSet.add(new Animal("https://www.dw.com/image/47406105_303.jpg",
                "Honey Badger", "Mammal", "Meat", "They hunt in packs",
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
        dataSet.add(new Animal("http://d2a5vhda9v4n4x.cloudfront.net/wp-content/uploads/2018/06/red-eyed-tree-frog-1.jpg",
                "Tree Frogs", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://www.thoughtco.com/thmb/0aXBvwp8UHbq88j-xCv3vBL_Qsw=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-699100285-5c8c29e646e0fb0001770056.jpg",
                "Chameleons", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://86cb8127dc14737f5057-7c0671222953158607ea93d5febd68b4.ssl.cf1.rackcdn.com/1/assets/responsive/520000/520317/web_caringforyourpetboaconstrictor.png",
                "Boa Constrictors", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://cdn.mos.cms.futurecdn.net/B7PApvF2ofPLu26SGgt3Yc-320-80.jpg",
                "Python", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://www.dw.com/image/45094704_303.jpg",
                "Orangutans", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://www.wildrepublic.com/wp-content/uploads/2018/11/Jaguar-xl-600x404.jpg",
                "Jaguar", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://i.kinja-img.com/gawker-media/image/upload/s--3t4ZRLLa--/c_scale,f_auto,fl_progressive,q_80,w_800/glyyjnuyxsbxtqnocmwh.jpg",
                "Panther", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));
        dataSet.add(new Animal("https://rangerrick.org/wp-content/uploads/2018/06/featured_slothbears-1.jpg",
                "Sloth Bears", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Jungle"));

    }

    public void addToListOcean(List<Animal> dataSet) {
        dataSet.add(new Animal("https://amp.thenational.ae/image/policy:1.822664:1549456902/lf06-feb-green-planet.jpg?f=16x9&w=1200&$p$f$w=cf32817",
                "Piranha", "Fish", "Meat", "They have been living in South America for millions of years",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "A piranha or piraña (/pɪˈrɑːnjə/, /pɪˈrænjə/, or /pɪˈrɑːnə/; Portuguese: [piˈɾɐ̃ɲɐ], Spanish: [piˈɾaɲa]), a member of family Characidae[1] in order Characiformes, is a freshwater fish that inhabits South American rivers, floodplains, lakes and reservoirs. Although often described as extremely predatory and mainly feeding on fish, their dietary habits vary extensively, and they will also take plant material,[2] leading to their classification as omnivorous.[3]",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://ichef.bbci.co.uk/news/660/cpsprodpb/AF92/production/_97464944_gettyimages-529743649.jpg",
                "Blue Whale", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://www.thoughtco.com/thmb/IMxeaMbyeipX-96qpCjo_KE2UD8=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-826128004-6cb21c0037424480b047a648e294e669.jpg",
                "Killer Whale", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://images2.minutemediacdn.com/image/upload/c_crop,h_1778,w_3155,x_0,y_843/f_auto,q_auto,w_1100/v1554928552/shape/mentalfloss/540093-istock-514343279.jpg",
                "Dolphin", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("http://floridapets.com/WebRoot/Store6/Shops/047c0125-dd4b-4d34-97de-30717de1adee/5BFC/132D/7548/AD52/2AE3/0A48/331F/297B/Ocellaris-clown-seg.jpg",
                "Clownfish", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://www.thoughtco.com/thmb/_dAD4G61zlVwKOKp1_O6A7INe54=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/swordfish-jeff-rotman-getty-56a5f8eb5f9b58b7d0df532f.jpg",
                "Swordfish", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://daily.jstor.org/wp-content/uploads/2019/07/how_to_make_quicksand_like_an_octopus_1050x700.jpg",
                "Octopus", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://www.hakaimagazine.com/wp-content/uploads/header-green-crabs2.jpg",
                "Crab", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://i.pinimg.com/originals/5a/3a/48/5a3a48202f5b8bc8436de8d27dd32516.jpg",
                "Lobster", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://rangerrick.org/wp-content/uploads/2018/03/Turtle-Tale-RR-Jr-June-July-2017.jpg",
                "Sea Turtle", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://www.sookenewsmirror.com/wp-content/uploads/2019/05/17001605_web1_190529-UWN-Sea-lion-shot-park-reserve_1.jpg",
                "Sea Lion", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://pmdvod.nationalgeographic.com/NG_Video/86/763/190717-south-africa-humpback-whales-comeback-animals.jpg",
                "Humpback Whale", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://upload.wikimedia.org/wikipedia/commons/5/56/White_shark.jpg",
                "Great White Shark", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://images.theconversation.com/files/150289/original/image-20161215-13663-1o37rfi.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=496&fit=clip",
                "Seahorse", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://www.verywellhealth.com/thmb/Ox5__j9ESZrOqcvg7CLm75wQ-u8=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1235399542-592cf7455f9b5859500a86e3.jpg",
                "Stingray", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));
        dataSet.add(new Animal("https://www.montereybayaquarium.org/-/m/images/animal-guide/fishes/scalloped-hammerhead-shark.jpg?bc=white&h=798&mh=916&mw=1222&w=1061&usecustomfunctions=1&cropx=70&cropy=0",
                "Hammerhead Shark", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147", "Ocean"));

    }

    public void addToListAustralia(List<Animal> dataSet){
        dataSet.add(new Animal("https://cdn.vox-cdn.com/thumbor/m3Bf1OCbMaR76bfYY3Ez6KerM6M=/0x0:3000x2000/1200x800/filters:focal(0x0:3000x2000)/cdn.vox-cdn.com/uploads/chorus_image/image/49468403/GettyImages-512657552.0.jpg",
                "Kangaroo", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://media.mnn.com/assets/images/2019/05/koala.jpg.653x0_q80_crop-smart.jpg",
                "Koala", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://upload.wikimedia.org/wikipedia/commons/1/18/Vombatus_ursinus_-Maria_Island_National_Park.jpg",
                "Wombat", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://images2.minutemediacdn.com/image/upload/c_crop,h_1376,w_2045,x_0,y_52/v1554744537/shape/mentalfloss/63062-istock-658344164.jpg?itok=OZhcdSUz",
                "Platypus", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://images.immediate.co.uk/production/volatile/sites/23/2014/11/GettyImages-123529247-2a29d6c.jpg?quality=45&resize=620,413",
                "Saltwater Crocodile", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://upload.wikimedia.org/wikipedia/commons/e/e7/Tiliqua_scincoides_scincoides.jpg",
                "Blue Tongue Lizard", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://cdn.britannica.com/92/171292-004-2F6D1882.jpg",
                "Dingo", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));
        dataSet.add(new Animal("https://www.thoughtco.com/thmb/6NLCarMNcI6rPEuTZmL_SS8z8i4=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/thorny1-f7ebb22faae84d6883b4a82923f0e57c.jpg",
                "Thorny Devil", "Mammal", "Meat", "They hunt in packs",
                "http://www.chartandmapshop.com.au/productImages/full/8599.jpg",
                "The wolf (Canis lupus), also known as the gray/grey wolf, timber wolf, or tundra wolf, is a canine native to the wilderness and remote areas of Eurasia and North America. It i",
                "https://firebasestorage.googleapis.com/v0/b/montessori-zoo.appspot.com/o/wolf_sound.wav?alt=media&token=0a811a4f-b487-4b52-88e0-90ac9941e147",
                "Australia"));


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
        regions.add("Australia");
    }

}