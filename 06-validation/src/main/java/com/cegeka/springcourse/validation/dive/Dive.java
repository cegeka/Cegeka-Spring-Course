package com.cegeka.springcourse.validation.dive;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "DIVES")
public class Dive implements Serializable {

    @Id
    private String id;
    private String name;
    private int difficulty;

    public Dive(){}

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }
}
