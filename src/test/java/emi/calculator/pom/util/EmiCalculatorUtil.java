package emi.calculator.pom.util;

public class EmiCalculatorUtil {
    public static final int WAIT_TIME = 30;

    public static void waitForDomStable() {
        try {
            Thread.sleep(500); // Simple wait for demonstration purposes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}