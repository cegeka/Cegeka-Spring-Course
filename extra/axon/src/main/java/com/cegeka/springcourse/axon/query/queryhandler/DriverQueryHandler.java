package com.cegeka.springcourse.axon.query.queryhandler;

import com.cegeka.springcourse.axon.query.DriverReport;
import com.cegeka.springcourse.axon.query.DriverReportRepository;
import com.cegeka.springcourse.axon.query.DriverReportStatus;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class DriverQueryHandler {

    @Autowired
    private DriverReportRepository reportRepository;

    @QueryHandler
    public List<DriverReport> handle(FindAllDriversQuery query) {
        return newArrayList(reportRepository.getDriverReportForId().values());
    }

    @QueryHandler
    public List<DriverReport> handle(FindAllDriversWithFinesQuery query) {
        return reportRepository.getDriverReportForId().values().stream()
                .filter(driver -> driver.getDriverReportStatus().equals(DriverReportStatus.FINE_NOT_PAID))
                .collect(Collectors.toList());
    }

    @QueryHandler
    public List<DriverReport> handle(FindAllDriversWhoEnteredAfterQuery query) {
        return reportRepository.getDriverReportForId().values().stream()
                .filter(driver -> driver.getEnterDate().isAfter(query.getLocalDate()))
                .collect(Collectors.toList());
    }

}
