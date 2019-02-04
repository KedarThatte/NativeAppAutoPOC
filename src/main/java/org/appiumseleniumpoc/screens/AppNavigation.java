package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kedar Thatte
 */
public class AppNavigation {

    AndroidDriver driver;
    WebDriverWait wait;


    @FindBy(id = "com.ae.ae:id/action_search")
    WebElement searchicon;

    @FindBy(id = "com.ae.ae:id/suggestion_activity_search")
    WebElement searchbox;

    @FindBy(id = "com.ae.ae:id/top_bar")
    WebElement topbar;

    @FindBy(id = "com.ae.ae:id/product_suggestion_list")
    WebElement productsuggestions;

    @FindBy(xpath = ".//android.widget.ImageButton[@content-desc='Show menu']")
    WebElement hambergermenu;

    @FindBy(xpath = ".//android.widget.TextView[(@resource-id='com.ae.ae:id/titleTextView') and (@text='Create an Account / Sign In')]")
    WebElement signin;

    @FindBy(id = "com.ae.ae:id/action_favorite")
    WebElement favourites;

    @FindBy(id = "com.ae.ae:id/shoppingBagImageView")
    WebElement bag;

    @FindBy(id = "com.ae.ae:id/bagcount")
    WebElement bagcount;

    @FindBy(xpath = ".//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement navigateback;

    public AppNavigation(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,5);
    }
    @Step
    public void visibleElement(WebElement e1){
        wait.until(ExpectedConditions.visibilityOf(e1)).isDisplayed();
    }
    @Step
    public void invisibleElement(WebElement e2){
        wait.until(ExpectedConditions.invisibilityOf(e2));
    }

    @Step
    public void openSearch(){
        visibleElement(searchicon);
        searchicon.click();
    }
    @Step
    public void searchProduct(String s1){
        visibleElement(searchbox);
        searchbox.sendKeys(s1);
        visibleElement(productsuggestions);
    }
    @Step
    public void openSearchResult(String s2){
        driver.findElement(By.xpath(".//android.widget.TextView[@text='"+s2+"']")).isDisplayed();
        driver.findElement(By.xpath(".//android.widget.TextView[@text='"+s2+"']")).click();
    }
    @Step
    public String getBagCount(){
        String count = wait.until(ExpectedConditions.visibilityOf(bagcount)).getText();
        return count;
    }
    @Step
    public void openBag(){
        wait.until(ExpectedConditions.visibilityOf(bag)).click();
    }
    @Step
    public void gotoLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(hambergermenu)).click();
        wait.until(ExpectedConditions.visibilityOf(signin)).click();
    }
}
