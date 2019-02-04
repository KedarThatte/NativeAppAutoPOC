package org.appiumseleniumpoc.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

    AndroidDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = ".//TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    WebElement useremail;

    @FindBy(xpath = ".//TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    WebElement userpassword;

    @FindBy(id = "com.ae.ae:id/sign_in_text")
    WebElement signinbtn;

    @FindBy(id = "com.ae.ae:id/txt_forget_password")
    WebElement forgotpassword;

    @FindBy(id = "com.ae.ae:id/txt_create_an_account")
    WebElement createaccnt;

    public SignIn(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }

    public void enterUserEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(useremail)).sendKeys(email);
        //driver.findElement(By.xpath(".//*[@class='android.widget.EditText']")).sendKeys(email);

    }

    public void enterPassword(String passwd){
        wait.until(ExpectedConditions.visibilityOf(userpassword)).sendKeys(passwd);
        //driver.findElement(By.xpath(".//*[@class='android.widget.EditText']")).sendKeys(passwd);

    }
    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(signinbtn)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".///hierarchy/android.widget.Toast")));
    }
}