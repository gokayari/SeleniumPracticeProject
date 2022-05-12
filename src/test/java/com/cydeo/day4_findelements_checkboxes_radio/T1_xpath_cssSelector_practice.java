package com.cydeo.day4_findelements_checkboxes_radio;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {

    public static void main(String[] args) {

        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //b. “Forgot password” header
        WebElement header = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //Locate header using cssSelector: locate parent element and move down to h2
        WebElement header_1 = driver.findElement(By.cssSelector("div.example > h2"));

        //c. “E-mail” text
        WebElement eMailText = driver.findElement(By.cssSelector("label[for='email']"));

        //d. E-mail input box
        WebElement eMailBox = driver.findElement(By.xpath("//input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$']"));
        //tagName[contains(@attribute,'value')]
        WebElement eMailBox_1 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

        //e. “Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.cssSelector("button#form_submit"));
        WebElement retrievePassword_1 = driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("header.isDisplayed() = " + header.isDisplayed());
        System.out.println("eMailText.isDisplayed() = " + eMailText.isDisplayed());
        System.out.println("eMailBox.isDisplayed() = " + eMailBox.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        HandleWait.staticWait(2);
        driver.close();

    }
}
