package com.techtask.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Custom DataException Exception */
@ResponseStatus(HttpStatus.CONFLICT)
public class DataException extends RuntimeException {

  public DataException(String exception) {
    super(exception);
  }
}
