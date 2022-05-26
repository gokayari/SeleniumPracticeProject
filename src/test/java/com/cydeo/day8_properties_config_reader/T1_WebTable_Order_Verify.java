package com.cydeo.day8_properties_config_reader;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    //TC #1: Web table practice

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Goto:https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test(){

        //2. VerifyBob’s name is listed as expected.            //or://table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]
        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.=\"Bob Martin\"]"));

        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();

        Assert.assertEquals(actualBobName, expectedBobName);

        //Expected: “Bob Martin”

        //3. VerifyBobMartin’s order date is as expected. Using "sibling" method
        WebElement orderDateCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.=\"Bob Martin\"]/following-sibling::td[3]"));

        System.out.println("orderDateCell.getText() = " + orderDateCell.getText());

        String expectedOrderDate = "12/31/2021";
        String actualOrderDate = orderDateCell.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

        //Expected: 12/31/2021

    }


    //We use the utility method we created
    @Test
    public void verify_test2(){

        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

        String customerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);
    }

    //We use WebTableUtils.orderVerify(); method
    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver, "Stewart Dawidson", "03/29/2021");

    }

    @AfterMethod
    public void teardownMethod(){
        HandleWait.staticWait(1);
        driver.close();
    }

}
