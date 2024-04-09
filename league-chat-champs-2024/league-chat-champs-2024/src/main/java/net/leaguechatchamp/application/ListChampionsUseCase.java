package net.leaguechatchamp.application;

import java.util.List;

import net.leaguechatchamp.leaguechatchamps2024.domain.model.Champions;
import net.leaguechatchamp.leaguechatchamps2024.domain.ports.ChampionsRepository;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champions> findAll() {
        return repository.findAll();
    }

}
