package com.example.montessorizoo.interfaces;

import com.example.montessorizoo.Animal;

import java.util.List;

public interface IAnimalRepository extends IMVVMBaseRepository {

    public void getAnimals(OnGetAnimalsListener listener);

    public interface OnGetAnimalsListener {

        void onSuccess(List<Animal> animals);

        void onError(String error);
    }

}
