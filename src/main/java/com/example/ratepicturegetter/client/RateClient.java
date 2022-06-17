package com.example.ratepicturegetter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "RateService", url = "https://openexchangerates.org/api")
public interface RateClient {

    @GetMapping("/historical/{date}.json")
    String getRate(@PathVariable("date") String date, @RequestParam("app_id") String appId);

}
