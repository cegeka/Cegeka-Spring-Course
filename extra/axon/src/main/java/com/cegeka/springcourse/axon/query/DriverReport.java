package com.cegeka.springcourse.axon.query;

import com.google.common.base.Preconditions;

import java.time.LocalDate;
import java.util.Objects;

import static com.cegeka.springcourse.axon.query.DriverReportStatus.FINE_PAID;

public class DriverReport {
    private String licensePlate;
    private String carBrand;
    private String carType;
    private DriverReportStatus driverReportStatus;
    private LocalDate enterDate;

    public DriverReport(String licensePlate, String carBrand, String carType, DriverReportStatus driverReportStatus) {
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.carType = carType;
        this.driverReportStatus = driverReportStatus;
        this.enterDate = LocalDate.now();
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

    public DriverReportStatus getDriverReportStatus() {
        return driverReportStatus;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverReport that = (DriverReport) o;
        return Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(carBrand, that.carBrand) &&
                Objects.equals(carType, that.carType) &&
                driverReportStatus == that.driverReportStatus &&
                Objects.equals(enterDate, that.enterDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, carBrand, carType, driverReportStatus, enterDate);
    }

    public void handleFinePaid() {
        Preconditions.checkArgument(driverReportStatus != DriverReportStatus.ALLOWED, "Allowed drivers cant get fines or pay them");
        this.driverReportStatus = FINE_PAID;
    }
}
