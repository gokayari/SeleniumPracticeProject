package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {

    public static void main(String[] args) {

        //open Chrome browser:
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        HandleWait.staticWait(1);
        //then click on "forgot_password" link
        /*
        2 ways of using webElements: "long way or lazy way"
         */
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        //enter any email
        HandleWait.staticWait(1);
        WebElement emailBox = driver.findElement(By.name("email"));
        //emailBox.sendKeys("mike.smith@garbage.com");  //option1

        String expectedEmail = "mike.smith@garbage.com";

        emailBox.sendKeys(expectedEmail);   //option2


        //verify that email is displayed in the input box

        // String actualEmail = emailBox.getText(); // let's see if it works?
        // not in the text of the element, it is at the 'value' attribute of the webElement
        String actualEmail = emailBox.getAttribute("value"); // let's see if it works?

        // verify the test
        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("PASS email verification");
        }else {
            System.out.println("FAILED email verification");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }
// click on Retrieve password
        // use id
        // driver.findElement(By.id("form_submit")).click();

        // use CSS
        //  driver.findElement(By.cssSelector("#form_submit")).click();

        // using tagName locator, since it is the only one : //button
        //  driver.findElement(By.tagName("//button")).click();

        // use Retrieve word to locate with XPATH : //i[contains(text(),'Retrieve')]
        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();


        HandleWait.staticWait(1);
        // close or quit the page
        driver.close();
    }
}
