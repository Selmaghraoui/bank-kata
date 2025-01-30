package org.bankkata.business.implementation;

import org.bankkata.business.AccountService;
import org.bankkata.business.StatementPrinter;
import org.bankkata.business.TransactionHandler;
import java.util.List;

public class Account implements AccountService {
    private final TransactionHandler transactionHandler;
    private final StatementPrinter statementPrinter;
    private int balance;

    public Account(TransactionHandler transactionHandler, StatementPrinter statementPrinter) {
        this.transactionHandler = transactionHandler;
        this.statementPrinter = statementPrinter;
        this.balance = 0;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionHandler.addTransaction(amount, balance);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        transactionHandler.addTransaction(-amount, balance);
    }

    @Override
    public void printStatement() {
        List<Transaction> transactions = transactionHandler.getAllTransactions();
        statementPrinter.print(transactions);
    }
}