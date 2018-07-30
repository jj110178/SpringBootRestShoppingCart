package com.shoppingcart.demo.service;

import com.shoppingcart.demo.exception.ProductNotFoundException;
import com.shoppingcart.demo.factory.PriceComputerFactory;
import com.shoppingcart.demo.model.Cart;
import com.shoppingcart.demo.model.Product;
import com.shoppingcart.demo.util.IPriceComputer;
import com.shoppingcart.demo.util.Utility;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

  private Utility u = new Utility(); // for creating the product list
  private NumberFormat formatter = NumberFormat.getCurrencyInstance();

  @Override
  public Map<Character, List<Product>> scanProductsInCart(List<Product> productList) {
    return productList.stream().collect(Collectors.groupingBy(Product::getpCode));
  }

  @Override
  public Cart getCartTotalPrice(String productList) {
    if(!u.isValidProduct(productList))
      throw new ProductNotFoundException("Invalid Product List!!!");

    Double total = 0d;
    Cart cart = null;
    Map<Character, List<Product>> pList = null;
    try {
      cart = new Cart();
      cart.setPlist(u.createCart(productList));
      pList = scanProductsInCart(u.createCart(productList));
      for (Map.Entry<Character, List<Product>> entry : pList.entrySet()) {
        total += computeTotalPricePerProduct(entry.getKey(), entry.getValue());
      }
      cart.setTotalPrice(formatter.format(total));
    } catch (ProductNotFoundException e){
      e.printStackTrace();
    } catch (Exception e){
      e.printStackTrace();
    }
    return cart;
  }

  @Override
  public Double computeTotalPricePerProduct(Character pCode, List<Product> plist) {
    Double totalPrice = null;
    PriceComputerFactory priceFactory = new PriceComputerFactory();
    IPriceComputer priceComputer = priceFactory.getPriceComputer(pCode);
    try {
      totalPrice =  priceComputer.computePrice(plist);
    } catch (ProductNotFoundException ece){
      ece.printStackTrace();
    } catch (NumberFormatException nfe){
      nfe.printStackTrace();
    } catch (Exception e){
      e.printStackTrace();
    }
    return totalPrice;
  }
}
