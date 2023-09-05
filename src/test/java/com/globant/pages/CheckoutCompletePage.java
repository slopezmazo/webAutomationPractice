package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{
    @FindBy(id="title")
    private WebElement title;
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    public String getTitle(){
        return title.getText();
    }
}
