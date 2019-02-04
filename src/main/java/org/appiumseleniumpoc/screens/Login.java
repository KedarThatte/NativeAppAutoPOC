package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.appiumseleniumpoc.core.BaseAndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class Login  {

    AndroidDriver driver;
    WebDriverWait wait;
    Properties config;

    public Login(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    @Step
    public void loginToTheApplication(String email,String passwd) throws InterruptedException{
        /*AppNavigation appnav = new AppNavigation((AndroidDriver) driver);
        appnav.gotoLoginPage();*/
        SignIn signin = new SignIn((AndroidDriver) driver);
        driver.findElement(By.xpath(".//android.widget.TextView[@text='Sign In']")).isDisplayed();
        signin.enterUserEmail(email);
        signin.enterPassword(passwd);
        signin.clickSignIn();
        /*Assert.assertEquals("Shop",driver.findElement(By.xpath(".//android.widget.TextView[@text='Shop']")).getText());
        Reporter.log("User logged in successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.ae.ae:id/order_button"))).isDisplayed();*/
    }
}
