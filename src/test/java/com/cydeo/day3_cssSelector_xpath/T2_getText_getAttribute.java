package com.cydeo.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedRememberMeLabel = "Remember me on this computer";
        WebElement rememberMe = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMe.getText();
        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("\'Remember me\' label verification is PASSED!");
        }else{
            System.out.println("\'Remember me\' label verification is FAILED!!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedForgotPasswordLink = "Forgot your password?";
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLink = forgotPassword.getText();

        System.out.println("expectedForgotPasswordLink = " + expectedForgotPasswordLink);
        System.out.println("actualForgotPasswordLink = " + actualForgotPasswordLink);

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)){
            System.out.println("\'Forgot password\' link verification is PASSED!");
        }else{
            System.out.println("\'Forgot password\' link verification is PASSED!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String actualHrefValue = forgotPassword.getAttribute("href");
        System.out.println(actualHrefValue);

        if (actualHrefValue.contains(expectedInHref)){
            System.out.println("\'HREF attribute value\' verification is PASSED!");
        }else{
            System.out.println("\'HREF attribute value\' verification is FAILED!!");
        }


        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
