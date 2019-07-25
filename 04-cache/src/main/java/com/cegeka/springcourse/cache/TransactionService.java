package com.cegeka.springcourse.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private SlowTransactionAggregator slowTransactionAggregator;

    @Cacheable("transaction.user")
    public List<Transaction> getAllTransactionsForUser(String id) {
        return slowTransactionAggregator.getTransactionsForUser(id);
    }

    //you cant 'reuse' the cache from getAllTransactionsForUser. Calling a cached method from the same class, wont trigger the caching
    @Cacheable("transaction.user.from")
    public List<Transaction> getAllTransactionsStartedByUser(String id) {
        return getAllTransactionsForUser(id)
                .stream()
                .filter(transaction -> transaction.getFrom().equals(id))
                .collect(Collectors.toList());
    }
}
