package com.cegeka.springcourse.axon.command.event;

import java.util.Objects;

public class FinePaidEvent {
    private String licenseplate;

    public FinePaidEvent(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinePaidEvent that = (FinePaidEvent) o;
        return Objects.equals(licenseplate, that.licenseplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseplate);
    }
}
