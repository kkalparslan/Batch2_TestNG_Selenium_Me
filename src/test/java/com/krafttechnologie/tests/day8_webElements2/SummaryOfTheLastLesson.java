package com.krafttechnologie.tests.day8_webElements2;

import org.testng.Assert;
import org.testng.annotations.*;

public class SummaryOfTheLastLesson {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before suıt runs");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test runs");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class runs");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method runs");
    }
    @Test
    public void test1(){
        Assert.assertTrue(5>2);
    }
    @Test
    public void test2(){
        Assert.assertFalse(3>5);
        Assert.assertFalse(1>2);
    }
    @Test
    public void test3(){
        Assert.assertEquals(1, 1);
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method runs");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class runs");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test runs");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("After Suit runs");
    }
}


