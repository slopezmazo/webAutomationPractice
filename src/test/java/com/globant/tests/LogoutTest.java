package com.globant.tests;

import com.globant.data.DataTestProvider;
import com.globant.pages.InventoryPage;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test()
    public void purchaseTest(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        logInfo("Click on menu");
        inventoryPage.clickOnMenu();
        logInfo("Click on logout");
        inventoryPage.clickLogoutOption();
        logInfo("Logging out");
    }
}
