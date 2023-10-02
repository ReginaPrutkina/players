package com.intuit.players.persistence.mapper;

import com.intuit.players.domain.model.Player;
import com.intuit.players.persistence.entity.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;
import java.util.GregorianCalendar;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "birthDate", source = "playerEntity", qualifiedByName = "getBirthDate")
    @Mapping(target = "deathDate", source = "playerEntity", qualifiedByName = "getDeathDate")
    Player map(PlayerEntity playerEntity);

    @Named("getBirthDate")
    default Date getBirthDate(PlayerEntity playerEntity) {
        return getDate(playerEntity.getBirthYear(), playerEntity.getBirthMonth(), playerEntity.getBirthDay());
    }

    @Named("getDeathDate")
    default Date getDeathDate(PlayerEntity playerEntity) {
        return getDate(playerEntity.getDeathYear(), playerEntity.getDeathMonth(), playerEntity.getDeathDay());
    }

    default Date getDate(Integer year, Integer month, Integer day) {
        //add validation for year/month/day
        //timezone?
        if (year == null || month == null || day == null ) {
            return null;
        }
        return new GregorianCalendar(year, month - 1, day)
                .getTime();
    }
}
