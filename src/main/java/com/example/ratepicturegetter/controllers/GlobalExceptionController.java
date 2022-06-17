package com.example.ratepicturegetter.controllers;

import com.example.ratepicturegetter.exceptions.CurrencyNotPresentedException;
import com.example.ratepicturegetter.exceptions.NotAvailableCurrencyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({CurrencyNotPresentedException.class, NotAvailableCurrencyException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleCurrencyNotPresented(HttpServletRequest req, Exception ex) {
        log.error("Request: " + req.getRequestURL() + " raised " + ex);
        return ex.getMessage();
    }

}
