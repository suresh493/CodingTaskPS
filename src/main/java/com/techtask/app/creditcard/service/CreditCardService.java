package com.techtask.app.creditcard.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.techtask.app.creditcard.exception.CreditCardException;
import com.techtask.app.creditcard.exception.CreditCardNotFoundException;
import com.techtask.app.creditcard.support.CreditCardValueMapper;
import com.techtask.app.creditcard.support.DbConstants;
import com.techtask.app.creditcard.model.CreditCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

  static JdbcTemplate jdbcTemplate;

  /**
   * Finds all credit card
   *
   * @return
   * @throws CreditCardNotFoundException
   */
  public List<CreditCard> findAll() throws CreditCardNotFoundException {
    return jdbcTemplate.query(DbConstants.GET_ALL_QUERY, new CreditCardValueMapper());
  }

  /**
   * Adds credit card
   *
   * @param card
   * @throws CreditCardException
   */
  public void addCreditCard(CreditCard card) throws CreditCardException {
    jdbcTemplate.update(
        DbConstants.INSERT_QUERY,
        new Object[] {card.getUserName(), card.getNumber(), card.getLimit(), 0});
  }

  public static void init() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(DbConstants.JDBC_DRIVER);
    dataSource.setUrl(DbConstants.DB_URL);
    dataSource.setUsername(DbConstants.USER);
    dataSource.setPassword(DbConstants.PASS);

    jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.execute(DbConstants.CREATE_TABLE_QUERY);
  }
}
