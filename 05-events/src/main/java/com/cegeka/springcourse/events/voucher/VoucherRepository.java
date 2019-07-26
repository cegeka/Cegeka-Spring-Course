package com.cegeka.springcourse.events.voucher;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VoucherRepository {

    private Map<String, Integer> vouchersForUser = new HashMap<>();

    public void loadVouchers(String buyername, int amount) {
        Integer amountAlreadyInAccount = vouchersForUser.get(buyername);
        if(amountAlreadyInAccount != null) {
            vouchersForUser.put(buyername, amount + amountAlreadyInAccount);
        } else {
            vouchersForUser.put(buyername, amount);
        }
    }

    public Integer getVoucherBalance(String name) {
        return vouchersForUser.get(name);
    }
}
