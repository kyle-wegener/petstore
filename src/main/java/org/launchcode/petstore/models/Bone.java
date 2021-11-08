package org.launchcode.petstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bone {

    @Id @GeneratedValue
    private int id;
    private String burySpot;
    private String seasoning;

    public Bone() { }

    public int getId() {
        return id;
    }

    public String getBurySpot() {
        return burySpot;
    }

    public void setBurySpot(String burySpot) {
        this.burySpot = burySpot;
    }

    public String getSeasoning() {
        return seasoning;
    }

    public void setSeasoning(String seasoning) {
        this.seasoning = seasoning;
    }
}
