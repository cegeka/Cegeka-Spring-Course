package com.cegeka.springcourse.cache;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
//DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS DO NOT TOUCH THIS CLASS
@Component
public class SlowTransactionAggregator {

    public List<Transaction> getTransactionsForUser(String id) {
        System.out.println("Cache was not hit!");
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(id, "ABC", 15));
        transactions.add(new Transaction(id, "DEF", 25));
        transactions.add(new Transaction("DEF", id, 35));
        transactions.add(new Transaction("XYZ", id, 115));
        transactions.add(new Transaction(id, "ABC", 1015));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return transactions;
    }

}
