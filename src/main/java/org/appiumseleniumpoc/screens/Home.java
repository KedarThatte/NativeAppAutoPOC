package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kedar Thatte
 */
public class Home {

    AndroidDriver driver;
    WebDriverWait wait;

    /*@FindBy(id="com.ae.ae:id/action_search")
    WebElement searchicon*/

    public Home(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,5);
    }
}
