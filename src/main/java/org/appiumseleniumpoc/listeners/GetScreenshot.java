package org.appiumseleniumpoc.listeners;

import org.apache.commons.io.FileUtils;
import org.appiumseleniumpoc.core.BaseAndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Kedar Thatte
 */
public class GetScreenshot extends BaseAndroidDriver {



    /*public String captureFailed(String TestClassname, String Screenshotname) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String datefolder = localDate.format(dtf);

        String dest=System.getProperty("user.dir")+File.separator +"target"+File.separator+"allure-results"+File.separator+"Screenshot"+File.separator+ datefolder+File.separator + "FailedScreenshot"+File.separator + TestClassname +File.separator+ Screenshotname + ".png";
        File destination=new File(dest);
        FileUtils.copyFile(source, destination);
        //System.out.println(dest);
        return dest;
    }

    public String capturePassed(String TestClassname, String Screenshotname) throws IOException{
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String datefolder = localDate.format(dtf);
        //String dest=System.getProperty("user.dir") + "/test-output/Screenshot/" + datefolder +"/PassedScreenshot/" + TestClassname +"/" + Screenshotname + ".png";
        String dest=System.getProperty("user.dir")+File.separator +"target"+File.separator+"allure-results"+File.separator+"Screenshot"+File.separator+ datefolder+File.separator + "PassedScreenshot"+File.separator + TestClassname +File.separator+ Screenshotname + ".png";
        File destination=new File(dest);
        FileUtils.copyFile(source, destination);
        //System.out.println(dest);
        return dest;
    }
*/

}
