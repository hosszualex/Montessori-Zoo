package com.example.montessorizoo.repository;

import com.example.montessorizoo.Animal;

import java.util.List;

public interface IAnimalRepository extends IMVVMBaseRepository {


/*
    public void setAnimals(OnSetAnimalsListener listener);
*/

    public interface OnGetAnimalsListener {

        void onSuccess(List<Animal> animals);

        void onError(String error);
    }

    public void getAnimals(OnGetAnimalsListener listener);




/*    public interface OnSetAnimalsListener {

        void onSuccess();

        void onError(String error);
    }*/
}
