package dev.walker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Book Found")
public class ScoreNotFoundException extends RuntimeException {
}
