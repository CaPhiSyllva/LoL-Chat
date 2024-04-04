package net.leaguechatchamp.leaguechatchamps2024.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.leaguechatchamp.application.ListChampionsUseCase;
import net.leaguechatchamp.leaguechatchamps2024.domain.model.Champions;

@Tag(name = "Champions", description = "Endpoints")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {
    @GetMapping()
    public List<Champions> findALLChampions() {
        return useCase.findAll();
    }
}
