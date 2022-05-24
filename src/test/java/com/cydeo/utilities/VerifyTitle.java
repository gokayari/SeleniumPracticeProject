package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerifyTitle {

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
/*
1. Create a new method for title verification
2. Create a method to make title verification logic re-usable
3. When method is called, it should simply verify expected title with actual
title
Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle
 */