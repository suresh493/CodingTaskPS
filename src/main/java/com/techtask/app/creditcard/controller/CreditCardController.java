package com.techtask.app.creditcard.controller;

import java.util.List;

import com.techtask.app.creditcard.exception.CreditCardException;
import com.techtask.app.creditcard.exception.CreditCardNotFoundException;
import com.techtask.app.creditcard.exception.DataException;
import com.techtask.app.creditcard.exception.ValidationException;
import com.techtask.app.creditcard.model.CreditCard;
import com.techtask.app.creditcard.service.CreditCardService;
import com.techtask.app.creditcard.validator.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Credit card Rest Controller with global exception handling Currently APIs are not secured */
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/creditCards")
public class CreditCardController {

  @Autowired private CreditCardService creditCardService;

  @Autowired private CreditCardValidator creditCardValidator;

  @GetMapping(path = "/getAll", produces = "application/json")
  public List<CreditCard> getAllCreditCards() {
    try {
      return creditCardService.findAll();
    } catch (Exception e) {
      throw new CreditCardNotFoundException("Error retrieving credit cards");
    }
  }

  @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> addCreditCard(@RequestBody CreditCard card) {
    if (!creditCardValidator.isValidCardNumber(card.getNumber()))
      throw new ValidationException("Invalid card number.");
    try {
      creditCardService.addCreditCard(card);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (DuplicateKeyException e) {
      throw new DataException("Duplicate key :" + e.getMessage());
    } catch (CreditCardException e) {
      throw new CreditCardException("Error adding credit card.");
    }
  }
}
