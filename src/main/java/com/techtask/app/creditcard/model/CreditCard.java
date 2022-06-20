package com.techtask.app.creditcard.model;

import lombok.Data;

@Data
public class CreditCard {

  private String userName;
  private String number;
  private int limit;
  private int balance;

  public CreditCard(String userName, String number, int limit, int balance) {
    this.userName = userName;
    this.number = number;
    this.limit = limit;
    this.balance = balance;
  }

  public CreditCard() {}
}
