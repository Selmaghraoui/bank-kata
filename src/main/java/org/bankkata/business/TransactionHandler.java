package org.bankkata.business;

import org.bankkata.business.implementation.Transaction;
import java.util.List;

public interface TransactionHandler {
    void addTransaction(int amount, int balance);
    List<Transaction> getAllTransactions();
}