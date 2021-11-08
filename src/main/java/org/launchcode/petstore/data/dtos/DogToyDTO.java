package org.launchcode.petstore.data.dtos;

import org.launchcode.petstore.models.Dog;
import org.launchcode.petstore.models.Toy;

import javax.validation.constraints.NotNull;

public class DogToyDTO {

    @NotNull
    private Dog dog;

    @NotNull
    private Toy toy;

    public DogToyDTO() {
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }
}
