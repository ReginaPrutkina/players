package com.intuit.players.persistence.repository;

import com.intuit.players.persistence.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, String> {
}
