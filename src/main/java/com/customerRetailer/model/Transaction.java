package com.customerRetailer.model;

import java.time.LocalDate;

public class Transaction {

    private long customerId;
    private int amount;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(int amount, LocalDate date, long customerId) {
        this.amount = amount;
        this.date = date;
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
