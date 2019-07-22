package com.example.montessorizoo;

public class Animal_item {

    private int mImageAnimal;
    private String mName;
    private String mDesc;

    public Animal_item(int mImageAnimal,String mName, String mDesc){
        this.mImageAnimal=mImageAnimal;
        this.mName = mName;
        this.mDesc = mDesc;

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
