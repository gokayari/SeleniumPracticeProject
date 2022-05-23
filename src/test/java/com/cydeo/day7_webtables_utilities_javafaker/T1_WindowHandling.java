package com.cydeo.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    //TC #1: Window Handle practice
    //1. Create new test and make setups
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void window_handling_test(){
        //2. Go to:https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy-paste the lines from below into your class
        //Lines to be pasted:
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);

            System.out.println("Current URL: "+ driver.getCurrentUrl());
            HandleWait.staticWait(1);

            //my practice:
            if (driver.getTitle().contains("Google")){
                driver.findElement(By.xpath("//div[.=\"Ich stimme zu\"]")).click();
            }else if(driver.getTitle().contains("Etsy")){
                driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();
                break;
            }else if(driver.getTitle().contains("Facebook")){
                driver.findElement(By.xpath("//button[text()=\"Nur erforderliche Cookies erlauben\"]")).click();
            }
            //--

            /*
            if (driver.getCurrentUrl().contains("Etsy")){
                break;
            }
            */
        }

        //5. Assert:Title contains “Etsy”

            String actualTitle = driver.getTitle();
            String expectedInTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    @AfterMethod
    public void teardownMethod(){
        HandleWait.staticWait(1);
        driver.close();
    }
}
/*




These lines will simply open new tabs using something called JavascriptExecutor and get those pages. We will learn JavascriptExecutor later as well.
 */