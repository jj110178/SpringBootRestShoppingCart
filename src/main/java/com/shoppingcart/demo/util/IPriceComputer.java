package com.shoppingcart.demo.util;

import com.shoppingcart.demo.model.Product;
import java.util.List;

public interface IPriceComputer {
  Double computePrice(List<Product> pList);


}
