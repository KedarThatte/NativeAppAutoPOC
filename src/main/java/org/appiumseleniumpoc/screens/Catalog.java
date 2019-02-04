package org.appiumseleniumpoc.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.appiumseleniumpoc.utility.Scrolling;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kedar Thatte
 */
public class Catalog {

    AndroidDriver driver;
    WebDriverWait wait;

    @FindBy(id = "com.ae.ae:id/rv_product_list_content")
    WebElement catalogprodlist;

    @FindBy(xpath = ".//android.widget.LinearLayout")
    WebElement catalogprodcontainer;

    @FindBy(xpath = ".//*[(@resource-id='com.ae.ae:id/newAndOrOnline') and (@text='Customizable + Online Only')]")
    WebElement prodtypecustonlineonly;

    @FindBy(xpath = ".//*[(@resource-id='com.ae.ae:id/fullProductName') and (@text='Original Straight Jean')]")
    WebElement prodnamecatalogpage;



    public Catalog(AppiumDriver driver){
        this.driver= (AndroidDriver) driver;
        PageFactory.initElements(driver,this);
        Scrolling scrolling= new Scrolling((AndroidDriver) driver);
        wait = new WebDriverWait(driver,5);
    }
    @Step
    public void visibleElement(WebElement e1){
        wait.until(ExpectedConditions.visibilityOf(e1)).isDisplayed();
    }

    @Step
    public boolean productCatalogDisplayed(){
        if(catalogprodlist.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    @Step
    public boolean findProdInCatalog(){

            try{

              prodnamecatalogpage.isDisplayed();

            }catch (NoSuchElementException e){

                return true;
            }
            return false;
    }

    @Step
    public void openAppProdPage(){
        prodnamecatalogpage.click();

    }


}
