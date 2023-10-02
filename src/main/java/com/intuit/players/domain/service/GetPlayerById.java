package com.intuit.players.domain.service;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.port.FindPlayerById;
import com.intuit.players.domain.useCase.GetPlayerByIdUseCase;
import com.intuit.players.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPlayerById implements GetPlayerByIdUseCase{
    private final FindPlayerById findPlayerById;
    @Override
    public Player getById(String playerId) {
        return findPlayerById.findById(playerId)
                .orElseThrow(() -> new BusinessException(String.format("Player with %s not found ", playerId)));
    }
}
