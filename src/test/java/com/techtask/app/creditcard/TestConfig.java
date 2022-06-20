package com.techtask.app.creditcard;

import com.techtask.app.creditcard.controller.CreditCardController;
import com.techtask.app.creditcard.service.CreditCardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

  @Bean
  public CreditCardController creditCardController() {
    return new CreditCardController();
  }

  @Bean
  public CreditCardService creditCardService() {
    CreditCardService.init();
    return new CreditCardService();
  }
}
