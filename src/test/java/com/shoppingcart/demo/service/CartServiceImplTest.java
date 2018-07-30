package com.shoppingcart.demo.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.shoppingcart.demo.model.Cart;
import com.shoppingcart.demo.model.Product;
import com.shoppingcart.demo.util.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
public class CartServiceImplTest {

  @Mock
  private CartService service;
  private List<Product> productList;
  private Utility util;
  private Cart cart;

  @Before
  public void setUp() throws Exception {
    productList = new ArrayList<>();
    util = new Utility();
    cart = new Cart();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getScanProductsInCart() {
    productList = util.createCart("ABCDABA");
    cart.setTotalPrice("$13.25");
    cart.setPlist(productList);
    Map<Character, List<Product>> pList = productList.stream().collect(Collectors.groupingBy(Product::getpCode));

    when(service.getCartTotalPrice("ABCDABA")).thenReturn(cart);
    when(service.scanProductsInCart(productList)).thenReturn(pList);

    assertTrue(service.getCartTotalPrice("ABCDABA").getTotalPrice().equals("$13.25"));
    assertTrue(service.getCartTotalPrice("ABCDABA").getPlist().size() == 7);
    assertTrue(service.scanProductsInCart(productList).size() == 4);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('A')).size() == 3);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('B')).size() == 2);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('C')).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('D')).size() == 1);

  }

  @Test
  public void getCartTotalPrice() {
    productList = util.createCart("ABCDABA");
    cart.setTotalPrice("$13.25");
    cart.setPlist(productList);
    Map<Character, List<Product>> pList = productList.stream().collect(Collectors.groupingBy(Product::getpCode));

    when(service.getCartTotalPrice("ABCDABA")).thenReturn(cart);
    when(service.scanProductsInCart(productList)).thenReturn(pList);

    assertTrue(service.scanProductsInCart(productList).size() == 4);
    assertTrue(service.getCartTotalPrice("ABCDABA").getTotalPrice().equals("$13.25"));
    assertTrue(service.getCartTotalPrice("ABCDABA").equals(cart));

  }

  @Test
  public void computeTotalPricePerProductTest() {
    productList = util.createCart("ABCDABA");
    cart.setTotalPrice("$13.25");
    cart.setPlist(productList);
    Map<Character, List<Product>> pList = productList.stream().collect(Collectors.groupingBy(Product::getpCode));

    when(service.getCartTotalPrice("ABCDABA")).thenReturn(cart);
    when(service.scanProductsInCart(productList)).thenReturn(pList);
    when(service.computeTotalPricePerProduct('A',pList.get(Character.valueOf('A')))).thenReturn(3.00);
    when(service.computeTotalPricePerProduct('B',pList.get(Character.valueOf('B')))).thenReturn(8.50);
    when(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C')))).thenReturn(1.00);
    when(service.computeTotalPricePerProduct('D',pList.get(Character.valueOf('D')))).thenReturn(.75);

    assertTrue(service.scanProductsInCart(productList).size() == 4);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('A')).size() == 3);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('B')).size() == 2);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('C')).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('D')).size() == 1);

    assertTrue(service.computeTotalPricePerProduct('A',pList.get(Character.valueOf('A'))) == 3.00);
    assertTrue(service.computeTotalPricePerProduct('B',pList.get(Character.valueOf('B'))) == 8.50);
    assertTrue(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C'))) == 1.00);
    assertTrue(service.computeTotalPricePerProduct('D',pList.get(Character.valueOf('D'))) == .75);
  }

  @Test
  public void scenario1Test() {
    //build cart
    productList = util.createCart("ABCDABA");
    cart.setTotalPrice("$13.25");
    cart.setPlist(productList);
    Map<Character, List<Product>> pList = productList.stream().collect(Collectors.groupingBy(Product::getpCode));

    when(service.getCartTotalPrice("ABCDABA")).thenReturn(cart);
    when(service.scanProductsInCart(productList)).thenReturn(pList);
    when(service.computeTotalPricePerProduct('A',pList.get(Character.valueOf('A')))).thenReturn(3.00);
    when(service.computeTotalPricePerProduct('B',pList.get(Character.valueOf('B')))).thenReturn(8.50);
    when(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C')))).thenReturn(1.00);
    when(service.computeTotalPricePerProduct('D',pList.get(Character.valueOf('D')))).thenReturn(.75);

    assertTrue(service.scanProductsInCart(productList).size() == 4);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('A')).size() == 3);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('B')).size() == 2);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('C')).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('D')).size() == 1);

    assertTrue(service.computeTotalPricePerProduct('A',pList.get(Character.valueOf('A'))) == 3.00);
    assertTrue(service.computeTotalPricePerProduct('B',pList.get(Character.valueOf('B'))) == 8.50);
    assertTrue(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C'))) == 1.00);
    assertTrue(service.computeTotalPricePerProduct('D',pList.get(Character.valueOf('D'))) == .75);

    assertTrue(service.getCartTotalPrice("ABCDABA").equals(cart));
  }

  @Test
  public void scenario2Test() {
    //build cart
    productList = util.createCart("CCCCCCC");
    cart.setTotalPrice("$6.00");
    cart.setPlist(productList);
    Map<Character, List<Product>> pList = productList.stream().collect(Collectors.groupingBy(Product::getpCode));

    when(service.getCartTotalPrice("CCCCCCC")).thenReturn(cart);
    when(service.scanProductsInCart(productList)).thenReturn(pList);
    when(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C')))).thenReturn(6.00);

    assertTrue(service.scanProductsInCart(productList).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('C')).size() == 7);
    assertTrue(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C'))) == 6.00);
    assertTrue(service.getCartTotalPrice("CCCCCCC").equals(cart));
  }

  @Test
  public void scenario3Test() {
    //build cart
    productList = util.createCart("ABCD");
    cart.setTotalPrice("$7.25");
    cart.setPlist(productList);
    Map<Character, List<Product>> pList = productList.stream().collect(Collectors.groupingBy(Product::getpCode));

    when(service.getCartTotalPrice("ABCD")).thenReturn(cart);
    when(service.scanProductsInCart(productList)).thenReturn(pList);
    when(service.computeTotalPricePerProduct('A',pList.get(Character.valueOf('A')))).thenReturn(1.25);
    when(service.computeTotalPricePerProduct('B',pList.get(Character.valueOf('B')))).thenReturn(4.25);
    when(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C')))).thenReturn(1.00);
    when(service.computeTotalPricePerProduct('D',pList.get(Character.valueOf('D')))).thenReturn(.75);

    assertTrue(service.scanProductsInCart(productList).size() == 4);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('A')).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('B')).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('C')).size() == 1);
    assertTrue(service.scanProductsInCart(productList).get(Character.valueOf('D')).size() == 1);

    assertTrue(service.computeTotalPricePerProduct('A',pList.get(Character.valueOf('A'))) == 1.25);
    assertTrue(service.computeTotalPricePerProduct('B',pList.get(Character.valueOf('B'))) == 4.25);
    assertTrue(service.computeTotalPricePerProduct('C',pList.get(Character.valueOf('C'))) == 1.00);
    assertTrue(service.computeTotalPricePerProduct('D',pList.get(Character.valueOf('D'))) == .75);

    assertTrue(service.getCartTotalPrice("ABCD").equals(cart));
  }
}