package com.cegeka.springcourse.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("therapy")
public class SleepTherapyController {

    private List<HotelStay> hotelStays = new ArrayList<>();
    private RestTemplate restTemplate;


    public SleepTherapyController() {
        restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:1234/sleeping-pattern")
                .build();
    }

    @PostMapping(value = "/checkin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelStay> checkIn(@RequestBody HotelGuest hotelGuest) {
        HotelStay hotelStay = new HotelStay(hotelGuest);
        hotelStays.add(hotelStay);
        return new ResponseEntity<>(hotelStay, HttpStatus.CREATED);
    }

    @GetMapping(value = "/stay/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelStay> getStay(@PathVariable("id") String id) {
        HotelStay hotelStay = findHotelStayById(id);
        return new ResponseEntity<>(hotelStay, HttpStatus.OK);
    }

    @PutMapping(value = "/sleepingdata/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logSleepingData(@PathVariable("id") String id, @RequestBody SleepingPatternDataInput input) {
        HotelStay hotelStay = findHotelStayById(id);
        SleepingPatternData data = restTemplate.postForEntity("/", input, SleepingPatternData.class).getBody();
        hotelStay.setSleepingPatternDataId(data.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/sleepingpattern/{id}")
    public ResponseEntity getSleepingData(@PathVariable("id") String id, @PathParam("concise") String concise) {
        HotelStay hotelStay = findHotelStayById(id);
        SleepingPatternData data = restTemplate.getForEntity("/" + hotelStay.getSleepingPatternDataId(), SleepingPatternData.class).getBody();
        if (concise != null && concise.equals("true")) {
            return ResponseEntity.ok().body("ID:" + data.getId() + ", SCORE:" + data.getScore());
        }
        return ResponseEntity.ok().body(data);
    }

    @DeleteMapping(value = "/stay/{id}")
    public ResponseEntity removeStay(@PathVariable("id") String id, @RequestHeader(value = "X-DELETE") String xDelete) {
        HotelStay hotelStay = findHotelStayById(id);
        if (hotelStay.getHotelGuest().getFullName().equals(xDelete)) {
            hotelStays.remove(hotelStay);
            return ResponseEntity.ok().build();
        } else {
            throw new StayRemovalException("Error removing stay");
        }
    }

    private HotelStay findHotelStayById(String id) {
        return hotelStays.stream().filter(stay -> stay.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stay not found for id " + id));
    }
}
