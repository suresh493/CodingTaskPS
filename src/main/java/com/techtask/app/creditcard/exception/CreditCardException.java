package com.techtask.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Custom CreditCard Exception */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CreditCardException extends RuntimeException {

  public CreditCardException(String exception) {
    super(exception);
  }
}
