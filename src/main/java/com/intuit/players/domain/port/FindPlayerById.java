package com.intuit.players.domain.port;

import com.intuit.players.domain.model.Player;

import java.util.Optional;

public interface FindPlayerById {

    Optional<Player> findById(String playerId);
}
