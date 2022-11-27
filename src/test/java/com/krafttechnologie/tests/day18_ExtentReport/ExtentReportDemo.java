package com.krafttechnologie.tests.day18_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    //this class is used for starting and building reports
    ExtentReports report;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this class define a test, enable adding logs , author and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report =new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath +"/test-output/report.html";

        //initialize the html report with the reportPath
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //initialize the html report with the reportPath
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("KraftTechB2 Smoke Test");

        //set environment information
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Alparslan Öztürk");
    }

    @Test
    public void test(){
        //give a name to the current test
        extentLogger=report.createTest("TC000 Login Test");

        //Test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to url https://www.krafttechexlab.com/login");
        extentLogger.info("Enter username");
        extentLogger.info("Enter password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify Logged in");
        extentLogger.info("TC001 Login Test is Passed");
    }

    @AfterMethod
    public void tearDown(){
        //this is when the report is actually created
        report.flush();
    }
}
