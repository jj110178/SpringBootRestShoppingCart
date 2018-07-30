package com.shoppingcart.demo.util;

import com.shoppingcart.demo.exception.ProductNotFoundException;
import com.shoppingcart.demo.model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class BundlePriceComputer implements IPriceComputer {
  private Integer bundleCount;
  private Double bundlePrice;

  public BundlePriceComputer(Integer bundleCount, Double bundlePrice){
    this.bundleCount = bundleCount;
    this.bundlePrice = bundlePrice;
  }

  public Double computePrice(List<Product> pList) {
    Double productTotalPrice = 0d;
    if(pList.size() < 1)
      throw new ProductNotFoundException("Product List is Empty!!! ");

    if(pList.size() < bundleCount){
      // if productlist is less than the bundle count
      productTotalPrice = pList.stream().collect(Collectors.summingDouble(Product::getpPrice));
    } else {
      // compute bundle price
      productTotalPrice = ((pList.size() / bundleCount) * bundlePrice ) + ((pList.size() % bundleCount) * pList.get(0).getpPrice());
    }
    return productTotalPrice;
  }
}
