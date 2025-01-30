package org.bankkata.business.implementation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private int amount;
    private int balance;
    private String date;

    public Transaction(int amount, int balance) {
        this.amount = amount;
        this.balance = balance;
        this.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }
}