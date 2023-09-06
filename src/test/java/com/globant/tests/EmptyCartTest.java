package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyCartTest extends BaseTest{
    private String INVENTORY_PAGE_TITLE = "Products";
    private String CART_PAGE_TITLE = "Your Cart";
    private String SHOPPING_CART_BADGE = "3";
    private int SHOPPING_CART_ITEMS_AMOUNT_BEFORE = 3;
    private int SHOPPING_CART_ITEMS_AMOUNT_AFTER = 0;
    @Test()
    public void EmptyCart(){

        //inventory page
        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getTitle(), INVENTORY_PAGE_TITLE);
        logInfo("inventory page loaded successfully");

        inventory.clickThreeRandomAddToCart();
        Assert.assertEquals(inventory.getShoppingCartBadge(),SHOPPING_CART_BADGE);
        logInfo("item added to cart successfully");

        inventory.clickOnCartLink();
        logInfo("redirecting to cart page...");

        //cart page
        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getTitle(), CART_PAGE_TITLE);
        logInfo("cart page loaded successfully");

        Assert.assertEquals(cart.getCartItemsSize(), SHOPPING_CART_ITEMS_AMOUNT_BEFORE);
        cart.removeCartElements();
        Assert.assertEquals(cart.getCartItemsSize(), SHOPPING_CART_ITEMS_AMOUNT_AFTER);
        logInfo("Empty cart...");
    }
}