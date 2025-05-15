package com.customerRetailer.exception;

public class InvalidPurchaseAmountException  extends RuntimeException  {

    public InvalidPurchaseAmountException(String message) {
        super(message);
    }
}
