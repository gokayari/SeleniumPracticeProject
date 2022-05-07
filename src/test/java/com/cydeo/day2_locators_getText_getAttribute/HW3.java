package com.cydeo.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW3 {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3- Click to Gmail from top right.
        WebElement gmail = driver.findElement(By.className("gb_d"));
        gmail.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedInTitle)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google
        expectedInTitle = "Google";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedInTitle)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
