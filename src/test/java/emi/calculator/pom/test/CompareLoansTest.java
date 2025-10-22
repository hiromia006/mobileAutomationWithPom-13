package emi.calculator.pom.test;

import emi.calculator.pom.screens.CompareLoansScreen;
import emi.calculator.pom.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoansTest extends BaseTest {
    private CompareLoansScreen loansScreen;

    @Test(priority = 0)
    public void compareLoansShouldSucceed() {
        loansScreen = scn.goTo(LandingScreen.class)
                .tapOnCompareLoans()
                .fillLaon1Amount(100000)
                .fillLaon1Interest(10)
                .fillLaon1Months(10)
                .fillLaon2Amount(200000)
                .fillLaon2Interest(12)
                .fillLaon2Months(15)
                .tapCalculateBtn();
        Assert.assertTrue(loansScreen.isCompareLoansScreenDisplayed());
    }

    @Test(priority = 1)
    public void resetLoansV1ShouldSucceed() {
        loansScreen = loansScreen
                .tapResetBtn();
        Assert.assertFalse(loansScreen.isCompareLoansScreenDisplayed());
    }

    @Test(priority = 2)
    public void resetLoansV2ShouldSucceed() {
        loansScreen = loansScreen
                .fillLaon1Amount(100000)
                .fillLaon1Interest(10)
                .fillLaon1Months(10)
                .fillLaon2Amount(200000)
                .fillLaon2Interest(12)
                .fillLaon2Months(15)
                .tapCalculateBtn()
                .tapResetBtn();
        Assert.assertFalse(loansScreen.isCompareLoansScreenDisplayed());
    }
}
