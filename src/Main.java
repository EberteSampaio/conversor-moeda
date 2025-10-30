import utils.Currency;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner scanner = new Scanner(System.in);
    showAllCoins();
    System.out.println("Selecione o nome da moeda base:");
    Currency baseCurrency = Currency.fromName(scanner.nextLine());
    System.out.println("Selecione o nome da moeda cotada:");
    Currency quotedCurrency = Currency.fromName(scanner.nextLine());

    System.out.println("Moeda base: " + baseCurrency.name()+ ", Moeda cotada: " + quotedCurrency.name());
}

void showAllCoins() {
    System.out.println("************************************************");
    System.out.println("Moedas Disponíveis para conversão:");
    for (Currency currency : Currency.values()){
        System.out.println("Nome da moeda: " + currency.getName() + ", Nome do país: "+ currency.getCountry());
    }
    System.out.println("************************************************");
}
