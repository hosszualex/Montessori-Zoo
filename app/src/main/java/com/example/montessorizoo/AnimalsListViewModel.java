package com.example.montessorizoo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.montessorizoo.interfaces.IAnimalRepository;

import java.util.List;

public class AnimalsListViewModel extends ViewModel {

    private MutableLiveData<List<Animal>> mAnimal_item = new MutableLiveData<>();
    private Animal_itemRepository mRepo = new Animal_itemRepository();
    private SingleLiveEvent<Integer> viewType = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> onError = new SingleLiveEvent<>();


    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void getAnimals(){

        mRepo.getAnimals(new IAnimalRepository.OnGetAnimalsListener() {
            @Override
            public void onSuccess(List<Animal> animals) {
                mAnimal_item.setValue(animals);
            }

            @Override
            public void onError(String error) { onError.call(); }
        });

    }

    public LiveData<Void> onError() {
        return onError;
    }

    public void init_view(int x){
        viewType.setValue(x);
    }

    public void setViewType(int x){
        viewType.setValue(x);
    }

    public LiveData<Integer> getViewType(){
        return viewType;
    }

    public LiveData<List<Animal>> getAnimal_item(){
        return mAnimal_item;
    }



}
