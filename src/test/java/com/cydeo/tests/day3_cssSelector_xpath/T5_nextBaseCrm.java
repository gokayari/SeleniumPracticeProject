package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_nextBaseCrm {

    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        HandleWait.staticWait(1);
        //3- Enter incorrect username into login box:
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("incorrect");

        HandleWait.staticWait(1);
        //4- Click to `Reset password` button
        WebElement passwordButton = driver.findElement(By.xpath("//button[@class='login-btn']"));
        passwordButton.click();                                 // "//div/div/form/div[4]/button"

        HandleWait.staticWait(1);
        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        String expectedLogin = "Login or E-mail not found";
        String actualText = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
                                                                    //right click>copy xPath
        System.out.println("actualText = " + actualText);
        System.out.println("expectedLogin = " + expectedLogin);

        HandleWait.staticWait(2);
        driver.close();

    }
}
