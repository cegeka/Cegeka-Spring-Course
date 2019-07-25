package com.cegeka.springcourse.rest;

import java.io.Serializable;

public class HotelGuest implements Serializable {

    private String fullName;
    private boolean isMinor;

    private HotelGuest(){}

    public String getFullName() {
        return fullName;
    }

    // Jackson determines field names based on getter. So Naming it 'isMinor' would result in the field being named 'Minor' in the JSON.
    public boolean getIsMinor() {
        return isMinor;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIsMinor(boolean minor) {
        isMinor = minor;
    }
}
