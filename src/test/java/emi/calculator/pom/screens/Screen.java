package emi.calculator.pom.screens;

import emi.calculator.pom.util.EmiCalculatorUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Screen {
    protected AndroidDriver driver;
    WebDriverWait wait;

    public Screen(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EmiCalculatorUtil.WAIT_TIME)); // Default wait time of 10 seconds
    }

    public abstract WebElement getWebElement(By locator);

    public abstract List<WebElement> getWebElements(By locator);

    public abstract String getElementText(By locator);

    public abstract void tapElement(By locator);

    public abstract void setWait(By locator);

    public <T extends BaseScreen> T goTo(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(AndroidDriver.class).newInstance(driver);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
