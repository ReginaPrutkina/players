package com.intuit.players.controller;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.useCase.GetPlayerListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetPlayerList {
    private final GetPlayerListUseCase getPlayerListUseCase;

    @GetMapping(path = "/getAll")
    public List<Player> getList() {
        return getPlayerListUseCase.getAll();
    }
}
