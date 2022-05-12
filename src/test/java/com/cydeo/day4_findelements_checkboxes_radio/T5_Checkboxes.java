package com.cydeo.day4_findelements_checkboxes_radio;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_Checkboxes {

    public static void main(String[] args) {

        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/checkboxes");

        //We have to locate checkboxes
        WebElement checkBox1 = driver.findElement(By.cssSelector("input[name='checkbox1']"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[name='checkbox2']"));

        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkBox1.isSelected(), expecting is false = " + checkBox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkBox2.isSelected(), expecting is true  = " + checkBox2.isSelected());

        //4. Click checkbox #1 to select it.
        HandleWait.staticWait(2);
        checkBox1.click();

        //5. Click checkbox #2 to deselect it.
        HandleWait.staticWait(2);
        checkBox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkBox1.isSelected(), expecting is TRUE = " + checkBox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkBox2.isSelected(), expecting is FALSE  = " + checkBox2.isSelected());

        HandleWait.staticWait(2);
        driver.close();
    }
}
