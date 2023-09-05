package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage{
    @FindBy(id="first-name")
    private WebElement firstName;
    @FindBy(id="last-name")
    private WebElement lastName;
    @FindBy(id="postal-code")
    private WebElement zipPostalName;
    @FindBy(id="continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }
    public void typeFirstName(String firstName){
        typeText(this.firstName,firstName);
    }
    public void typeLastName(String lastName){
        typeText(this.lastName,lastName);
    }
    public void typeZipPostalName(String zipPostalName){
        typeText(this.zipPostalName,zipPostalName);
    }
    public void clickContinueButton(){
        clickElement(continueButton);
    }

}
