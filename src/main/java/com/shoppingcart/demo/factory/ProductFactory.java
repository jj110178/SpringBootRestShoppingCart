package com.shoppingcart.demo.factory;

import com.shoppingcart.demo.exception.ProductNotFoundException;
import com.shoppingcart.demo.model.Product;

public class ProductFactory {

  public Product createProduct(Character p) {
    if(p == 'A') {
      return new Product('A', 1.25);
    } else if(p == 'B') {
      return new Product('B', 4.25);
    } else if(p == 'C') {
      return new Product('C', 1.00);
    } else if(p == 'D') {
      return new Product('D', .75);
    } else {
      throw new ProductNotFoundException("Product Not Found " + p);
    }
  }
}
