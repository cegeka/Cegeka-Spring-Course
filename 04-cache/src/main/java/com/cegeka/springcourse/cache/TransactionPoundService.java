package com.cegeka.springcourse.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionPoundService {
    @Autowired
    private TransactionService transactionService;


    public List<Transaction> getAllTransactionsByUserInPound(String id) {
        List<Transaction> allTransactionsForUser = transactionService.getAllTransactionsForUser(id);
        for (Transaction transaction : allTransactionsForUser) {
            transaction.setAmountInCent(transaction.getAmountInCent() * 20);
        }
        return allTransactionsForUser;
    }
}
