package com.globant.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    @FindBy(className = "title")
    protected WebElement title;
    protected WebElement shoppingCartBadge;
    @FindBy(css="#menu_button_container .bm-burger-button")
    protected WebElement menu;
    protected WebElement logoutButton;
    @FindBy(css="#shopping_cart_container .shopping_cart_link")
    private WebElement CartLink;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() { return driver; }
    public WebDriverWait getWait() { return wait; }

    public Actions getActions() { return  actions; }

    public void clickElement(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void typeText(WebElement element, String text){
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void chooseSelectOptionByValue(WebElement selectElement, String value){
        Select select = new Select(selectElement);
        select.selectByValue(value);
    }

    public void dismissAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }

    public void clickOnMenu(){
        clickElement(menu);
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        setLogoutButton(logoutButton);
    }

    public void setLogoutButton(WebElement e){
        this.logoutButton=e;
    }
    public void clickLogoutOption(){
        clickElement(logoutButton);
    }
    public String getTitle(){
        return title.getText();
    }
    public void setShoppingCartBadge() {
        this.shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
    }
    public String getShoppingCartBadge(){
        return this.shoppingCartBadge.getText();
    }
    public void clickOnCartLink() {
        clickElement(CartLink);
    }
}
