package com.cegeka.springcourse.events.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public void buyVouchers(String buyerName, int amount) {
        voucherRepository.loadVouchers(buyerName, amount);
    }
}
