package com.cydeo.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW4_practice_cydeo {

    public static void main(String[] args) {

        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement home = driver.findElement(By.className("nav-link"));
        home.click();

        //4- Verify title is as expected: Expected: Practice
        //PS: Locate “Home” link using “className” locator
        String expectedInTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedInTitle)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }

        driver.close();
    }
}
