package com.cegeka.springcourse.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionPoundService {
    @Autowired
    private TransactionService transactionService;


    public List<Transaction> getAllTransactionsByUserInPound(String id) {
//        List<Transaction> allTransactionsForUser =  transactionService.getAllTransactionsForUser(id);
//        for(Transaction transaction : allTransactionsForUser) {
//            transaction.setAmountInCent(transaction.getAmountInCent() * 20);
//        }
//        return allTransactionsForUser;

        return transactionService.getAllTransactionsForUser(id).stream()
                .map(transaction ->
                        new Transaction(
                                transaction.getFrom(),
                                transaction.getTo(),
                                transaction.getAmountInCent() * 20))
                .collect(Collectors.toList());
    }
}
