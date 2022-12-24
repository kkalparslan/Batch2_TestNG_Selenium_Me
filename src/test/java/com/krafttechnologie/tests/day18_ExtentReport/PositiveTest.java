package com.krafttechnologie.tests.day18_ExtentReport;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    @Test
    public void LoginTest1() {

        LoginPage loginPage =new LoginPage();
        extentLogger=report.createTest("Test1");
        loginPage.loginUser();
        System.out.println("1");

    }

    @Test
    public void LoginTest2() {

        LoginPage loginPage =new LoginPage();
        extentLogger=report.createTest("Test2");
        loginPage.loginUser();
        System.out.println("2");

    }
}
