package net.leaguechatchamp.leaguechatchamps2024.adapters.in;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.leaguechatchamp.application.ListChampionsUseCase;

@Tag(name = "Champions", description = "Endpoints")
@RestController
@RequestMapping("/champions")
public record AskChampionsRestController(ListChampionsUseCase useCase) {
    @PostMapping("/{championId}/ask")
    public askChampionResponse askChampion(
        @PathVariable Long championId, 
        @RequestBody askChampionRequest request) {
        String answer = useCase.askChampion(championId, request.question());

        return new askChampionResponse(answer);
    }

    public record askChampionRequest(String question){}
    public record askChampionResponse(String answer){}
}