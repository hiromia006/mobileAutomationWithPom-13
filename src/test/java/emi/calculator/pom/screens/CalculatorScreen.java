package emi.calculator.pom.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorScreen extends BaseScreen {
    private By amountField = By.id("etLoanAmount");

    public CalculatorScreen(AndroidDriver driver) {
        super(driver);
    }

    public CalculatorScreen fillAmount(int amount) {
        WebElement element = getWebElement(amountField);
        element.clear();
        element.sendKeys(String.valueOf(amount));
        return this;
    }

    public CalculatorScreen fillInterest(float interest) {
        WebElement element = getWebElement(By.id("etInterest"));
        element.clear();
        element.sendKeys(String.valueOf(interest));
        return this;
    }

    public CalculatorScreen fillYears(int years) {
        WebElement element = getWebElement(By.id("etYears"));
        element.clear();
        element.sendKeys(String.valueOf(years));
        return this;
    }

    public CalculatorScreen fillMonths(int months) {
        WebElement element = getWebElement(By.id("etMonths"));
        element.clear();
        element.sendKeys(String.valueOf(months));
        return this;
    }

    public CalculatorScreen fillProcessingFee(int fee) {
        WebElement element = getWebElement(By.id("etFee"));
        element.clear();
        element.sendKeys(String.valueOf(fee));
        return this;
    }

    public CalculatorScreen tapCalculate() {
        tapElement(By.id("btnCalculate"));
        return this;
    }

    public CalculatorScreen tapReset() {
        tapElement(By.id("btnReset"));
        return this;
    }

    public EmiDetailScreen tapViewDetails() {
        tapElement(By.id("btnDetail"));
        return goTo(EmiDetailScreen.class);
    }

    public boolean hasAmountField() {
        return !getWebElements(amountField).isEmpty();
    }

    public boolean hasEmiDetailButton() {
        return !getWebElements(By.id("btnDetail")).isEmpty();
    }

}
