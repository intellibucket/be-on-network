package com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.schedulers.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.onnetwork.exchange.domain.presentation.dto.feign.response.CurrencyRates;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.input.schedulers.abstracts.AbstractCurrencyScheduler;
import com.intellibucket.onnetwork.exchange.domain.presentation.ports.output.currency.abstracts.FreeCurrencyAPIClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
@RequiredArgsConstructor
@Slf4j
public class FreeCurrencyAPIScheduler implements AbstractCurrencyScheduler {
    @Value("${external-api.free-currency.key}")
    private String apiKey;
    private final FreeCurrencyAPIClient freeCurrencyAPIClient;
    private final ObjectMapper objectMapper;

    @Override
    @Scheduled(fixedRate = 1000)
    public void schedule() {
        var currencyRates = CurrencyRates.of();
        this.freeCurrencyAPIClient.fetchAllLatestRates(this.apiKey)
                .get("data").fields().forEachRemaining(entry -> {
                    currencyRates.addCurrencyRate(entry.getKey(), entry.getValue().decimalValue());
                });
    }
}
