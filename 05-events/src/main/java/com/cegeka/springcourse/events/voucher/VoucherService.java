package com.cegeka.springcourse.events.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void buyVouchers(String buyerName, int amount) {
        applicationEventPublisher.publishEvent(new VouchersBoughtEvent(this, buyerName, amount));
        System.out.println("ASYNC: Continuing after firing event; expecting this one first");
        voucherRepository.loadVouchers(buyerName, amount);
    }
}
