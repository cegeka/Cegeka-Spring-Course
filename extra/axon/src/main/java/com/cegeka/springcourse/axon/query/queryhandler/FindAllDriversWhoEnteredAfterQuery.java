package com.cegeka.springcourse.axon.query.queryhandler;

import java.time.LocalDate;

public class FindAllDriversWhoEnteredAfterQuery {
    private LocalDate localDate;

    public FindAllDriversWhoEnteredAfterQuery(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
