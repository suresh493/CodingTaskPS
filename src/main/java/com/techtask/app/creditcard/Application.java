package com.techtask.app.creditcard;

import com.techtask.app.creditcard.service.CreditCardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    CreditCardService.init();
  }
}
