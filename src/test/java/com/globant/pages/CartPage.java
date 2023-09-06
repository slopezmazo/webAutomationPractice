package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    @FindAll({
            @FindBy(css = ".cart_item button[id^=remove]") // Replace with the appropriate locator
    })
    private List<WebElement> RemoveButtonsFromCartButtons;
    @FindBy(id="checkout")
    private WebElement checkoutButton;
    @FindBy(className="cart_item")
    private List<WebElement> cartItemList;
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void removeCartElements(){
        for (WebElement removeButton:RemoveButtonsFromCartButtons){
            clickElement(removeButton);
        }
        RemoveButtonsFromCartButtons.clear();
    }
    public void clickCheckout(){
        clickElement(checkoutButton);
    }
    public Integer getCartItemsSize(){
        return cartItemList.size();
    }
}
