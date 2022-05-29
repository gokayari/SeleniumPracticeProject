package com.cydeo.tests.day8_properties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTableUtils2 {

    //Method #1 info:
    //• Name: returnState ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String customerName
    //This method should accept a costumerName and return the customer order date as a String.

    public static String returnState(WebDriver driver, String customerName){


        /*
        String locator = "//td[.='" + customerName + "']/following-sibling::td[6]";
        WebElement customerStateCell = driver.findElement(By.xpath(locator));
        String state = customerStateCell.getText();
        return state;
        */
        return driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[6]")).getText();
    }
}
