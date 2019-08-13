package com.example.montessorizoo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class AnimalsListViewModel extends ViewModel {

    private MutableLiveData<List<Animal_item>> mAnimal_item;
    private Animal_itemRepository mRepo = new Animal_itemRepository();
    private MutableLiveData<Integer> viewType = new MutableLiveData<>();

    public void init_animals(){

        if(mAnimal_item != null){
            return;
        }
        mAnimal_item = mRepo.getAnimal_item();



    }
    public void init_view(){
        viewType.setValue(0);
    }

    public void setViewType(int x){
        viewType.setValue(x);
    }

    public LiveData<Integer> getViewType(){
        return viewType;
    }

    public LiveData<List<Animal_item>> getAnimal_item(){
        return mAnimal_item;
    }



}
