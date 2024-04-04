# League Chat Championships 2024 (UNCOMPLETED PROJECT)

## Overview

The League Chat Championships 2024 app is a system developed to manage and display information about champions of a sports league or game. This documentation addresses the main components, functionalities and output adaptations of the application.

## Main Components

### Application.java

The 'Application' class is the primary class of the application. She is responsible for starting the Spring Boot application and setting up the necessary beans.

- **Method `main()`:** This method is the application entry point. It starts the Spring Boot application by calling the `run()` method `SpringApplication`.

- **Method `provideListChampionsUseCase()`:** This method sets up and supplies a bean of the type `ListCampion' which is used to list the champions. It requires an instance of 'ChampionsRepository'.

### Champions.java and ChampionsTraditional.java

The classes `Champions` and `CampionsTraditional` define the champions in the application. `Champions` is an immutable record, while `CampionsTraditional` is a non-mutable version. Both classes contain information such as ID, name, role (role), history (lore) and URL of the champion's image.

### ChampionsRepository.java

The 'ChampionsRepository' interface defines methods for accessing data about the champions.

- **`findAll()`:** Returns a list of all champions.
- **`findById(Long id)`:** Returns a champion with the specified ID, if any.

### ChampionsJdbcRepository.java

The 'ChampionsJdbcRepository' output adapter provides an implementation of the `ChampionRepositori' port using JDBC to access data from a relational database.

- **Dependencies:** This adapter relies on Spring's `JdbcTemplate` to run SQL queries in the database.

- **Builder:** Injects an instance of `JdbcTemplate` to enable SQL queries to be executed and starts a `RowMapper` to mapp the query results to 'Champions' objects.

- **Method `findAll()`:** Run a SQL query to retrieve all the champions from the database and mapp the results to objects `Champions`.

- ** Method `findById(Long id)`:** Runns an SQL query to retrieve a specific champion based on its ID and mappes the result to an object `Champions`. Returns an `Optional` to deal with the case in which the champion is not found.

### ListChampionsUseCase.java

The use case `ListChampionsUseCase` is responsible for listing all available champions.

- **Dependents:** This use case depends on the port `ChampionsRepository`.

- **Record:** Defined as a Java record, which is an immutable class with automatic getters for its fields.

- **Method `findAll()`:** Calls the `findall()` method from the `ChampionsRepository` port to retrieve all available champions.

## Main Features

- **Champions Listing:** The app offers the functionality to list all available champions, as well as retrieve detailed information from a specific champion using their ID.

## Settings and Usage

To run the League Chat Championships 2024 application, you need to properly configure the Spring Boot dependencies and provide a 'ChampionsRepository' deployment to access the champions' data. After configuration, start the Spring Boot application `Application.java`. Once started, you can access the corresponding endpoints to list all the champions or retrieve information about a specific champion.

## Considerations

Output adapters are responsible for providing a specific `ChampionsRepository` port implementation, in this case using JDBC to access a relational database. The use case `ListChampionsUseCase` uses this implementation to provide the functionality of listing all available champions. This design allows a clear separation between the layers of business logic and data access, making it easy to maintain and extend the system.


