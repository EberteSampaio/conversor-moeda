import com.google.gson.Gson;
import models.Calculator;
import models.ExchangeRateAPI;
import models.Logger;
import models.LoggerExchangeRateAPI;
import utils.Currency;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() {
    String apiKey = "sua chave aqui";
    Logger logger = new Logger();
    try{
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        showBaseMenu();
        int option = scanner.nextInt();
        scanner.nextLine();
        while (!exit) {
            switch(option){
                case 1:
                    showAllCoins();
                    System.out.println("Selecione o nome da moeda base:");
                    Currency baseCurrency = Currency.fromName(scanner.nextLine());

                    System.out.println("Selecione o nome da moeda cotada:");
                    Currency quotedCurrency = Currency.fromName(scanner.nextLine());

                    System.out.println("Informe o valor em "+ baseCurrency.name());
                    double value = scanner.nextDouble();
                    scanner.nextLine();

                    String uri = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+baseCurrency+"/"+quotedCurrency+"/"+ value;
                    var result = sendAndParse(sendRequest(uri));

                    double finalValue = Calculator.convertCurrency(value, result.conversion_rate());
                    System.out.printf("""
                            +-----------------------------------+
                            | Dados da conversão
                            +-----------------------------------+
                            | Moeda base: %s
                            | Moeda cotada: %s
                            | Taxa de conversão: %.2f
                            | Valor convertido: %s %.2f
                            +-----------------------------------+
                            """,baseCurrency.name(), quotedCurrency.name(), result.conversion_rate(), quotedCurrency.name(), finalValue);

                    logger.info(new LoggerExchangeRateAPI(result, value, finalValue));

                    System.out.println("Deseja continuar? (S/N)");
                    String continueOption = scanner.nextLine();

                    if(! "S".equalsIgnoreCase(continueOption)) exit = true;


                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
   } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        logger.error(e);
   }finally {
        logger.close();
    }
}

String sendRequest(String url) throws IOException, InterruptedException {
    HttpClient  client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
}
void showBaseMenu(){
    System.out.println("Seja bem-vindo! Escolha as seguintes opções");
    System.out.println("1 - Conversão de moedas.");
    System.out.println("2 - Sair.");
}
void showAllCoins() {
    System.out.println("************************************************");
    System.out.println("Moedas Disponíveis para conversão:");
    for (Currency currency : Currency.values()){
        System.out.println("Nome da moeda: " + currency.getName() + ", Nome do país: "+ currency.getCountry());
    }
    System.out.println("************************************************");
}

ExchangeRateAPI sendAndParse(String json){

    Gson gson = new Gson();

    return gson.fromJson(json, ExchangeRateAPI.class);
}
