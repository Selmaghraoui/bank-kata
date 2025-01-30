package org.bankkata.business.implementation;

import org.bankkata.business.StatementPrinter;
import java.util.List;

public class StatementPrinterImpl implements StatementPrinter {
    @Override
    public void print(List<Transaction> transactions) {
        System.out.println("Date       || Amount || Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            System.out.println(transaction.getDate() + " || " + transaction.getAmount() + "   || " + transaction.getBalance());
        }
    }
}
