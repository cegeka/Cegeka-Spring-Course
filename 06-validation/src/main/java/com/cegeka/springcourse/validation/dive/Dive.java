package com.cegeka.springcourse.validation.dive;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "DIVES")
public class Dive implements Serializable {

    @Id
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Min(value = 5, groups = OnCreate.class)
    @Min(value = 7, groups = OnUpdate.class)
    @Max(10)
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
