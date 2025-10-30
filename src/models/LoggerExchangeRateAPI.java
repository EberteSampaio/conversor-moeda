package models;

import utils.Currency;

public record LoggerExchangeRateAPI(
        ExchangeRateAPI exchangeRateAPI,
        double value,
        double convertedValue
) {

    @Override
    public String toString() {
        return String.format("foi feito a conversão de %s %.2f para %s %.2f. Valor da taxa de conversão:  %.2f",
                exchangeRateAPI.base_code(),
                value,
                exchangeRateAPI.target_code(),
                convertedValue,
                exchangeRateAPI.conversion_rate()
        );
    }
}
