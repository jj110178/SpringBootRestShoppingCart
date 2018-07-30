package com.shoppingcart.demo.exception;

public class CartExceptionResponse {

  private String message;
  private String details;

  public CartExceptionResponse(String message, String details) {
    super();
    this.message = message;
    this.details = details;

  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }
}