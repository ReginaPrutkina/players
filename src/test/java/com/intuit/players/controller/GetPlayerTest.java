package com.intuit.players.controller;

import com.intuit.players.domain.model.Player;
import com.intuit.players.domain.useCase.GetPlayerByIdUseCase;
import com.intuit.players.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetPlayerTest {
    private final static String PLAYER_ID = "someValidId";

    @Mock
    private GetPlayerByIdUseCase getPlayerByIdUseCase;

    @InjectMocks
    private GetPlayer subj;

    @Test
    void validPlayerId() {
        when(getPlayerByIdUseCase.getById(anyString())).thenReturn(Player.builder().playerID(PLAYER_ID).build());
        Player result = subj.getById(PLAYER_ID);

        verify(getPlayerByIdUseCase).getById(PLAYER_ID);
        assertEquals(PLAYER_ID, result.getPlayerID());
    }

    @ParameterizedTest
    @ValueSource(strings = {"    "})
    @EmptySource
    void whenInvalidPlayerIdThenException(String playerId) {
        assertThrows(ValidationException.class, () -> subj.getById(playerId));

        verifyNoInteractions(getPlayerByIdUseCase);
    }
}