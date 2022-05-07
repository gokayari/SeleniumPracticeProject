package com.cydeo.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2_zeroBank_verify {

    public static void main(String[] args) {

        //TC #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement header = driver.findElement(By.className("page-header"));
        System.out.println(header.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //=======================

        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("Gökay Ari");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("123456");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement signIn = driver.findElement(By.name("submit"));
        signIn.click();



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement alert = driver.findElement(By.xpath("//div[1]/div[2]/div/div/div/form/div[1]"));
        System.err.println(alert.getText());

        driver.close();

    }

}
