package com.cegeka.springcourse.axon.command;

import com.cegeka.springcourse.axon.command.command.CreateHighEmissionDriverCommand;
import com.cegeka.springcourse.axon.command.command.PayFineCommand;
import com.cegeka.springcourse.axon.command.event.FinePaidEvent;
import com.cegeka.springcourse.axon.command.event.HighEmissionDriverCreatedEvent;
import com.google.common.base.Preconditions;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static com.cegeka.springcourse.axon.command.HighEmissionDriverStatus.AWAITING_FINE_PAYMENT;
import static com.cegeka.springcourse.axon.command.HighEmissionDriverStatus.FINE_PAID;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class HighEmissionDriver {

    @AggregateIdentifier
    private String licensePlate;
    private int emissionScore;
    private HighEmissionDriverStatus status;

    protected HighEmissionDriver() {
    }

    @CommandHandler
    public HighEmissionDriver(CreateHighEmissionDriverCommand command) {
        apply(new HighEmissionDriverCreatedEvent(command.getLicensePlate(), command.getEmissionScore(), command.getCarBrand(), command.getCarType()));
    }

   @CommandHandler
    public void handle(PayFineCommand command) {
        apply(new FinePaidEvent(command.getLicenseplate()));
    }

    @EventSourcingHandler
    public void on(HighEmissionDriverCreatedEvent event) {
        Preconditions.checkArgument(event.getEmissionScore() <= 5 && event.getEmissionScore() > 0, "High emission driver should have score between 1 and 5");
        this.licensePlate = event.getLicensePlate();
        this.emissionScore = event.getEmissionScore();
        this.status = AWAITING_FINE_PAYMENT;
    }

   @EventSourcingHandler
    public void on(FinePaidEvent event) {
        this.status = FINE_PAID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getEmissionScore() {
        return emissionScore;
    }

    public HighEmissionDriverStatus getStatus() {
        return status;
    }
}
