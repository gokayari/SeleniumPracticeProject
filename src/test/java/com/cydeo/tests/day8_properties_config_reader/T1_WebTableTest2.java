package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_WebTableTest2 {

    /*
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    */

    @Test
    public void T1_test(){

        Driver.getDriver().get("https://practice.cydeo.com/web-tables");


        String customer1_state = WebTableUtils2.returnState(Driver.getDriver(), "Ned Stark");

        String customer2_state = WebTableUtils2.returnState(Driver.getDriver(), "Samuel Jackson");


        String expectedState1 = "Italy";
        String expectedState2 = "US";

        System.out.println("customer1_state = " + customer1_state);
        System.out.println("customer2_state = " + customer2_state);


    }

    @AfterMethod
    public void tearDown(){
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        HandleWait.staticWait(1);
        Driver.getDriver().close();
    }
}
