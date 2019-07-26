package com.cegeka.springcourse.events.voucher;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BankAccountService {

    private Map<String, Integer> bankAccountWithBalances = new HashMap<>();

    public BankAccountService() {
        bankAccountWithBalances.put("John", 10);
        bankAccountWithBalances.put("Paul", 100);
        bankAccountWithBalances.put("George", 9999);
        bankAccountWithBalances.put("Yoko", 0);
        bankAccountWithBalances.put("SPRING_FESTIVAL", 0);
    }

    public void transferFunds(String from, String to, Integer amount) throws InsufficientFundsException {
        workHardForABit();
        Integer fundsToTakeFrom = bankAccountWithBalances.get(from);
        Integer fundsToAddTo = bankAccountWithBalances.get(to);
        if(fundsToTakeFrom < amount) {
            throw new InsufficientFundsException();
        }
        bankAccountWithBalances.put(to, fundsToAddTo + amount);
        bankAccountWithBalances.put(from, fundsToTakeFrom - amount);
    }

    public Integer getBankBalanceFor(String user) {
        return bankAccountWithBalances.get(user);
    }

    private void workHardForABit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
