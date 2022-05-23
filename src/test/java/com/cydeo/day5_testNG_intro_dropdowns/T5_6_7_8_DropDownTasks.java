package com.cydeo.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T5_6_7_8_DropDownTasks {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    //TC #5: Selecting state from State dropdown and verifying result
    @Test
    public void selectStatesTest(){

        Select dropdownStateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        HandleWait.staticWait(1);
        dropdownStateSelection.selectByValue("IL");
        //4. Select Virginia
        HandleWait.staticWait(1);
        dropdownStateSelection.selectByVisibleText("Virginia");
        //5. Select California
        HandleWait.staticWait(1);
        dropdownStateSelection.selectByIndex(5);
        //6. Verify final selected option is California.
        String expectedText = "California";
        String actualText = dropdownStateSelection.getFirstSelectedOption().getText();

        Assert.assertEquals(actualText,expectedText);
        //Use all Select options. (visible text, value, index)

    }

    //TC #6: Selecting date on dropdown and verifying
    @Test
    public void selectDateOfBirthTest(){

        //3. Select “December 1st, 1923” and verify it is selected.
        //Select year using : visible text Select month using : value attribute Select day using : index number

        Select dropdownDateOfBirthYear = new Select(driver.findElement(By.cssSelector("select[id='year']")));
        dropdownDateOfBirthYear.selectByVisibleText("1923");

        Select dropdownDateOfBirthMonth = new Select(driver.findElement(By.cssSelector("select[id='month']")));
        dropdownDateOfBirthMonth.selectByValue("11");

        Select dropdownDateOfBirthDay = new Select(driver.findElement(By.cssSelector("select[id='day']")));
        dropdownDateOfBirthDay.selectByIndex(0);

        String expectedText = "December 1st, 1923";
        String actualText = dropdownDateOfBirthMonth.getFirstSelectedOption().getText() + " "
                + dropdownDateOfBirthDay.getFirstSelectedOption().getText() + "st, " + dropdownDateOfBirthYear.getFirstSelectedOption().getText();
        System.out.println("actualText = " + actualText);

        Assert.assertEquals(actualText,expectedText);
    }

    //TC #7: Selecting value from non-select dropdown
    @Test
    public void task7Test(){
        //my solution:
        HandleWait.staticWait(1);
        //3. Click to non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        nonSelectDropdown.click();

        HandleWait.staticWait(1);
        //4. Select Facebook from dropdown
        WebElement nonSelectDropdownSelect = driver.findElement(By.xpath("//a[.='Facebook']"));
        nonSelectDropdownSelect.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook – Anmelden oder Registrieren";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


    }

    //TC #8: Selecting value from multiple select dropdown
    @Test
    public void task8Test(){
        //my solution:
        HandleWait.staticWait(1);
        //3. Select all the options from multiple select dropdown.

        Select selectLanguages = new Select(driver.findElement(By.cssSelector("select[name='Languages']")));
        for (int i = 0; i < 5; i++) {
            selectLanguages.selectByIndex(i);
            HandleWait.staticWait(1);
        }

        //4. Print out all selected values.
        List<WebElement> allOptions = selectLanguages.getOptions();
        for (WebElement each : allOptions) {
            System.out.println(each.getText());
        }

        HandleWait.staticWait(1);
        //5. Deselect all values.
        selectLanguages.deselectAll();

    }

    @AfterMethod
    public void tearDownMethod(){
        HandleWait.staticWait(1);
        driver.close();
    }
}
