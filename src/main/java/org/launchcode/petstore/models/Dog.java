package org.launchcode.petstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Dog extends Pet {

    private int age;

    @ManyToOne
    private Owner owner;

    public Dog() { }

    public Dog(String name) {
        this.setName(name);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
