package com.intuit.players.domain.useCase;

import com.intuit.players.domain.model.Player;

public interface GetPlayerByIdUseCase {

    Player getById(String PlayerId);
}

