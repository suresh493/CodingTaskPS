package com.techtask.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CreditCardException.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(
      CreditCardException ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(CreditCardNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(
      CreditCardNotFoundException ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ValidationException.class)
  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(
      ValidationException ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(DataException.class)
  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(
      DataException ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
  }
}
