package domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeRateApiResponse(
        @JsonProperty("result") String result,
        @JsonProperty("base_code") String baseCode,
        @JsonProperty("target_code") String targetCode,
        @JsonProperty("conversion_rate") Double conversionRate,
        @JsonProperty("conversion_result") Double conversionResult
)
{
}
