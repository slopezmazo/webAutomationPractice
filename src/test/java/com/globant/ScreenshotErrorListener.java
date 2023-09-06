package com.globant;
import com.globant.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotErrorListener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        logError("Test failed! Capturing a screenshot...");
        captureScreenshot(result.getMethod().getMethodName());
    }
    private void captureScreenshot(String methodName) {
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = methodName + "_" + timeStamp + ".png";
            String screenshotDirectory = "errorScreenshots/";

            try {
                FileHandler.copy(screenshot, new File(screenshotDirectory + screenshotName));
                logInfo("Screenshot captured: " + screenshotName);
            } catch (IOException e) {
                logInfo("Failed to capture screenshot: " + e.getMessage());
            }
        } else {
            logInfo("Driver does not support taking screenshots.");
        }
    }
}
