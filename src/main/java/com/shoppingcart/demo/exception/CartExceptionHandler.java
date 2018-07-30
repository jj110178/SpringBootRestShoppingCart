package com.shoppingcart.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class CartExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Exception> handleAllExceptions(final Exception ex, final WebRequest request) {
    Exception exceptionResponse = new Exception(ex.getMessage());
    return new ResponseEntity<Exception>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler({ ProductNotFoundException.class })
  protected ResponseEntity<CartExceptionResponse> handleNotFound(final Exception ex, final WebRequest request) {
    CartExceptionResponse exceptionResponse = new CartExceptionResponse(ex.getMessage(), "Invalid Product in the Cart");
    return new ResponseEntity<CartExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

}