package org.bankkata.test;

import org.bankkata.business.StatementPrinter;
import org.bankkata.business.TransactionHandler;
import org.bankkata.business.implementation.Account;
import org.bankkata.business.implementation.StatementPrinterImpl;
import org.bankkata.business.implementation.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    public void testDeposit() {
        TransactionHandler repository = mock(TransactionHandler.class);
        StatementPrinter printer = mock(StatementPrinter.class);
        Account account = new Account(repository, printer);

        account.deposit(1000);
        verify(repository).addTransaction(1000, 1000);
    }

    @Test
    public void testWithdraw() {
        TransactionHandler repository = mock(TransactionHandler.class);
        StatementPrinter printer = mock(StatementPrinter.class);
        Account account = new Account(repository, printer);

        account.deposit(2000);
        account.withdraw(500);

        verify(repository).addTransaction(-500, 1500);
    }

    @Test
    public void testPrintStatement() {
        TransactionHandler transactionHandler = mock(TransactionHandler.class);
        StatementPrinter printer = new StatementPrinterImpl();
        Account account = new Account(transactionHandler, printer);

        Transaction transaction1 = new Transaction(1000, 1000);
        Transaction transaction2 = new Transaction(2000, 3000);
        Transaction transaction3 = new Transaction(-500, 2500);

        when(transactionHandler.getAllTransactions()).thenReturn(List.of(transaction1, transaction2, transaction3));

        account.printStatement();
        verify(transactionHandler).getAllTransactions();
    }
}
