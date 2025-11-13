package command.impl;

import client.ClientHttpConfiguration;
import command.Command;
import service.CurrencyService;
import utils.ApiKey;
import utils.Logger;

import java.io.IOException;

public class ConvertCurrenciesCommandImpl implements Command {
    @Override
    public void execute() {

        ApiKey apiKey = ApiKey.getInstance();
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        Logger logger = new Logger();

        var currencyServer = new CurrencyService(apiKey.getValue(), client, logger);

        try {
            currencyServer.convertValueByCurrency();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            logger.close();
        }
    }
}
