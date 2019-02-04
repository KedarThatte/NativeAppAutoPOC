package org.appiumseleniumpoc.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

/**
 * @author Kedar Thatte
 */
public class Config {

    public static Properties config;
    public static AppiumDriver driver;
    protected WebDriverWait wait;
    private String testCaseName;
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String testFailedMsg;

    public WebDriver getDriver() {
        return driver;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
    }


    @BeforeSuite
    public void loadConfigData(){
        config = new Properties();
        try {
            config.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Config load Success!");
    }

    public void verticalScroll(String type) {
        Dimension size = driver
                .findElement(By.xpath(config.getProperty(type))).getSize();
        //Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * 0.50);
        int startPoint = (int) (size.height * 0.80);
        int endPoint = (int) (size.height * 0.20);

        new TouchAction(driver)
                .longPress(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(anchor, endPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release().perform();
    }

    public void verticalScrollHomePage() {
        Dimension size = driver
                .findElement(By.xpath(config.getProperty("HomePage"))).getSize();
        //Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * 0.50);
        int startPoint = (int) (size.height * 0.80);
        int endPoint = (int) (size.height * 0.20);

        new TouchAction(driver)
                .longPress(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(anchor, endPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release().perform();
    }
    public void verticalScrollProdCategory() {
        Dimension size = driver
                .findElement(By.xpath(config.getProperty("ProdCategory"))).getSize();
        //Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * 0.50);
        int startPoint = (int) (size.height * 0.80);
        int endPoint = (int) (size.height * 0.20);

        new TouchAction(driver)
                .longPress(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(anchor, endPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release().perform();
    }




}
