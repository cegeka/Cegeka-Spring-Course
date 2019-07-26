package com.cegeka.springcourse.validation.registration;

import java.io.Serializable;
import java.util.List;

public class TeamRegistration implements Serializable {
    private String country;
    private String diver1Name;
    private String diver2Name;
    private int worldRanking;
    private List<String> entourageNames;
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
