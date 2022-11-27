package com.krafttechnologie.tests.day18_ExtentReport;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    @Test
    public void LoginTest1() {

        LoginPages loginPages=new LoginPages();
        extentLogger=report.createTest("Test1");
        loginPages.loginUser();
        System.out.println("1");

    }

    @Test
    public void LoginTest2() {

        LoginPages loginPages=new LoginPages();
        extentLogger=report.createTest("Test2");
        loginPages.loginUser();
        System.out.println("2");

    }
}
