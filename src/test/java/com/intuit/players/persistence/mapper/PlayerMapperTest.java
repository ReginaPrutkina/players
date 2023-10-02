package com.intuit.players.persistence.mapper;

import com.intuit.players.domain.model.Player;
import com.intuit.players.persistence.entity.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;


class PlayerMapperTest {
    private final static String PLAYER_ID = "playerID";
    private final static String NAME_GIVEN = "name family";
    private final PlayerMapper mapper = Mappers.getMapper(PlayerMapper.class);

    @Test
    void checkDefaultMapping() {
        //for all the same fields
        PlayerEntity playerEntity = PlayerEntity.builder()
                .playerID(PLAYER_ID)
                .nameGiven(NAME_GIVEN)
                .build();
        Player player = mapper.map(playerEntity);

        assertEquals(PLAYER_ID, player.getPlayerID());
        assertEquals(NAME_GIVEN, player.getNameGiven());
    }

    @Test
    void checkValidDateMapping() {
        PlayerEntity playerEntity = PlayerEntity.builder()
                .birthDay(15)
                .birthMonth(1)
                .birthYear(1995)
                .build();
        Player player = mapper.map(playerEntity);
        String sDate = new SimpleDateFormat("dd/MM/yyyy").format(player.getBirthDate());

        assertEquals("15/01/1995", sDate);
    }

    @Test
    void whenDayNullReturnNull() {
        //the same for year/month
        PlayerEntity playerEntity = PlayerEntity.builder()
                .birthMonth(1)
                .birthYear(1995)
                .build();
        Player player = mapper.map(playerEntity);
        assertNull(player.getBirthDate());
    }
}