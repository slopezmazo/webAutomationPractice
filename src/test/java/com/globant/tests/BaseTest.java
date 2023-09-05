package com.globant.tests;

import com.globant.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.globant.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.lang.String.format;

public class BaseTest extends Reporter {

    protected static WebDriver driver;
    protected LogInPage LogInPage;
    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){
        logInfo("### Web driver manager setup ###");
        WebDriverManager.chromedriver().setup();
    }
    @Parameters({"url","username","password"})
    @BeforeSuite(alwaysRun = true)
    public void testSetup(String url,String username, String password){
        logInfo("Starting new Chrome driver session...");
        driver = new ChromeDriver();
        logInfo(format("Navigating to %s", url));
        driver.get(url);
        driver.manage().window().maximize();
        LogInPage = new LogInPage(driver);
        LogInPage.typeUsername(username);
        LogInPage.typePassword(password);
        LogInPage.clickLoginButton();
    }

//    @AfterSuite(alwaysRun = true)
//    public void teardown(){
//        logInfo("Closing Chrome driver session...");
//        driver.quit();
//    }
}
