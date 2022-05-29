package com.cydeo.tests.day8_properties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class T2_WebTableUtils2 {

    //Method #1 info:
    //• Name: returnState ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String customerName
    //This method should accept a costumerName and return the customers state as a String.

    public static String returnState(WebDriver driver, String customerName){


        /*
        String locator = "//td[.='" + customerName + "']/following-sibling::td[6]";
        WebElement customerStateCell = driver.findElement(By.xpath(locator));
        String state = customerStateCell.getText();
        return state;
        */
        return driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[6]")).getText();
    }

    //Method #2 info:
    //• Name: cityVerify ()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String customerName
    //• Arg3: String expectedCity
    //This method should accept above mentioned arguments and internally assert expectedCity matching actualCity.

    public static void cityVerify(WebDriver driver, String customerName, String expectedCity){
        String actualCity = driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[5]")).getText();

        Assert.assertEquals(actualCity, expectedCity);
    }



}
