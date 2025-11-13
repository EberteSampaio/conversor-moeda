package command.impl;

import command.Command;
import service.LogService;

import java.io.IOException;

public class ShowLogHistoryCommandImpl implements Command {
    @Override
    public void execute() {
        LogService logService = new LogService();

        try {
            logService.showAllLogs();
        } catch (IOException e) {
            System.out.println("Não foi encontrado nenhum log");
        }
    }
}
