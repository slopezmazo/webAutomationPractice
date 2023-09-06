package com.globant.tests;

import com.globant.data.DataTestProvider;
import com.globant.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    private String INVENTORY_PAGE_TITLE = "Products";
    private String LOGIN_PAGE = "Products";

    @Test()
    public void purchaseTest(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getTitle(), INVENTORY_PAGE_TITLE);
        logInfo("Click on menu");
        inventoryPage.clickOnMenu();
        logInfo("Click on logout");
        inventoryPage.clickLogoutOption();


        logInfo("Logging out");
    }
}
