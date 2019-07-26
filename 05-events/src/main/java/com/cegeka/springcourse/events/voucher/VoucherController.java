package com.cegeka.springcourse.events.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/{buyername}/{amount}")
    public void buyVouchers(@PathVariable("buyername") String buyerName, @PathVariable("amount") int amount) {
        voucherService.buyVouchers(buyerName, amount);
    }

}
