package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage{
    @FindAll({
            @FindBy(css = ".inventory_item button[id^=add-to-cart]") // Replace with the appropriate locator
    })
    private List<WebElement> addToCartButtons;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart(WebElement button) {
       clickElement(button);
    }

    public void printButtons() {
        System.out.println(addToCartButtons.size());
    }
}
