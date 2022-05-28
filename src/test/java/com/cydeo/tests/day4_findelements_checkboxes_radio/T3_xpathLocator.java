package com.cydeo.tests.day4_findelements_checkboxes_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T3_xpathLocator {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        //4. Verify text displayed is as expected: Expected: “Clicked on button one!”
        WebElement display1 = driver.findElement(By.xpath("//p[text()=\"Clicked on button one!\"]"));
        String expectedText = "Clicked on button one!";
        String actualText = display1.getText();

        if (actualText.equals(expectedText)){
            System.out.println("Text display verification PASSED!");
        }else{
            System.out.println("Text display verification FAILED!!");
        }

        driver.close();

    }
}
