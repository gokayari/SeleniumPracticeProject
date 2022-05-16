package com.cydeo.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

WebDriver driver;

    @BeforeTest
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest(){
        //3. Verify “Simple dropdown” default selected value is correct

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdownText = currentlySelectedOption.getText();
        //Expected: “Please select an option”
        String expectedSimpleDropdownText = "Please select an option";

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);


        //4. Verify “State selection” default selected value is correct

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualStateDropdownText = stateDropdown.getFirstSelectedOption().getText();
        //Expected: “Select a State”
        String expectedStateDropdownText = "Select a State";

        Assert.assertEquals(actualStateDropdownText, expectedStateDropdownText);

        //shortway after line48:
        //Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), "Select a State");


        HandleWait.staticWait(1);
        driver.close();

    }
}
/*
TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values
 */