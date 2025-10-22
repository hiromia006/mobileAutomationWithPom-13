package emi.calculator.pom.screens;

import com.aventstack.extentreports.Status;
import emi.calculator.pom.report.ReportTestManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseScreen extends Screen {
    public BaseScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By locator) {
        // Handle exception if the element is not found
        WebElement element = null;
        try {
            addInfo("Selenium Webdriver going to find a WebElement with " + locator + " Locator");

            element = driver.findElement(locator);
        } catch (Exception e) {
            addFailInfo("Selenium Webdriver is not found a Web Element with " + locator + " Locator");
            System.out.println("Element not found: " + locator);
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        // Handle exception if the elements are not found
        List<WebElement> elements = null;
        try {
            addInfo("Selenium Webdriver going to find a WebElements with " + locator + " Locator");
            elements = driver.findElements(locator);
        } catch (Exception e) {
            addFailInfo("Selenium Webdriver is not found a Web Elements with " + locator + " Locator");
            System.out.println("Elements not found: " + locator);
        }
        return elements;
    }

    @Override
    public String getElementText(By locator) {
        return getWebElement(locator).getText().trim();
    }

    @Override
    public void tapElement(By locator) {
        addInfo("Selenium Webdriver going to tap a WebElement with " + locator + " Locator");
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        addInfo("Selenium Webdriver tapped a WebElement with " + locator + " Locator");
    }

    @Override
    public void setWait(By locator) {
        addInfo("Selenium Webdriver is waiting for visibility of element with " + locator + " Locator");
        wait.until(ExpectedConditions.visibilityOf(getWebElement(locator)));
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }

    public void addFailInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }
}
