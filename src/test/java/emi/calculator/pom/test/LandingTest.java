package emi.calculator.pom.test;

import emi.calculator.pom.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest {
    LandingScreen landingScn;

    @Test(priority = 0)
    public void checkCalculatorButtonPresence() {
        landingScn = scn.goTo(LandingScreen.class);
        Assert.assertTrue(landingScn.hasEmiCalculatorButton());
    }

    @Test(priority = 1)
    public void checkCompareButtonPresence() {
        landingScn = scn.goTo(LandingScreen.class);
        Assert.assertTrue(landingScn.hasCompareLoansButton());
    }

}
