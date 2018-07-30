package com.shoppingcart.demo.util;

import static org.junit.Assert.*;

import com.shoppingcart.demo.model.Product;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UtilityTest {

  private List<Product> prodList;
  private Utility util;

  @Before
  public void setup(){
    util = new Utility();

  }

  @Test
  public void createCartTest() {
    prodList = util.createCart("AAAA");
    assertTrue(prodList != null);
    assertTrue(prodList.size() > 0);
    assertTrue(prodList.get(0).getpCode() == 'A');
  }

  @Test
  public void isValidProductTest() {
    assertTrue(util.isValidProduct("ABCD"));
    assertFalse(util.isValidProduct("ABCDE"));
    assertTrue(util.isValidProduct("AAA"));
    assertFalse(util.isValidProduct("FE"));

  }
}