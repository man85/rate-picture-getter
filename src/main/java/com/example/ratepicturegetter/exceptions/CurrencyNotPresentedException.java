package com.example.ratepicturegetter.exceptions;

public class CurrencyNotPresentedException extends RuntimeException {
    public CurrencyNotPresentedException() {
        super("Currency not presented in request");
    }
}
