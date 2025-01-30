package org.bankkata.business.implementation;

import org.bankkata.business.TransactionHandler;
import java.util.ArrayList;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addTransaction(int amount, int balance) {
        transactions.add(new Transaction(amount, balance));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
