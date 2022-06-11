package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {

    public DynamicLoad1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//button[.='Start']")
    public WebElement startButton;

    //@FindBy(css = "div#loading")
    @FindBy(xpath ="//div[@id='loading']")
    public WebElement loadingBar;

    //@FindBy(id = "username")
    //@FindBy(css = "#username")
    @FindBy(xpath ="//input[@name='username']")
    public WebElement usernameBox;

    //@FindBy(css = "#pwd")
    @FindBy(xpath ="//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath ="//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(id ="flash")
    public WebElement invalidErrorMessage;

}
