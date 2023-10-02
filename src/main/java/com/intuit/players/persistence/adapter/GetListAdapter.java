package com.intuit.players.persistence.adapter;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.port.GetPlayerList;
import com.intuit.players.persistence.entity.PlayerEntity;
import com.intuit.players.persistence.mapper.PlayerMapper;
import com.intuit.players.persistence.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GetListAdapter implements GetPlayerList {
    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    @Override
    public List<Player> playerLiat() {
        Iterable<PlayerEntity> players = playerRepository.findAll();
        return StreamSupport.stream(players.spliterator(), false)
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
