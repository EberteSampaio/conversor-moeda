package utils;

public class ApiKey {
    private static ApiKey instance;
    private final String value;

    private ApiKey() {
        this.value = "sua-api-key";
    }

    public static ApiKey getInstance() {
        if (instance == null) {
            instance = new ApiKey();
        }
        return instance;
    }

    public String getValue() {
        if (value.isBlank()) {
            throw new IllegalStateException("A chave da API não foi configurada!");
        }
        return value;
    }
}
