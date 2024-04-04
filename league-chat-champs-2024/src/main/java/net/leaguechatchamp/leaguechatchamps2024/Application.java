package net.leaguechatchamp.leaguechatchamps2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.leaguechatchamp.application.ListChampionsUseCase;
import net.leaguechatchamp.leaguechatchamps2024.domain.ports.ChampionsRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository championsRepository){
		return new  ListChampionsUseCase(championsRepository);
	}
}

