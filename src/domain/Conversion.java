package domain;

public class Conversion {
    private Currency baseCode;
    private Currency targetCode;
    private Double conversionRate;
    private Double conversionResult;

    public Conversion(){}

    public Conversion(ExchangeRateApiResponse response){
        this.baseCode = Currency.valueOf(response.baseCode());
        this.targetCode = Currency.valueOf(response.targetCode());
        this.conversionRate = response.conversionRate();
        this.conversionResult = response.conversionResult();
    }

    public Currency getBaseCode() {
        return baseCode;
    }

    public Currency getTargetCode() {
        return targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public Double getConversionResult() {
        return conversionResult;
    }

    @Override
    public String toString() {
        return "Conversão{" +
                "Moeda base=" + baseCode +
                ", Moeda cotada=" + targetCode +
                ", Taxa de conversão=" + conversionRate +
                ", Resultado da conversão=" + conversionResult +
                '}';
    }
}
