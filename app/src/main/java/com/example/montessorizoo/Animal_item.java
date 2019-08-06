package com.example.montessorizoo;

import android.widget.ImageView;

public class Animal_item {

    private String mImageAnimalURL;
    private String mName;
    private String mDesc;
    private String mFood;
    private String mFunFacts;
    private String mImageMapURL;
    private String mDetails;
    private String mAudioFile;
    private String mRegion;


    public Animal_item(String mImageAnimal, String mName, String mDesc, String mFood, String mFunFacts, String mImageMap, String mDetails, String mAudioFile,String mRegion){
        this.mImageAnimalURL=mImageAnimal;
        this.mName = mName;
        this.mDesc = mDesc;
        this.mFood = mFood;
        this.mFunFacts = mFunFacts;
        this.mImageMapURL = mImageMap;
        this.mDetails = mDetails;
        this.mAudioFile = mAudioFile;
        this.mRegion = mRegion;

    }
    public Animal_item(){};

    public void changeText1(String text){
        mName = text;
    }

    public String getmImageAnimalURL(){
        return mImageAnimalURL;
    }

    public String getmName() {
        return mName;
    }

    public String getmDesc() {
        return mDesc;
    }

    public String getmFood() {
        return mFood;
    }

    public String getmFunFacts() {
        return mFunFacts;
    }

    public String getmImageMap() {
        return mImageMapURL;
    }

    public String getmDetails() {
        return mDetails;
    }

    public String getmAudioFile() {
        return mAudioFile;
    }

    public String getmRegion() {
        return mRegion;
    }



    public void setmImageAnimalURL(String mImageAnimal) {
        this.mImageAnimalURL = mImageAnimal;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }



}
