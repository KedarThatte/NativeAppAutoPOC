package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.appiumseleniumpoc.core.BaseAndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy( xpath = ".//android.widget.TextView[@text='Sign In']")
    WebElement signInPageHeader;

    public Login(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
    }


    public void loginToTheApplication() throws InterruptedException{
        /*AppNavigation appnav = new AppNavigation((AndroidDriver) driver);
        appnav.gotoLoginPage();*/
        wait.until(ExpectedConditions.visibilityOf(signInPageHeader)).isDisplayed();
        SignIn signin = new SignIn(driver);
        signin.enterUserEmail(config.getProperty("useremail"));
        signin.enterPassword(config.getProperty("password"));
        signin.clickSignIn();
        Assert.assertEquals("Shop",driver.findElement(By.xpath(".//android.widget.TextView[@text='Shop']")).getText());
        Reporter.log("User logged in successfully");
    }
    public void checkSignIn(){
        wait.until(ExpectedConditions.visibilityOf(signInPageHeader)).isDisplayed();
    }
}
