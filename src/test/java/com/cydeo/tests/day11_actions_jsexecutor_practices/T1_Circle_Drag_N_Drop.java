package com.cydeo.tests.day11_actions_jsexecutor_practices;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {

    @Test
    public void test1CircleDrag(){
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Accept cookies:
        Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();

        HandleWait.staticWait(1);

        //Locate small and big circles to be able to drag them around
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        //2. Drag and drop the small circle to bigger circle.
        Actions actions = new Actions(Driver.getDriver());
        //option1:
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        //option2:
        actions.clickAndHold(smallCircle)
                .moveToElement(bigCircle)
                .release().perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualBigCircleText = bigCircle.getText();
        String expectedBigCircleText = "You did great!";

        Assert.assertEquals(actualBigCircleText, expectedBigCircleText);

    }

    @AfterMethod
    public void teardownMethod(){
        HandleWait.staticWait(2);
        Driver.getDriver().close();
    }


}
