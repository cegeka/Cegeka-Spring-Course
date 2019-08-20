package com.cegeka.springcourse.axon.query.eventhandler;

import com.cegeka.springcourse.axon.command.event.FinePaidEvent;
import com.cegeka.springcourse.axon.command.event.HighEmissionDriverCreatedEvent;
import com.cegeka.springcourse.axon.command.event.LowEmissionDriverCreatedEvent;
import com.cegeka.springcourse.axon.query.DriverReport;
import com.cegeka.springcourse.axon.query.DriverReportRepository;
import com.cegeka.springcourse.axon.query.DriverReportStatus;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverEventHandler {

    @Autowired
    private DriverReportRepository reportRepository;

    @EventHandler
    public void on(HighEmissionDriverCreatedEvent event) {
        reportRepository.getDriverReportForId().put(event.getLicensePlate(), new DriverReport(event.getLicensePlate(), event.getCarBrand(), event.getCarType(), DriverReportStatus.FINE_NOT_PAID));
    }

    @EventHandler
    public void on(LowEmissionDriverCreatedEvent event) {
        reportRepository.getDriverReportForId().put(event.getLicensePlate(), new DriverReport(event.getLicensePlate(), event.getCarBrand(), event.getCarType(), DriverReportStatus.ALLOWED));
    }

    @EventHandler
    public void on(FinePaidEvent event) {
        reportRepository.getDriverReportForId().get(event.getLicenseplate()).handleFinePaid();
    }

}
