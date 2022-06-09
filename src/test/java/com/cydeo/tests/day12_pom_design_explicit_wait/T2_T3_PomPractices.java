package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_T3_PomPractices {

    LibraryLoginPage libraryLoginPage;
    Faker faker;

    @Test
    public void t2_invalidEmail_errorMessage(){
        //TC #2: Invalid email format error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        HandleWait.staticWait(1);
        //3- Enter invalid email format
        libraryLoginPage = new LibraryLoginPage();

        faker = new Faker();

        libraryLoginPage.inputUsername.sendKeys(faker.name().firstName());
        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        String expectedErrorMessage = "Please enter a valid email address.";
        String actualErrorMessage = libraryLoginPage.enterValidEmailErrorMessage.getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        //Expected: Please enter a valid email address.
        //NOTE: FOLLOW POM DESIGN PATTERN
        Driver.closeDriver();
    }

    @Test
    public void t3_library_negativeLogin(){
        //TC #3: Library negative login
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        HandleWait.staticWait(1);

        //3- Enter incorrect username or incorrect password
        libraryLoginPage = new LibraryLoginPage();

        faker = new Faker();

        libraryLoginPage.inputUsername.sendKeys(faker.name().firstName() + "@" + faker.name().lastName());
        libraryLoginPage.inputPassword.sendKeys(faker.bothify("##??##"));

        HandleWait.staticWait(1);

        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        String expectedErrorMessage = "Sorry, Wrong Email or Password";
        String actualErrorMessage = libraryLoginPage.wrongEmailOrPasswordErrorMessage.getText();

        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        System.out.println("actualErrorMessage = " + actualErrorMessage);

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        Driver.closeDriver();

        //Expected: Sorry, Wrong Email or Password NOTE: FOLLOW POM DESIGN PATTERN
    }
}
