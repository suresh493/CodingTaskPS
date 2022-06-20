package com.techtask.app.creditcard.support;

import com.techtask.app.creditcard.model.CreditCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardValueMapper implements RowMapper<CreditCard> {
  public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
    CreditCard card = new CreditCard();
    card.setUserName(rs.getString("name"));
    card.setNumber(rs.getString("number"));
    card.setLimit(rs.getInt("card_limit"));
    card.setBalance(rs.getInt("balance"));
    return card;
  }
}
