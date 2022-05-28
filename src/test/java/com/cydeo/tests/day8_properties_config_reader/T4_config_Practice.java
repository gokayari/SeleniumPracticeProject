package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T4_config_Practice {

    //TC #4: Google search

    //after creating Driver utility class we do not need this lines:
    /*
    WebDriver driver;

    //1- Open a Chrome browser
    //2- Go to: https://google.com
    @BeforeMethod
    public void setupMethod(){
        //We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);

        //driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    */
    @Test
    public void google_search_test(){
        //After creating Drive Utility: Driver.getDriver() --> driver

        //driver.get("https://google.com"); //after creating Driver utility class we do not need this line
        Driver.getDriver().get("https://google.com");

        //driver.findElement(By.xpath("//div[.=\"Ich stimme zu\"]")).click();
        Driver.getDriver().findElement(By.xpath("//div[.=\"Ich stimme zu\"]")).click();


        //3- Write “apple” in search box
                                                            //or: //input[@name="q"]
        //WebElement searchBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@type=\"text\"]"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:

        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Google Suche";     //"apple" + " - Google Suche";
        //String actualTitle = driver.getTitle();
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @AfterMethod
    public void teardownMethod(){
        HandleWait.staticWait(1);
        //driver.close();
        Driver.getDriver().close();
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