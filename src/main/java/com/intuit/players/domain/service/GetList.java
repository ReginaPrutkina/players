package com.intuit.players.domain.service;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.port.GetPlayerList;
import com.intuit.players.domain.useCase.GetPlayerListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetList implements GetPlayerListUseCase {
    private final GetPlayerList getPlayerList;
    @Override
    public List<Player> getAll() {
        return getPlayerList.playerLiat();
    }
}
