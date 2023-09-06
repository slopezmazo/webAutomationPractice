package com.globant.tests;

import com.globant.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import com.globant.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.lang.String.format;

public class BaseTest extends Reporter {

    protected static WebDriver driver;
    protected LoginPage LoginPage;


    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){
        logInfo("### Web driver manager setup ###");
        WebDriverManager.chromedriver().setup();
    }
    @Parameters({"url","username","password"})
    @BeforeMethod(alwaysRun = true)
    public void testSetup(String url,String username, String password){
        logInfo("Starting new Chrome driver session...");
        driver = new ChromeDriver();
        logInfo(format("Navigating to %s", url));
        driver.get(url);
        driver.manage().window().maximize();
        LoginPage = new LoginPage(driver);
        logInfo("login page initialized successfully");
        LoginPage.typeUsername(username);
        LoginPage.typePassword(password);
        LoginPage.clickLoginButton();
        logInfo("login succeed");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        logInfo("Closing Chrome driver session...");
        driver.quit();
    }
}
