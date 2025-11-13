# 🪙 Conversor de Moeda

![Status](https://img.shields.io/badge/Status-Concluído-blue)

Um conversor de moedas interativo que opera via console, capaz de consultar uma API em tempo real para obter as taxas de câmbio mais recentes.

## Sobre o Projeto

Este projeto foi desenvolvido como um desafio de Back-End da formação **ONE (Oracle Next Education) | TECH FOUNDATION**, uma parceria entre a **Alura** e a **Oracle**.

O objetivo principal foi aplicar e solidificar os conhecimentos adquiridos no módulo de **Java e Orientação a Objetos**, focando especificamente em:

* Consumo de APIs externas.
* Manipulação de dados (parsing de JSON).
* Aplicação dos pilares da Programação Orientada a Objetos (POO).
* Tratamento de exceções e erros.

## Funcionalidades

* **Interface via Console:** Interação com o usuário totalmente baseada em texto no terminal.
* **Consulta de API Real:** Conecta-se à API [ExchangeRate-API](https://www.exchangerate-api.com/) (ou similar) para buscar taxas de câmbio atualizadas.
* **Menu Interativo:** Permite ao usuário escolher as moedas de origem e destino para a conversão.
* **Conversões Múltiplas:** O usuário pode realizar várias conversões antes de decidir sair do programa.
* **Moedas Principais:** Inclui suporte para as principais moedas globais (ex: USD, BRL, EUR, JPY, GBP).

## Tecnologias Utilizadas

* **Java 25:** Linguagem principal do projeto.
* **Java HTTP Client:** para realizar as requisições web à API.
* **Jackson:** Biblioteca para facilitar o parsing da resposta JSON da API.
* **IDE IntelliJ:** Ambiente de desenvolvimento utilizado.

##  Como Executar

1.  **Pré-requisitos:**
    * Ter o Java (JDK 17 ou superior) instalado e configurado no seu sistema.
    * Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/).
    * Baixar os seguintes jars utilizados no projeto:
      * [jackson databind 3.0.2](https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind)
      * [jackson core 3.0.2](https://mvnrepository.com/artifact/tools.jackson.core/jackson-core/3.0.2)
      * [jackson annotations 3.0](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/3.0-rc5)

2.  **Clone o repositório:**
    ```bash
    git clone https://github.com/EberteSampaio/conversor-moeda.git
    ```

3.  **Navegue até o diretório:**
    ```bash
    cd conversor-moeda
    ```

4.  **Execute a aplicação:**
    * Abra o projeto na sua IDE preferida (como IntelliJ ou Eclipse).
    * Importar os jars baixados
    * Localize o arquivo principal dentro do diretório `src`.
    * Execute o método `main`.

## Autor

* **Eberte Sampaio**
    * [GitHub](https://github.com/EberteSampaio)
    * [LinkedIn](https://www.linkedin.com/in/eberte-sampaio/)
