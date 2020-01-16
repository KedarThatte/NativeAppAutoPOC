package org.appiumseleniumpoc.tests;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.appiumseleniumpoc.core.BaseAndroidDriver;
import org.appiumseleniumpoc.listeners.TestListener;
import org.appiumseleniumpoc.screens.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Kedar Thatte
 */
@Listeners({TestListener.class})
public class Apptest extends BaseAndroidDriver {

    @Test(description = "Search a Product in the APP")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search a Product in the APP")
    public void searchAProduct(){
        AppNavigation appnav=new AppNavigation((AndroidDriver) driver);
        appnav.openSearch();
        appnav.searchProduct(config.getProperty("searchtext"));
        Assert.assertTrue(driver.findElement(By.xpath(".//android.widget.TextView[@text='"+config.getProperty("selectfromsearch")+"']")).isDisplayed());
        Reporter.log("Product Suggestions shown");
    }

    @Test(dependsOnMethods = {"searchAProduct"},description = "Product Catalog is Displayed after clicking product category from suggestions")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Product Catalog is Displayed after clicking product category from suggestions")
    public void openProductCatalog(){
        AppNavigation appnav=new AppNavigation((AndroidDriver) driver);
        appnav.openSearchResult(config.getProperty("selectfromsearch"));
        Catalog catalog=new Catalog(driver);
        Assert.assertTrue(catalog.productCatalogDisplayed());
        Reporter.log("Catalog Open");
    }
    @Test(dependsOnMethods = {"openProductCatalog"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Product Page from the app is opened")
    public void selectAProductFromCatalog() throws InterruptedException{
        Catalog catalog = new Catalog(driver);
        while(catalog.findProdInCatalog()){
            verticalScroll("Catalog");
            if(!catalog.findProdInCatalog()){
                break;
            }
        }
        catalog.openAppProdPage();
        Assert.assertEquals(driver.findElement(By.id("com.ae.ae:id/toolbar_title")).getText(),"Original Straight Jean");
    }

    @Test(dependsOnMethods = {"selectAProductFromCatalog"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Product size is selected and it is added to bag")
    public void selectProductAddToBag(){
        ProductPage productPage = new ProductPage((AndroidDriver)driver);
        while (productPage.sizeSelectorInvisible()) {
            verticalScrollProductPage();
        }if (!productPage.sizeSelectorInvisible()){
            productPage.openSizes();
        }
        productPage.selectSize();
        productPage.addToBag();
        AppNavigation appnav = new AppNavigation((AndroidDriver) driver);
        Assert.assertEquals(String.valueOf(appnav.getBagCount()),"1");
    }
    @Test(dependsOnMethods = {"selectProductAddToBag"},description = "Login and Order Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login and Order Product")
    public void loginAndOrder() throws InterruptedException {
        AppNavigation appnav = new AppNavigation((AndroidDriver) driver);
        appnav.openBag();
        driver.findElement(By.id("com.ae.ae:id/txt_sign_in")).click();
        SignIn signIn = new SignIn((AndroidDriver) driver);
        signIn.signInAUT(config.getProperty("useremail"),config.getProperty("password"));
        driver.findElement(By.xpath(".//android.widget.Button[@text='CHECKOUT']")).click();
        driver.findElement(By.id("com.ae.ae:id/md_buttonDefaultNegative")).click();
        Assert.assertTrue(driver.findElement(By.id("com.ae.ae:id/thank_you_label")).getText().equalsIgnoreCase("Thank you for your order!"));
        /*driver.findElement(By.id("com.ae.ae:id/payment_security_code")).click();
        driver.findElement(By.id("com.ae.ae:id/payment_security_code")).sendKeys("123");*/
    }
}
