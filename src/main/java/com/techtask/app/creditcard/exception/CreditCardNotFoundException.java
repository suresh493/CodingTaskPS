package com.techtask.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Custom CreditCardNotFoundException Exception */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreditCardNotFoundException extends RuntimeException {

  public CreditCardNotFoundException(String exception) {
    super(exception);
  }
}
