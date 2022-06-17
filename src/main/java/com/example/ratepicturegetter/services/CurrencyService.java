package com.example.ratepicturegetter.services;

import com.example.ratepicturegetter.client.RateClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CurrencyService {

    private static List<String> AVAILABLE_CURRENCIES = new ArrayList<>();
    private static String APP_ID;

    private final RateClient rateClient;

    @Value("${currencies}")
    public void initializeCurrencyRatesAsJsonUrl(List<String> currencies) {
        CurrencyService.AVAILABLE_CURRENCIES = currencies;
    }

    @Value("${app.id}")
    public void initializeAppId(final String appId) {
        CurrencyService.APP_ID = appId;
    }

    public boolean isCorrectCurrency(final String currency) {
        return AVAILABLE_CURRENCIES.contains(currency);
    }

    public String getPicture(final String currency) {
        return rateClient.getRate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE), APP_ID);
    }
}
