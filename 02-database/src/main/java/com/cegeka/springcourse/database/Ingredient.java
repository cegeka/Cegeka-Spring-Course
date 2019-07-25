package com.cegeka.springcourse.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Ingredient {

    private int id;
    private String name;
    private boolean containGluten;

    private Ingredient(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContainGluten() {
        return containGluten;
    }

    public void setContainGluten(boolean containGluten) {
        this.containGluten = containGluten;
    }
}
