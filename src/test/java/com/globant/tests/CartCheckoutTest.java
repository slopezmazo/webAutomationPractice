package com.globant.tests;

import com.globant.pages.CartPage;
import org.testng.annotations.Test;

public class CartCheckoutTest extends BaseTest{
    @Test()
    public void clickCartCheckout(){
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();
    }
}
