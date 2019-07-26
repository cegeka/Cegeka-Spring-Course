package com.cegeka.springcourse.validation.registration;

import org.springframework.lang.NonNull;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

public class TeamRegistration implements Serializable {
    @NotNull
    private String country;
    @NotNull
    private String diver1Name;
    @NotNull
    private String diver2Name;
    @NotNull
    @Min(0)
    @Max(100)
    private int worldRanking;
    @NotNull
    @Size(max = 3)
    private List<String> entourageNames;
    @NotNull
    @Email
    private String contactEmail;

    public TeamRegistration(){}

    public String getCountry() {
        return country;
    }

    public String getDiver1Name() {
        return diver1Name;
    }

    public String getDiver2Name() {
        return diver2Name;
    }

    public int getWorldRanking() {
        return worldRanking;
    }

    public List<String> getEntourageNames() {
        return entourageNames;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
