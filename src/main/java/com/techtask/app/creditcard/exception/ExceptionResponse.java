package com.techtask.app.creditcard.exception;

import lombok.Data;

import java.util.Date;

/** ExceptionResponse schema (lombok setter/getters) */
@Data
public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;

  public ExceptionResponse(Date timestamp, String message, String details) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }
}
