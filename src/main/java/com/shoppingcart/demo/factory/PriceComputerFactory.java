package com.shoppingcart.demo.factory;

import com.shoppingcart.demo.util.BundlePriceComputer;
import com.shoppingcart.demo.util.IPriceComputer;
import com.shoppingcart.demo.util.PriceComputer;

public class PriceComputerFactory {
  public IPriceComputer getPriceComputer(Character code){
    if(code == 'A'){
      return new BundlePriceComputer(3,3.00);
    } else if(code == 'B'){
      return new PriceComputer();
    } else if(code == 'C'){
      return new BundlePriceComputer(6,5.00);
    } else if(code == 'D'){
      return new PriceComputer();
    }
    return null;
  }
}
