package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T3_WebTable_getEmail {

    //TC #3: Create a custom method
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/tables
    //3- Write custom method:
    //• Method name: getTableGetEmail()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String tableNum
    //• Arg3: String firstName

    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName){
        String locator = String.format("//table[@id=\"table%s\"]/tbody/tr/td[.='%s']/../td[3]", tableNum, firstName);
        System.out.println(driver.findElement(By.xpath(locator)).getText());
    }

    @Test
    public void T3_test(){
        Driver.getDriver().get("https://practice.cydeo.com/tables");
        getTableGetEmail(Driver.getDriver(), "2", "Doe");
    }
}