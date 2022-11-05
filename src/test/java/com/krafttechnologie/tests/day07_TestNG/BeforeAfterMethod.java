package com.krafttechnologie.tests.day07_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @BeforeClass
    public void setUpClass() {
        System.out.println("-----Before class------");
    }

    @Test
    public void test1() {
        System.out.println("First test case");
    }

    @Test
    @Ignore
    public void test2() {
        System.out.println("Second test case ");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method");
    }

    @Test
    public void test3() {
        System.out.println("Third test case");
    }

    // @Test
    public void comment() {
        System.out.println("Test case comment");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("-------After class--------");
    }
}
