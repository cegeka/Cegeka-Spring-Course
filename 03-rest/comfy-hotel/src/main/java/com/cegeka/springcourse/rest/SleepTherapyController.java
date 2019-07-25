package com.cegeka.springcourse.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("therapy")
public class SleepTherapyController {

    private List<HotelStay> hotelStays = new ArrayList<>();

    @PostMapping(value = "/checkin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelStay> checkIn(@RequestBody HotelGuest hotelGuest) {
        HotelStay hotelStay = new HotelStay(hotelGuest);
        hotelStays.add(hotelStay);
        return new ResponseEntity<>(hotelStay, HttpStatus.CREATED);
    }

    @GetMapping(value = "/stay/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelStay> getStay(@PathVariable("id") String id) {
        HotelStay hotelStay = hotelStays.stream().filter(stay -> stay.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stay not found for id " + id));
        return new ResponseEntity<>(hotelStay, HttpStatus.OK);
    }

    @PutMapping(value = "/sleepingdata", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logSleepingData(@PathVariable("id") String id) {
        return ResponseEntity.ok().build();
    }
}
