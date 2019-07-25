package com.cegeka.springcourse.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionOverviewController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionPoundService transactionPoundService;

    @GetMapping(value = "/transaction/{id}")
    public List<Transaction> getTransactionsForUser(@PathVariable("id") String id) {
        return transactionService.getAllTransactionsForUser(id);
    }

    @GetMapping(value = "/transaction/from/{id}")
    public List<Transaction> getAllTransactionsStartedByUser(@PathVariable("id") String id) {
        return transactionService.getAllTransactionsStartedByUser(id);
    }

    @GetMapping(value = "/transaction/{id}/pound")
    public List<Transaction> getAllTransactionsByUserInPound(@PathVariable("id") String id) {
        return transactionPoundService.getAllTransactionsByUserInPound(id);
    }
}
