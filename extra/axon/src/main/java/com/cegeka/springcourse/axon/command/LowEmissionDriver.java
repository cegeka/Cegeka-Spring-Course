package com.cegeka.springcourse.axon.command;

import com.cegeka.springcourse.axon.command.command.CreateLowEmissionDriverCommand;
import com.cegeka.springcourse.axon.command.event.LowEmissionDriverCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Objects;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class LowEmissionDriver {
    @AggregateIdentifier
    private String licensePlate;
    private String carBrand;
    private String carType;

    @CommandHandler
    public LowEmissionDriver(CreateLowEmissionDriverCommand command) {
        apply(new LowEmissionDriverCreatedEvent(command.getLicensePlate(), command.getCarBrand(), command.getCarType()));
    }

    @EventSourcingHandler
    public void on(LowEmissionDriverCreatedEvent event) {
        this.licensePlate = event.getLicensePlate();
        this.carBrand = event.getCarBrand();
        this.carType = event.getCarType();
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
        LowEmissionDriver that = (LowEmissionDriver) o;
        return Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(carBrand, that.carBrand) &&
                Objects.equals(carType, that.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, carBrand, carType);
    }
}
