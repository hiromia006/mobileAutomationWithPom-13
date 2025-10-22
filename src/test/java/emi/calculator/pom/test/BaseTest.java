package emi.calculator.pom.test;

import emi.calculator.pom.screens.BaseScreen;
import emi.calculator.pom.screens.Screen;
import emi.calculator.pom.util.EmiCalculatorUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    private Properties prop;
    AndroidDriver driver;
    Screen scn;

    public BaseTest() {

    }

    @BeforeClass
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:udid", "127.0.0.1:6555");
        caps.setCapability("appium:platformVersion", "13");
        caps.setCapability("appium:appPackage", "com.continuum.emi.calculator");
        caps.setCapability("appium:appActivity", "com.finance.emicalci.activity.Splash_screnn");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EmiCalculatorUtil.WAIT_TIME));

            driver.startRecordingScreen();
            scn = new BaseScreen(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }


    @AfterClass
    public void tearDown() {
        recordingVideo();
        driver.quit();
    }

    public void takeScreenshot(String name) {
        try {
            File scrFile = (driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            File destFile = new File(currentDir + name + "_" + System.currentTimeMillis() + ".png");
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(scrFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot: " + e.getMessage(), e);
        }
    }

    public AndroidDriver getWebDriver() {
        return driver;
    }

    private void recordingVideo() {
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/build/videos/";
        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
