package com.cegeka.springcourse.axon.command.command;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class PayFineCommand {
    @TargetAggregateIdentifier
    private String licenseplate;

    public PayFineCommand(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayFineCommand that = (PayFineCommand) o;
        return Objects.equals(licenseplate, that.licenseplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseplate);
    }
}
