package com.techtask.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Custom ValidationException Exception */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidationException extends RuntimeException {

  public ValidationException(String exception) {
    super(exception);
  }
}
