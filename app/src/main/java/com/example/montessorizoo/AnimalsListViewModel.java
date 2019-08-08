package com.example.montessorizoo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class AnimalsListViewModel extends ViewModel {

    private MutableLiveData<List<Animal_item>> mAnimal_item;
    private Animal_itemRepository mRepo = new Animal_itemRepository();

    public void init(){

        if(mAnimal_item != null){
            return;
        }
        mAnimal_item = mRepo.getAnimal_item();

    }




    public LiveData<List<Animal_item>> getAnimal_item(){
        return mAnimal_item;
    }



}
