package com.intuit.players.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Player {
    private String playerID;
    private Date birthDate;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Date deathDate;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;

    //todo change to enum R/L
    private String bats;

    //todo change to enum R/L
    private String throwS;

    private Date debut;
    private Date finalGame;
    private String retroID;
    private String bbrefID;
}
