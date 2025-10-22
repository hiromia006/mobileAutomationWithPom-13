package emi.calculator.pom.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareLoansScreen extends BaseScreen {
    public CompareLoansScreen(AndroidDriver driver) {
        super(driver);
    }

    public CompareLoansScreen fillLaon1Amount(int amount) {
        WebElement element = getWebElement(By.id("etLoanAmount1"));
        element.clear();
        element.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoansScreen fillLaon2Amount(int amount) {
        WebElement element = getWebElement(By.id("etLoanAmount2"));
        element.clear();
        element.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoansScreen fillLaon1Interest(float interest) {
        WebElement element = getWebElement(By.id("etInterest1"));
        element.clear();
        element.sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoansScreen fillLaon2Interest(float interest) {
        WebElement element = getWebElement(By.id("etInterest2"));
        element.clear();
        element.sendKeys(String.valueOf(interest));
        return this;
    }


    public CompareLoansScreen fillLaon1Months(int months) {
        WebElement element = getWebElement(By.id("etPeriod1"));
        element.clear();
        element.sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoansScreen fillLaon2Months(int months) {
        WebElement element = getWebElement(By.id("etPeriod2"));
        element.clear();
        element.sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoansScreen tapCalculateBtn() {
        tapElement(By.id("btnCalculate"));
        return this;
    }

    public CompareLoansScreen tapResetBtn() {
        tapElement(By.id("btnReset"));
        return this;
    }

    public boolean isCompareLoansScreenDisplayed() {
        return getWebElements(By.id("monthly_emi_result_1")).size() > 0;
    }


}
