package com.techtask.app.creditcard.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.techtask.app.creditcard.model.CreditCard;
import com.techtask.app.creditcard.validator.CreditCardValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DuplicateKeyException;

public class CreditCardServiceUnitTests {

  CreditCardService creditCardManagementService;
  CreditCardValidator creditCardValidator;

  @BeforeEach
  public void init() {
    creditCardManagementService = new CreditCardService();
    creditCardValidator = new CreditCardValidator();
    CreditCardService.init();
  }

  @Test
  public void addCrediCard_retriveCard_testDupliacteKeys() {
    String cardNumber = "3333444422221111";
    CreditCard cd = new CreditCard("Marco", cardNumber, 1000, 0);
    creditCardManagementService.addCreditCard(cd);

    CreditCard found =
        creditCardManagementService.findAll().stream()
            .filter(card -> card.getNumber().equals(cardNumber))
            .findFirst()
            .get();

    assertTrue(found.getNumber().equals(cd.getNumber()));

    try {
      creditCardManagementService.addCreditCard(cd);
      fail();
    } catch (DuplicateKeyException e) {
    }
  }

  @Test
  public void testLuhn10Algorithm() {
    CreditCard validCreditCard = new CreditCard("Test1", "4431-1234-1322-9056", 100, 0);
    assertTrue(creditCardValidator.isValidCardNumber(validCreditCard.getNumber()));

    CreditCard invalidCreditCard = new CreditCard("Test2", "1111-4444-5555-1111", 100, 0);
    assertFalse(creditCardValidator.isValidCardNumber(invalidCreditCard.getNumber()));
  }
}
