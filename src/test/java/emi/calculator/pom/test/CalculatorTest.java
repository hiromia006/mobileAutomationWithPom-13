package emi.calculator.pom.test;

import emi.calculator.pom.screens.CalculatorScreen;
import emi.calculator.pom.screens.EmiDetailScreen;
import emi.calculator.pom.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {
    private CalculatorScreen calScn;

    @Test(priority = 0)
    public void calculateLoanAmountShould() {
        calScn = scn.goTo(LandingScreen.class)
                .tapOnEmiCalculator()
                .fillAmount(50000)
                .fillInterest(7)
                .fillYears(2)
                .fillMonths(5)
                .fillProcessingFee(2)
                .tapCalculate();
        Assert.assertTrue(calScn.hasEmiDetailButton());
        takeScreenshot("calculateLoanAmountShould");

    }

    @Test(priority = 1)
    public void resetLoanAmountV1Should() {
        calScn = calScn
                .tapReset();
        Assert.assertFalse(calScn.hasEmiDetailButton());
        takeScreenshot("resetLoanAmountV1Should");

    }

    @Test(priority = 2)
    public void resetLoanAmountV2Should() {
        calScn = calScn
                .fillAmount(50000)
                .fillInterest(7)
                .fillYears(2)
                .fillMonths(5)
                .fillProcessingFee(2)
                .tapCalculate();
        takeScreenshot("resetLoanAmountV2Should");
        Assert.assertTrue(calScn.hasEmiDetailButton());
    }


    @Test(priority = 3)
    public void checkDetailLoanAmountV2Should() {
        EmiDetailScreen detailScreen = calScn
                .fillAmount(50000)
                .fillInterest(7)
                .fillYears(2)
                .fillMonths(5)
                .fillProcessingFee(2)
                .tapCalculate()
                .tapViewDetails();
        takeScreenshot("checkDetailLoanAmountV2Should");
    }
}
