package com.example.montessorizoo;

import android.media.MediaPlayer;
import android.provider.MediaStore;

public class Animal_item {

    private int mImageAnimal;
    private String mName;
    private String mDesc;
    private String mFood;
    private String mFunFacts;
    private int mImageMap;
    private MediaPlayer mSound;


    public Animal_item(int mImageAnimal, String mName, String mDesc, String mFood, String mFunFacts, int mImageMap, MediaPlayer mSound){
        this.mImageAnimal=mImageAnimal;
        this.mName = mName;
        this.mDesc = mDesc;
        this.mFood = mFood;
        this.mFunFacts = mFunFacts;
        this.mImageMap = mImageMap;
        this.mSound = MediaPlayer.create(this, mSound);


    }

    public void changeText1(String text){
        mName = text;
    }

    public int getmImageAnimal(){
        return mImageAnimal;
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

    public int getmImageMap() {
        return mImageMap;
    }

    public MediaPlayer getmSound() {
        return mSound;
    }

    public void setmImageAnimal(int mImageAnimal) {
        this.mImageAnimal = mImageAnimal;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }



}
