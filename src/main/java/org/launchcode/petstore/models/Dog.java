package org.launchcode.petstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dog extends Pet {

    private int age;

    @ManyToOne
    private Owner owner;

    @OneToOne(cascade = CascadeType.ALL)
    private Bone bone;

    @ManyToMany
    private List<Toy> toys;

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

    public List<Toy> getToys() { return this.toys; }

    public void setToys(List<Toy> toys) { this.toys = toys; }
}
