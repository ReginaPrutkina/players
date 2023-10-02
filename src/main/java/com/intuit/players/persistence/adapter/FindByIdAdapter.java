package com.intuit.players.persistence.adapter;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.port.FindPlayerById;
import com.intuit.players.persistence.mapper.PlayerMapper;
import com.intuit.players.persistence.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdAdapter implements FindPlayerById {
    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    @Override
    public Optional<Player> findById(String playerId) {
        return playerRepository.findById(playerId).map(mapper::map);
    }
}
