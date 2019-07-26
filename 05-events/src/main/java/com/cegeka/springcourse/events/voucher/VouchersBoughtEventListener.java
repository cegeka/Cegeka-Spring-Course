package com.cegeka.springcourse.events.voucher;

import com.cegeka.springcourse.events.goodiebag.GoodieBagPulledEvent;
import com.cegeka.springcourse.events.goodiebag.GoodieBagStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class VouchersBoughtEventListener implements ApplicationListener<VouchersBoughtEvent> {

    @Autowired
    private BankAccountService bankAccountService;


    @Override
    public void onApplicationEvent(VouchersBoughtEvent event) {
        try {
            bankAccountService.transferFunds(event.getBuyerName(), "SPRING_FESTIVAL", event.getAmount());
        } catch (InsufficientFundsException e) {
            System.out.println("INSUFFICIENT FUNDS TO DEPLETE!");
        }
    }
}
