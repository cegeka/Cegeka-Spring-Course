package com.cegeka.springcourse.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private SlowTransactionAggregator slowTransactionAggregator;

    public List<Transaction> getAllTransactionsForUser(String id) {
        return slowTransactionAggregator.getTransactionsForUser(id);
    }

    public List<Transaction> getAllTransactionsStartedByUser(String id) {
        return getAllTransactionsForUser(id)
                .stream()
                .filter(transaction -> transaction.getFrom().equals(id))
                .collect(Collectors.toList());
    }

    public List<Transaction> getAllTransactionsByUserInPound(String id) {
        return getAllTransactionsForUser(id)
                .stream()
                .map(transaction -> {
                    transaction.setAmountInCent(transaction.getAmountInCent() * 20);
                    return transaction;
                })
                .collect(Collectors.toList());
    }
}
