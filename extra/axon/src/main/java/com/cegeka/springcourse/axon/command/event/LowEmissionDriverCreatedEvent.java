package com.cegeka.springcourse.axon.command.event;

public class LowEmissionDriverCreatedEvent {
    private final String licensePlate;
    private final String carBrand;
    private final String carType;

    public LowEmissionDriverCreatedEvent(String licensePlate, String carBrand, String carType) {
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.carType = carType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarType() {
        return carType;
    }
}
