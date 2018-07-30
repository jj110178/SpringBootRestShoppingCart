package com.shoppingcart.demo.service;

import com.shoppingcart.demo.model.Cart;
import com.shoppingcart.demo.model.Product;
import java.util.List;
import java.util.Map;

public interface CartService {
  Map<Character, List<Product>>  scanProductsInCart(List<Product> productList);
  Cart getCartTotalPrice(String productList);
  Double computeTotalPricePerProduct(Character pCode, List<Product> plist);
}
