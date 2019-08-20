package com.cegeka.springcourse.axon.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateLowEmissionDriverCommand {
    @TargetAggregateIdentifier
    private final String licensePlate;
    private final String carBrand;
    private final String carType;

    public CreateLowEmissionDriverCommand(String licensePlate, String carBrand, String carType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateLowEmissionDriverCommand that = (CreateLowEmissionDriverCommand) o;
        return Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(carBrand, that.carBrand) &&
                Objects.equals(carType, that.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, carBrand, carType);
    }
}
