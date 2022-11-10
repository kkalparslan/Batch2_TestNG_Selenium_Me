package com.krafttechnologie.tests.day07_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("First Test Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2(){
        System.out.println("Second Test Assertion");
        Assert.assertEquals("test2","test2");
    }

    @Test
    public void test3(){
        String expectedTitle="Kraft";
        String actualTitle="Kraftech";

        Assert.assertTrue(actualTitle.contains(expectedTitle),"hatanın sebebi");
    }
    @Test
    public void test4(){
        // verify that contains @ sign
        String email="kraftTech@gmail.com";
//        if (email.contains("@")){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAILED");
//        }
        Assert.assertTrue(email.contains("@"));
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that = is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("two","one");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
}
