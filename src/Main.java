import command.CommandExecutor;
import command.impl.ConvertCurrenciesCommandImpl;
import command.impl.ShowLogHistoryCommandImpl;
import utils.Logger;

void main() {
    CommandExecutor commandExecutor = new CommandExecutor();
    Logger logger = new Logger();
    try{
        while (true) {
            switch(selectBaseMenuOption()){
              case 1 -> commandExecutor.executeCommand(new ConvertCurrenciesCommandImpl());
              case 2 -> commandExecutor.executeCommand(new ShowLogHistoryCommandImpl());
              case 3 -> System.exit(1);
              default -> System.out.println("Opção inválida");
            }
        }
   } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        logger.error(e);
   }finally {
        logger.close();
    }
}

int selectBaseMenuOption(){
    System.out.println("\nSeja bem-vindo! Escolha as seguintes opções");
    System.out.println("1 - Conversão de moedas.");
    System.out.println("2 - Verificar Logs.");
    System.out.println("3 - Sair.");
    return new Scanner(System.in).nextInt();
}