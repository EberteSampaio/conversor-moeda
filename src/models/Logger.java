package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private PrintWriter writer;

    public Logger() {
        try {
            writer = new PrintWriter(new FileWriter("logs.txt", true));
        } catch (IOException e) {
            System.err.println("[Logger] Falha ao abrir arquivo de log: " + e.getMessage());
            writer = null;
        }
    }

    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception e) {
                System.err.println("[Logger] Erro ao fechar arquivo de log: " + e.getMessage());
            }
        }
    }

    public void error(Exception e) {
        write(String.format("[%s] ERROR: %s", LocalDateTime.now(), e.getMessage()));
    }

    public void info(Object o) {
        write(String.format("[%s] INFO: %s", LocalDateTime.now(), o.toString()));
    }

    private void write(String line) {
        if (writer == null) {
            System.err.println("[Logger] Log não inicializado: " + line);
            return;
        }

        try {
            writer.println(line);
        } catch (Exception e) {
            System.err.println("[Logger] Falha ao escrever log: " + e.getMessage());
        }
    }
}
