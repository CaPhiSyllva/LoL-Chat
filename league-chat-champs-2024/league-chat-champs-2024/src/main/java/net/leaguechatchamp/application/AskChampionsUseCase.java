package net.leaguechatchamp.application;

import net.leaguechatchamp.leaguechatchamps2024.domain.exception.ChampionNotFoundException;
import net.leaguechatchamp.leaguechatchamps2024.domain.model.Champions;
import net.leaguechatchamp.leaguechatchamps2024.domain.ports.ChampionsRepository;

public record AskChampionsUseCase(ChampionsRepository repository) {
    public String askChampion(Long championId, String question){

        Champions champion = repository.findById(championId)
            .orElseThrow(()-> new ChampionNotFoundException(championId));

            String championContext = champion.generateContextByQuestion(question);

        return championContext;
        
    }
    
}


