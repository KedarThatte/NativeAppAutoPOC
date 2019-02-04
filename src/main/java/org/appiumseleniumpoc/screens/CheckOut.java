package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kedar Thatte
 */
public class CheckOut {

    AndroidDriver driver;
    WebDriverWait wait;

    @FindBy(id = "com.ae.ae:id/order_button")
    WebElement checkoutbtn;

    @FindBy(id = "com.ae.ae:id/btn_place_order")
    WebElement placeorderbtn;

    @FindBy(id = "com.ae.ae:id/md_buttonDefaultNegative")
    WebElement ratingnotnow;

    public CheckOut(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }

    @Step
    public void checkOutProduct(){
        wait.until(ExpectedConditions.visibilityOf(checkoutbtn)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(checkoutbtn)).click();
    }
    @Step
    public void placeOrder(){
        wait.until(ExpectedConditions.visibilityOf(placeorderbtn)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(placeorderbtn)).click();
    }
    @Step
    public void setRatingnotnow(){
        wait.until(ExpectedConditions.visibilityOf(ratingnotnow)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(ratingnotnow)).click();
    }



}
