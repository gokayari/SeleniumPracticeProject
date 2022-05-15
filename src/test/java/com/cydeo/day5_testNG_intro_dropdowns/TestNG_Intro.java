package com.cydeo.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setUpClass(){
        System.out.println("---> BeforeClass is running!");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> AfterClass is running!");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running!");
    }

    @Test
    public void test1() {
        System.out.println("Test 1 is running...");

        //ASSERT EQUALS: compare 2 of the same things
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is running...");
        //ASSERT TRUE
        String actual = "apple";
        String expected = "apple";

        Assert.assertTrue(actual.equals(expected));
    }

}
