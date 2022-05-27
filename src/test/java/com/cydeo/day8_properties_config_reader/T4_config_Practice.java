package com.cydeo.day8_properties_config_reader;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_config_Practice {

    //TC #4: Google search
    WebDriver driver;

    //1- Open a Chrome browser
    //2- Go to: https://google.com
    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

        driver.findElement(By.xpath("//div[.=\"Ich stimme zu\"]")).click();
    }

    @Test
    public void google_search_test(){
        //3- Write “apple” in search box
                                                            //or: //input[@name="q"]
        WebElement searchBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        //4- Verify title:

        String expectedTitle = "apple - Google Suche";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @AfterMethod
    public void teardownMethod(){
        HandleWait.staticWait(1);
        driver.close();
    }

}
/*



Expected: apple - Google Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title assertion should not fail.
 */