package service;

import client.ClientHttpConfiguration;
import domain.Conversion;
import domain.ExchangeRateApiResponse;
import tools.jackson.databind.ObjectMapper;
import utils.Calculator;
import utils.Logger;
import domain.Currency;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyService {
    private String apiKey;
    private ClientHttpConfiguration client;
    Logger logger;

    public CurrencyService(String apiKey, ClientHttpConfiguration client, Logger logger) {
        this.client = client;
        this.apiKey = apiKey;
        this.logger = logger;
    }

    public void convertValueByCurrency() throws IOException, InterruptedException {
           showAllCoins();
           System.out.println("Selecione o nome da moeda base:");
           Currency baseCurrency = Currency.fromName(new Scanner(System.in).nextLine());
           System.out.println("Selecione o nome da moeda cotada:");
           Currency quotedCurrency = Currency.fromName(new Scanner(System.in).nextLine());
           System.out.println("Informe o valor em "+ baseCurrency.name());
           double value = new Scanner(System.in).nextDouble();

           String uri = "https://v6.exchangerate-api.com/v6/"+ apiKey +"/pair/"+baseCurrency+"/"+quotedCurrency+"/"+ value;

           HttpResponse<String> response = client.sendGetRequest(uri);

           ExchangeRateApiResponse apiResponse = new ObjectMapper().readValue(response.body(), ExchangeRateApiResponse.class);
           Conversion conversion = new Conversion(apiResponse);

           double finalValue = Calculator.convertCurrency(value, conversion.getConversionRate());

           System.out.printf("""
            +-----------------------------------+
            | Dados da conversão
            +-----------------------------------+
            | Moeda base: %s
            | Moeda cotada: %s
            | Taxa de conversão: %.2f
            | Valor convertido: %s %.2f
            +-----------------------------------+
            """,baseCurrency.name(), quotedCurrency.name(), conversion.getConversionRate(), quotedCurrency.name(), finalValue);

           logger.info("Resposta: %s, valor_base: %.2f, valor_convertido: %.2f ".formatted(conversion, value, finalValue));
    }

    private void showAllCoins() {
        System.out.println("************************************************");
        System.out.println("Moedas Disponíveis para conversão:");
        for (Currency currency : Currency.values()){
            System.out.println("Nome da moeda: " + currency.getName() + ", Nome do país: "+ currency.getCountry());
        }
        System.out.println("************************************************");
    }
}
