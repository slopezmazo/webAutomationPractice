package com.globant.tests;

import com.globant.data.DataTestProvider;
import com.globant.pages.*;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{
    @Test(dataProvider = "checkoutStepOne",dataProviderClass = DataTestProvider.class)
    public void purchaseTest(String firstName,String lastName, String zipPostalCode){

        //inventory page
        InventoryPage inventory = new InventoryPage(driver);
        logInfo("inventory page loaded successfully");
        inventory.clickOneRandomAddToCart();
        logInfo("item added to cart successfully");
        inventory.clickOnCartLink();
        logInfo("redirecting to cart page...");

        //cart page
        CartPage cart = new CartPage(driver);
        logInfo("cart page loaded successfully");
        cart.clickCheckout();
        logInfo("redirecting to checkout step one page...");

        //checkout step one page
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);
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
        logInfo("checkout step two page loaded successfully");
        checkoutSteptwo.clickFinishButton();
        logInfo("redirecting to checkout complete page...");

        //checkout complete
        logInfo("checkout complete page loaded successfully");
        CheckoutCompletePage checkoutComplete = new CheckoutCompletePage(driver);
//        checkoutComplete.getTitle();
    }
}
