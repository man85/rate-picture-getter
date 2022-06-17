package com.example.ratepicturegetter.controllers;

import com.example.ratepicturegetter.exceptions.CurrencyNotPresentedException;
import com.example.ratepicturegetter.exceptions.NotAvailableCurrencyException;
import com.example.ratepicturegetter.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class RatePictureController {

    private final CurrencyService currencyService;

    @GetMapping("/picture")
    public String getPicture(@RequestParam("currency") Optional<String> currency) {
        if (!currencyService.isCorrectCurrency(currency.orElseThrow(CurrencyNotPresentedException::new).toUpperCase())) {
            throw new NotAvailableCurrencyException(currency.get());
        }
        return currencyService.getPicture(currency.get());
    }
}
