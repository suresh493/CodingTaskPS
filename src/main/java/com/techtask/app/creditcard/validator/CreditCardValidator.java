package com.techtask.app.creditcard.validator;

import org.springframework.stereotype.Service;

@Service
public class CreditCardValidator {
    private String number;
  /**
   * Validate card number input using checkLuhn10 algorithm
   *
   * @param cardNumber
   * @return
   */
  public boolean isValidCardNumber(String cardNumber) {
        number = cardNumber.replaceAll("[ -]", "");
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = (int) number.charAt(i) - '0';
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
        }
        return (sum % 10) == 0;
    }
}
