package com.techtask.app.creditcard.controller;

import com.techtask.app.creditcard.TestConfig;
import com.techtask.app.creditcard.model.CreditCard;
import com.techtask.app.creditcard.service.CreditCardService;
import com.techtask.app.creditcard.validator.CreditCardValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
public class CreditCardControllerTest {

  @InjectMocks CreditCardController controller;

  @Mock CreditCardService creditCardService;

  @Mock CreditCardValidator creditCardValidator;

  @Autowired MockMvc mockMvc;

  @BeforeEach
  public void init() {
    mockMvc = standaloneSetup(controller).build();
  }

  @Test
  public void test_GetAll_CreditCards_when_empty() throws Exception {
    when(creditCardService.findAll()).thenReturn(Collections.emptyList());
    mockMvc
        .perform(MockMvcRequestBuilders.get("/creditCards/getAll"))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
  }

  @Test
  public void test_GetAll_CreditCards_when_not_empty() throws Exception {
    List<CreditCard> creditCardList = new ArrayList<>();
    CreditCard creditCard = new CreditCard();
    creditCard.setBalance(0);
    creditCard.setLimit(100);
    creditCard.setNumber("1111111111111111");
    creditCard.setUserName("Mock");
    creditCardList.add(creditCard);
    when(creditCardService.findAll()).thenReturn(creditCardList);
    mockMvc
        .perform(MockMvcRequestBuilders.get("/creditCards/getAll"))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
  }

  @Test
  public void test_valid_add_creditCard() throws Exception {
    when(creditCardValidator.isValidCardNumber(any())).thenReturn(true);
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/creditCards/add")
                .content(
                    new ObjectMapper()
                        .writeValueAsString(new CreditCard("Mock", "4242424242424242", 100, 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void test_invalid_add_creditCard() throws Exception {
    when(creditCardValidator.isValidCardNumber(any())).thenReturn(false);
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/creditCards/add")
                .content(
                    new ObjectMapper()
                        .writeValueAsString(new CreditCard("Mock", "11111111111111", 100, 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnprocessableEntity());
  }
}
