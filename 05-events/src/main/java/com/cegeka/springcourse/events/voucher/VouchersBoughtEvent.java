package com.cegeka.springcourse.events.voucher;

import org.springframework.context.ApplicationEvent;

public class VouchersBoughtEvent extends ApplicationEvent {
    private final String buyerName;
    private final int amount;

    public VouchersBoughtEvent(Object source, String buyerName, int amount) {
        super(source);
        this.buyerName = buyerName;
        this.amount = amount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public int getAmount() {
        return amount;
    }
}
