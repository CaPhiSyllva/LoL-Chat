# League Chat Championships 2024 (PROJETO AINDA NÃO FINALIZADO)

## Visão Geral

A aplicação League Chat Championships 2024 é um sistema desenvolvido para gerenciar e exibir informações sobre campeões de uma liga de esportes ou jogos. Esta documentação aborda os principais componentes, funcionalidades e adaptações de saída da aplicação.

## Componentes Principais

### Application.java

A classe `Application` é a classe principal da aplicação. Ela é responsável por iniciar a aplicação Spring Boot e configurar os beans necessários.

- **Método `main()`:** Este método é o ponto de entrada da aplicação. Ele inicializa a aplicação Spring Boot chamando o método `run()` de `SpringApplication`.

- **Método `provideListChampionsUseCase()`:** Este método configura e fornece um bean do tipo `ListChampionsUseCase`, que é utilizado para listar os campeões. Ele requer uma instância de `ChampionsRepository`.

### Champions.java e ChampionsTraditional.java

As classes `Champions` e `ChampionsTraditional` definem os campeões na aplicação. `Champions` é um registro (record) imutável, enquanto `ChampionsTraditional` é uma versão não-imutável. Ambas as classes contêm informações como ID, nome, papel (role), história (lore) e URL da imagem do campeão.

### ChampionsRepository.java

A interface `ChampionsRepository` define métodos para acessar dados sobre os campeões.

- **`findAll()`:** Retorna uma lista de todos os campeões.
- **`findById(Long id)`:** Retorna um campeão com o ID especificado, caso exista.

### ChampionsJdbcRepository.java

O adaptador de saída `ChampionsJdbcRepository` fornece uma implementação do porto `ChampionsRepository` usando JDBC para acessar dados de um banco de dados relacional.

- **Dependências:** Este adaptador depende do `JdbcTemplate` do Spring para executar consultas SQL no banco de dados.

- **Construtor:** Injeta uma instância de `JdbcTemplate` para permitir a execução de consultas SQL e inicializa um `RowMapper` para mapear os resultados das consultas para objetos `Champions`.

- **Método `findAll()`:** Executa uma consulta SQL para recuperar todos os campeões do banco de dados e mapeia os resultados para objetos `Champions`.

- **Método `findById(Long id)`:** Executa uma consulta SQL para recuperar um campeão específico com base em seu ID e mapeia o resultado para um objeto `Champions`. Retorna um `Optional` para lidar com o caso em que o campeão não é encontrado.

### ListChampionsUseCase.java

O caso de uso `ListChampionsUseCase` é responsável por listar todos os campeões disponíveis.

- **Dependências:** Este caso de uso depende do porto `ChampionsRepository`.

- **Record:** Definido como um record do Java, que é uma classe imutável com getters automáticos para seus campos.

- **Método `findAll()`:** Chama o método `findAll()` do porto `ChampionsRepository` para recuperar todos os campeões disponíveis.

## Funcionalidades Principais

- **Listagem de Campeões:** A aplicação oferece a funcionalidade de listar todos os campeões disponíveis, bem como recuperar informações detalhadas de um campeão específico por meio de seu ID.

## Configuração e Uso

Para executar a aplicação League Chat Championships 2024, é necessário configurar adequadamente as dependências do Spring Boot e fornecer uma implementação de `ChampionsRepository` para acessar os dados dos campeões. Após a configuração, inicie a aplicação Spring Boot `Application.java`. Uma vez iniciada, você pode acessar os endpoints correspondentes para listar todos os campeões ou recuperar informações sobre um campeão específico.

## Considerações

Os adaptadores de saída são responsáveis por fornecer uma implementação específica do porto `ChampionsRepository`, neste caso usando JDBC para acessar um banco de dados relacional. O caso de uso `ListChampionsUseCase` utiliza essa implementação para fornecer a funcionalidade de listar todos os campeões disponíveis. Este design permite uma separação clara entre as camadas de lógica de negócios e acesso a dados, facilitando a manutenção e extensão do sistema.


