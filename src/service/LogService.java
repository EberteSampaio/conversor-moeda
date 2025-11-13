package service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LogService {

    public void showAllLogs() throws IOException {
        File file = new File("logs.txt");
        FileReader reader = new FileReader(file);

        List<String> lines = reader.readAllLines();
        if (lines.isEmpty()) System.out.println("Não foi encontrado logs da aplicação");
        else lines.forEach(System.out::println);
    }
}
