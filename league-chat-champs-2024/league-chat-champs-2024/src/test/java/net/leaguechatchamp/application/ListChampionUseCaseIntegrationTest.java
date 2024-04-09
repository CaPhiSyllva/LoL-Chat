package net.leaguechatchamp.application;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.leaguechatchamp.leaguechatchamps2024.Application;
import net.leaguechatchamp.leaguechatchamps2024.domain.model.Champions;

@SpringBootTest(classes = Application.class) 
public class ListChampionUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions() {
        List<Champions> champions = listChampionsUseCase.findAll();

        Assertions.assertEquals(12, champions.size());
    }
}
