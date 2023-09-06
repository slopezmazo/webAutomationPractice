package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.InventoryPage;
import org.testng.annotations.Test;

public class EmptyCartTest extends BaseTest{
    @Test()
    public void EmptyCart(){
        //inventory page
        InventoryPage inventory = new InventoryPage(driver);
        logInfo("inventory page loaded successfully");
        inventory.clickThreeRandomAddToCart();
        logInfo("items added to cart successfully");
        inventory.clickOnCartLink();
        logInfo("redirecting to cart page...");

        //cart page
        CartPage cart = new CartPage(driver);
        logInfo("cart page loaded successfully");
        cart.removeCartElements();
        logInfo("Emptying cart...");

    }
}