package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(id="user-name")
    private WebElement username;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(id="login-button")
    private WebElement logginButton;
    public LogInPage(WebDriver driver) {
        super(driver);
    }
    public void typeUsername(String username){
        typeText(this.username,username);
    }
    public void typePassword(String password){
        typeText(this.password,password);
    }
    public void clickLoginButton(){
        clickElement(this.logginButton);
    }

}
