package com.cegeka.springcourse.events.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherAndBankBalanceController {

    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private VoucherRepository voucherRepository;


    @GetMapping("/balance/{username}")
    public String getBalance(@PathVariable("username") String username) {
        Integer bankBalance = bankAccountService.getBankBalanceFor(username);
        Integer voucherBalance = voucherRepository.getVoucherBalance(username);
        return username + " has " + voucherBalance + " vouchers and " + bankBalance + " euros in the bank";
    }
}
