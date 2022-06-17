package com.example.ratepicturegetter.exceptions;

public class NotAvailableCurrencyException extends RuntimeException {
    public NotAvailableCurrencyException(final String currency) {
        super("Currency " + currency + " not available for service");
    }
}
