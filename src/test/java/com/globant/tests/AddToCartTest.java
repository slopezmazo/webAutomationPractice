package com.globant.tests;

import com.globant.pages.InventoryPage;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{
    @Test()
    public void printB(){
        InventoryPage inventory = new InventoryPage(driver);
        inventory.printButtons();
    }
}
