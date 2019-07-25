package com.cegeka.springcourse.rest;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class HotelStay implements Serializable {

    private String id;
    private HotelGuest hotelGuest;
    private LocalDate startDate;
    private LocalDate endDate;

    public HotelStay(HotelGuest hotelGuest) {
        id = UUID.randomUUID().toString();
        this.hotelGuest = hotelGuest;
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now().plusDays(7);
    }

    public String getId() {
        return id;
    }

    public HotelGuest getHotelGuest() {
        return hotelGuest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
