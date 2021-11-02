package org.launchcode.petstore.data;

import org.launchcode.petstore.models.Dog;

import java.util.ArrayList;

public class DogData {

    private static ArrayList<Dog> dogs = new ArrayList<>();

    public static void addDog(Dog dog) {
        dogs.add(dog);
    }

    public static ArrayList<Dog> getAllDogs() {
        return dogs;
    }

    public static ArrayList<Dog> getDogsByName(String name) {
        ArrayList<Dog> results = new ArrayList<>();
        for (Dog dog : dogs) {
            if (dog.getName().toUpperCase().equals(name.toUpperCase())) {
                results.add(dog);
            }
        }
        return results;
    }

}
