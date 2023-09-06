package com.globant.tests;

import com.globant.data.DataTestProvider;
import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{
    private String INVENTORY_PAGE_TITLE = "Products";
    private String CART_PAGE_TITLE = "Your Cart";
    private String CHECKOUT_STEP_ONE_PAGE_TITLE = "Checkout: Your Information";
    private String CHECKOUT_STEP_TWO_PAGE_TITLE = "Checkout: Overview";
    private String CHECKOUT_COMPLETE_PAGE_TITLE = "Checkout: Complete!";
    private String SHOPPING_CART_BADGE = "1";
    private int SHOPPING_CART_ITEMS_AMOUNT = 1;
    @Test(dataProvider = "checkoutStepOne",dataProviderClass = DataTestProvider.class)
    public void purchaseTest(String firstName,String lastName, String zipPostalCode){
        //inventory page
        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getTitle(), INVENTORY_PAGE_TITLE);
        logInfo("inventory page loaded successfully");

        inventory.clickOneRandomAddToCart();
        Assert.assertEquals(inventory.getShoppingCartBadge(),SHOPPING_CART_BADGE);
        logInfo("item added to cart successfully");

        inventory.clickOnCartLink();
        logInfo("redirecting to cart page...");

        //cart page
        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getTitle(), CART_PAGE_TITLE);
        logInfo("cart page loaded successfully");

        Assert.assertEquals(cart.getCartItemsSize(), SHOPPING_CART_ITEMS_AMOUNT);
        cart.clickCheckout();
        logInfo("redirecting to checkout step one page...");

        //checkout step one page
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);
        Assert.assertEquals(checkoutStepOne.getTitle(), CHECKOUT_STEP_ONE_PAGE_TITLE);
        logInfo("checkout step one page loaded successfully");

        logInfo("filling out first name");
        checkoutStepOne.typeFirstName(firstName);
        logInfo("filling out last name");
        checkoutStepOne.typeLastName(lastName);
        logInfo("filling out zip/postal code");
        checkoutStepOne.typeZipPostalName(zipPostalCode);
        checkoutStepOne.clickContinueButton();
        logInfo("redirecting to checkout step two page...");

        //checkout step two page
        CheckoutStepTwoPage checkoutSteptwo = new CheckoutStepTwoPage(driver);
        Assert.assertEquals(checkoutSteptwo.getTitle(), CHECKOUT_STEP_TWO_PAGE_TITLE);
        logInfo("checkout step two page loaded successfully");
        checkoutSteptwo.clickFinishButton();
        logInfo("redirecting to checkout complete page...");

        //checkout complete
        CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutComplete.getTitle(), CHECKOUT_COMPLETE_PAGE_TITLE);
        logInfo("checkout complete page loaded successfully");
//        checkoutComplete.getTitle();
    }
}
