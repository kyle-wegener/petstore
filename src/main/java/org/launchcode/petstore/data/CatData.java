package org.launchcode.petstore.data;

import org.launchcode.petstore.models.Cat;
import java.util.ArrayList;

public class CatData {

    private static ArrayList<Cat> cats = new ArrayList<>();

    public static void addCat(Cat cat) {
        cats.add(cat);
    }

    public static ArrayList<Cat> getAllCats() {
        return cats;
    }

    public static ArrayList<Cat> getCatsByName(String name) {
        ArrayList<Cat> results = new ArrayList<>();
        for (Cat cat : cats) {
            if (cat.getName().toUpperCase().equals(name.toUpperCase())) {
                results.add(cat);
            }
        }
        return results;
    }

}
