package com.shoppingcart.demo.model;

import java.util.Objects;

public class Product {
  private Character pCode;
  private Double pPrice;

  public Product() {
  }

  public Product(Character pCode, double pPrice) {
    this.pCode = pCode;
    this.pPrice = pPrice;
  }

  public Character getpCode() {
    return pCode;
  }

  public void setpCode(Character pCode) {
    this.pCode = pCode;
  }

  public Double getpPrice() {
    return pPrice;
  }

  public void setpPrice(Double pPrice) {
    this.pPrice = pPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return pCode == product.pCode &&
        Double.compare(product.pPrice, pPrice) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pCode, pPrice);
  }

  @Override
  public String toString() {
    return "Product{" +
        "pCode=" + pCode +
        ", pPrice=" + pPrice +
        '}';
  }
}
