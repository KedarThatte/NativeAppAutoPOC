package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Kedar
 */
public class ProductPage {

    AndroidDriver driver;
    WebDriverWait wait;
    String size=null;

    @FindBy(id = "com.ae.ae:id/pickSizeBtn")
    WebElement sizeselector;

    @FindBy(xpath = ".//android.widget.TextView[@resource-id='com.ae.ae:id/size_label']")
    WebElement sizes;

    @FindBy(id = "com.ae.ae:id/add_to_bag_textView")
    WebElement addtobag;

    public ProductPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,30);
    }
    @Step
    public boolean sizeSelectorDisplayed(){
        if(sizeselector.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    @Step
    public boolean sizeSelectorInvisible(){
        try{
            sizeselector.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
        return false;
    }
    @Step
    public void openSizes(){
        wait.until(ExpectedConditions.visibilityOf(sizeselector)).click();
        wait.until(ExpectedConditions.visibilityOf(sizes));
    }
    @Step
    public void selectSize(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@text = '30 X 30']"))).click();
        //Assert.assertEquals("30 X 30",sizeselector.getText());
    }
    @Step
    public void addToBag(){
        wait.until(ExpectedConditions.visibilityOf(addtobag)).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ae.ae:id/bagcount"))).getText().equalsIgnoreCase("1"));
    }


}
