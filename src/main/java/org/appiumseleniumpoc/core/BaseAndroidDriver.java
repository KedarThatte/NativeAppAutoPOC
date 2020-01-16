package org.appiumseleniumpoc.core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.appiumseleniumpoc.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Kedar Thatte
 */

public class BaseAndroidDriver extends Config {

    //protected AndroidDriver driver;
    protected AppiumDriverLocalService service;
    WebDriverWait wait;

    @BeforeClass
    public void openAUT() throws MalformedURLException {

        File appDir = new File(System.getProperty("user.dir")+ File.separator+"src"+File.separator+
                "main"+File.separator+"resources"+File.separator+"apks"+File.separator+"AEandAerie_com.ae.ae.apk");
        DesiredCapabilities cap = new DesiredCapabilities();

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4725));
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","8");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app",appDir.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4725/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.id("com.ae.ae:id/txt_full_access")).isDisplayed();
        driver.findElement(By.id("com.ae.ae:id/txt_full_access")).click();
        driver.findElement(By.id("com.ae.ae:id/disable")).isDisplayed();
        driver.findElement(By.id("com.ae.ae:id/disable")).click();
        Assert.assertTrue(driver.findElement(By.xpath(".//android.widget.TextView[@text='Shop']")).isDisplayed());
        System.out.println("AUT Start Success!");
        Reporter.log("AUT Start Success!");
    }

    @AfterClass
    public void closeAUT()throws Exception{

        driver.quit();
        service.stop();
        System.out.println("AUT Stop Success!");
        Reporter.log("AUT Stop Success!");

    }

    /*@Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        if (iTestResult.getThrowable() != null) {
            this.saveScreenshot(iTestResult.getName(), driver);
        }
    }*/

    public void verticalScroll(String path) {
        Dimension size = driver
                .findElement(By.xpath(config.getProperty(path))).getSize();
        System.out.println(size);
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
    public void verticalScrollProductPage() {
        Point color = driver.findElement(By.id("com.ae.ae:id/product_status")).getLocation();
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * 0.50);
        int startPoint = (int) (size.height * 0.80);
        int endPoint = (int) (size.height * 0.20);
        new TouchAction(driver)
                .longPress(PointOption.point(color.x,color.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(anchor, endPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release().perform();
    }
}
