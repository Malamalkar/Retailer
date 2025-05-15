package com.customerRetailer.exception;

import com.customerRetailer.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPurchaseAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleInvalidPurchase(InvalidPurchaseAmountException ex) {
        return new Response(false, ex.getMessage(), 0);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleGenericException(Exception ex) {
        return new Response(false, "Something went wrong: " + ex.getMessage(), 0);
    }

}
