package org.bankkata.business.implementation;

import org.bankkata.business.StatementPrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinterImpl implements StatementPrinter {
    @Override
    public void print(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("No transactions to display.");
            return;
        }

        System.out.println("Date       || Amount || Balance");

        List<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);

        reversedTransactions.forEach(transaction -> System.out.printf(
                "%s || %s   || %s%n",
                transaction.getDate(),
                transaction.getAmount(),
                transaction.getBalance()
        ));
    }
}
