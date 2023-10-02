package com.intuit.players.controller;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.useCase.GetPlayerByIdUseCase;
import com.intuit.players.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetPlayer {
    private final GetPlayerByIdUseCase getPlayerByIdUseCase;

    @GetMapping(path = "/getById/{playerId}")
    public Player getById(@PathVariable String playerId) {
        if (playerId.isBlank()) {
            throw new ValidationException("playerId must not be blank");
        }
        return getPlayerByIdUseCase.getById(playerId);
    }
}
