package emi.calculator.pom.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LandingScreen extends BaseScreen {
    private By emiCalculatorButton = By.id("btnStart");
    private By compareLoansButton = By.id("btnCompare");

    public LandingScreen(AndroidDriver driver) {
        super(driver);
    }

    public CalculatorScreen tapOnEmiCalculator() {
        tapElement(emiCalculatorButton);
        return goTo(CalculatorScreen.class);
    }

    public CompareLoansScreen tapOnCompareLoans() {
        tapElement(compareLoansButton);
        return goTo(CompareLoansScreen.class);
    }

    public boolean hasEmiCalculatorButton() {
        return getWebElements(emiCalculatorButton).size() > 0;
    }

    public boolean hasCompareLoansButton() {
        return getWebElements(compareLoansButton).size() > 0;
    }
}
