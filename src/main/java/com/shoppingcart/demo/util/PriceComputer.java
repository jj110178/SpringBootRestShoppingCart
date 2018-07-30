package com.shoppingcart.demo.util;

import com.shoppingcart.demo.exception.ProductNotFoundException;
import com.shoppingcart.demo.model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class PriceComputer implements IPriceComputer {

  @Override
  public Double computePrice(List<Product> pList) {
    if(pList.size() < 1)
      throw new ProductNotFoundException("Product List is Empty!!! ");

    return pList.stream().collect(Collectors.summingDouble(Product::getpPrice));
  }
}
