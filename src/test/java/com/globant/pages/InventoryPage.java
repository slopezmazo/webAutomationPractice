package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.Random;

import java.util.List;

public class InventoryPage extends BasePage{
//    @FindAll({
//            @FindBy(css = ".inventory_item button[id^=add-to-cart]")
//    })

    @FindBy(css = "button[id^=add-to-cart]")
    private List<WebElement> addToCartButtons;


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOneRandomAddToCart() {
        Random rand = new Random();
        int n = rand.nextInt(addToCartButtons.size());
        clickElement(addToCartButtons.get(n));
        setShoppingCartBadge();
    }
    public void clickThreeRandomAddToCart() {
        Collections.shuffle(this.addToCartButtons);
        clickElement(this.addToCartButtons.get(0));
        clickElement(this.addToCartButtons.get(1));
        clickElement(this.addToCartButtons.get(2));
        setShoppingCartBadge();
    }

}
