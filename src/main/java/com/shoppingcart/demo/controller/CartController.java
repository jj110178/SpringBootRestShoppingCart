package com.shoppingcart.demo.controller;

import com.shoppingcart.demo.model.Cart;
import com.shoppingcart.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shoppingcart")
public class CartController {

  @Autowired
  CartService service;

  @RequestMapping(value = "/{productlist}", method = RequestMethod.GET, headers="Accept=application/json")
  public @ResponseBody ResponseEntity<Cart> checkOutProcess(@PathVariable(value = "productlist") String productlist) {
    Cart cart = service.getCartTotalPrice(productlist);
    return new ResponseEntity<Cart> (cart, HttpStatus.OK);
  }

}
