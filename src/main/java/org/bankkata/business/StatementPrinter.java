package org.bankkata.business;

import org.bankkata.business.implementation.Transaction;
import java.util.List;

public interface StatementPrinter {
    void print(List<Transaction> transactions);
}