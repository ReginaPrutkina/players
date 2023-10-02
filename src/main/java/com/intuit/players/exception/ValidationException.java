package com.intuit.players.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
