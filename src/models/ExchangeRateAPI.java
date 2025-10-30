package models;

import utils.Currency;

public record ExchangeRateAPI(
        Currency base_code,
        Currency target_code,
        double conversion_rate
) {
}
