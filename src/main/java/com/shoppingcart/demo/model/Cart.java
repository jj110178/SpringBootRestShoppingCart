package com.shoppingcart.demo.model;

import java.util.List;

public class Cart {
  private List<Product> plist;
  private String totalPrice;

  public List<Product> getPlist() {
    return plist;
  }

  public void setPlist(List<Product> plist) {
    this.plist = plist;
  }

  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public String toString() {
    return "Cart{" +
        "plist=" + plist +
        ", totalPrice='" + totalPrice + '\'' +
        '}';
  }


}
