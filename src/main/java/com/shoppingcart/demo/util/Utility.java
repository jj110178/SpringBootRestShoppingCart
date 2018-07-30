package com.shoppingcart.demo.util;

import com.shoppingcart.demo.factory.ProductFactory;
import com.shoppingcart.demo.model.Product;
import java.util.ArrayList;
import java.util.List;

public class Utility {
  ProductFactory productFactory = new ProductFactory();

  public List<Product> createCart(String productList) {
    List<Product> cart = new ArrayList<>();
    char[] products = productList.toCharArray();
    for(Character p: products){
      cart.add(productFactory.createProduct(p));
      System.out.println(" Adding to Cart " + productFactory.createProduct(p));
    }
    return cart;
  }

  public boolean isValidProduct(String productlist) {
    char[] products = productlist.toCharArray();
    boolean flag = false;
    for(Character p: products){
      if(p.equals('A') || p.equals('B') || p.equals('C') || p.equals('D') ){
        flag = true;
      } else {
        flag = false;
      }
    }
    return flag;
  }
}
