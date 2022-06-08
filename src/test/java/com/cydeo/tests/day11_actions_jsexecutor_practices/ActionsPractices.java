package com.cydeo.tests.day11_actions_jsexecutor_practices;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void task_4_and_5_test() {
        //TC #4: Scroll practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //Create object of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());

        //Locating the Cydeo link to be able to pass in the actions method
        //                                                    xpath:  //a[@href='https://cydeo.com/']
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));


        HandleWait.staticWait(1);

        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).perform();

        //5- Scroll back up to “Home” link using PageUP button
        HandleWait.staticWait(1);

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();   //Keys.PAGE_UP means to go up a little


        //Driver.getDriver().quit();    //if we start new Test after this line: NoSuchSessionException
        Driver.closeDriver();

    }

    @Test
    public void newtTest1() {
        Driver.getDriver().get("https://practice.cydeo.com/");
    }

    @Test
    public void newtTest2() {
        Driver.getDriver().get("https://practice.cydeo.com/");
    }
}
