package com.cegeka.springcourse.axon;

import com.cegeka.springcourse.axon.command.command.CreateHighEmissionDriverCommand;
import com.cegeka.springcourse.axon.command.command.CreateLowEmissionDriverCommand;
import com.cegeka.springcourse.axon.command.command.PayFineCommand;
import com.cegeka.springcourse.axon.query.DriverReport;
import com.cegeka.springcourse.axon.query.queryhandler.FindAllDriversQuery;
import com.cegeka.springcourse.axon.query.queryhandler.FindAllDriversWhoEnteredAfterQuery;
import com.cegeka.springcourse.axon.query.queryhandler.FindAllDriversWithFinesQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

@RestController
public class DriverReportController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @PostMapping(value = "/report", consumes = APPLICATION_JSON)
    public void reportDriver(@RequestBody DriverReportDto driverReportDto) {
        if(driverReportDto.getEmissionScore() < 6) {
            commandGateway.send(new CreateHighEmissionDriverCommand(driverReportDto.getLicensePlate(), driverReportDto.getEmissionScore(), driverReportDto.getCarBrand(), driverReportDto.getCarType()));
        } else {
            commandGateway.send(new CreateLowEmissionDriverCommand(driverReportDto.getLicensePlate(), driverReportDto.getCarBrand(), driverReportDto.getCarType()));
        }
    }

    @PutMapping("/finepaid/{licenseplate}")
    public void payFine(@PathVariable("licenseplate") String licenseplate) {
        commandGateway.send(new PayFineCommand(licenseplate));
    }

    @GetMapping("")
    public List<DriverReport> getAll() {
        return queryGateway.query(new FindAllDriversQuery(), ResponseTypes.multipleInstancesOf(DriverReport.class)).join();
    }

    @GetMapping("/fine")
    public List<DriverReport> getAllWithFines() {
        return queryGateway.query(new FindAllDriversWithFinesQuery(), ResponseTypes.multipleInstancesOf(DriverReport.class)).join();
    }

    @GetMapping("/enteredafter")
    public List<DriverReport> getAllEnteredAfter() {
        return queryGateway.query(new FindAllDriversWhoEnteredAfterQuery(LocalDate.now().minusWeeks(1)), ResponseTypes.multipleInstancesOf(DriverReport.class)).join();
    }
}
