package com.cegeka.springcourse.axon;

import java.io.Serializable;

public class DriverReportDto implements Serializable {

    private String licensePlate;
    private int emissionScore;
    private String carBrand;
    private String carType;

    public DriverReportDto(){}

    public String getLicensePlate() {
        return licensePlate;
    }

    public DriverReportDto withLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public int getEmissionScore() {
        return emissionScore;
    }

    public DriverReportDto withEmissionScore(int emissionScore) {
        this.emissionScore = emissionScore;
        return this;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public DriverReportDto withCarBrand(String carBrand) {
        this.carBrand = carBrand;
        return this;
    }

    public String getCarType() {
        return carType;
    }

    public DriverReportDto withCarType(String carType) {
        this.carType = carType;
        return this;
    }
}
