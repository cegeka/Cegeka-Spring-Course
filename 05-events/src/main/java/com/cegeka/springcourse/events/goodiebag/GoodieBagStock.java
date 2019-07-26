package com.cegeka.springcourse.events.goodiebag;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GoodieBagStock {
    private Map<String, Integer> stockRemainingPerItem = new HashMap<>();

    public GoodieBagStock() {
        stockRemainingPerItem.put("bag", 100);
        stockRemainingPerItem.put("sunglasses", 100);
        stockRemainingPerItem.put("voucher", 9999);
        stockRemainingPerItem.put("cap", 5);
        stockRemainingPerItem.put("champagne", 20);
        stockRemainingPerItem.put("tent", 2);
    }

    public String getGood(String name) {
        if (stockRemainingPerItem.containsKey(name) && stockRemainingPerItem.get(name) > 0) {
            return name;
        }
        throw new IllegalArgumentException("We are out of " + name + "s");
    }

    public void depleteStock(GoodieBagType goodieBagType) {
        decrementStock("bag");
        decrementStock("sunglasses");
        decrementStock("voucher");
        decrementStock("cap");
        if (GoodieBagType.VIP.equals(goodieBagType)) {
            decrementStock("voucher");
            decrementStock("voucher");
            decrementStock("voucher");
            decrementStock("voucher");
            decrementStock("champagne");
            decrementStock("tent");
        }
    }

    private void decrementStock(String item) {
        stockRemainingPerItem.replace(item, stockRemainingPerItem.get(item) - 1);
    }
}
