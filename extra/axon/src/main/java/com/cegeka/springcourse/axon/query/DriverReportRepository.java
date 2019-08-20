package com.cegeka.springcourse.axon.query;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DriverReportRepository {

    private Map<String, DriverReport> driverReportForId = new HashMap<>();

    public Map<String, DriverReport> getDriverReportForId() {
        return driverReportForId;
    }
}
