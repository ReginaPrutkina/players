package com.intuit.players.domain.useCase;

import com.intuit.players.domain.model.Player;

import java.util.List;

public interface GetPlayerListUseCase {
    List<Player> getAll();
}
