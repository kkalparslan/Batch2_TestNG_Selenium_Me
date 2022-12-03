package com.krafttechnologie.tests.day19_reviewAndXmlRunner;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    @Test
    public void userInfo() {
        /** Class Task
         * go to https://www.krafttechexlab.com/login web site
         * Login as a user
         * Verify that login is successful with account name
         * Click on My profile
         * Click on Edit Profile
         * Verify that email value
         * navigate back
         * Verify that Dashboard page with url
         */

        LoginPages loginPages = new LoginPages();
        DashboardPage dashboardPage=new DashboardPage();
        ProfilePage profilePage=new ProfilePage();

        extentLogger = report.createTest("User Info Verification Test");
        extentLogger.info("Login as a user");
        loginPages.loginUser();

        String expectedAccountName="Alparslan ";
        extentLogger.info("Verify that login is successful and account name is"+expectedAccountName);
        String actualAccountName=loginPages.getAccountName_mtd(expectedAccountName);
        //String actualAccount = driver.findElement(By.xpath("//span[.='Alican']")).getText();
        System.out.println("actualAccount = " + actualAccountName);
        System.out.println("expectedAccount = " + expectedAccountName);
        Assert.assertEquals(actualAccountName, expectedAccountName, "FAIL");

        extentLogger.info("Click on My profile");
        dashboardPage.myProfile_loc.click();

        extentLogger.info("Click on Edit Profile");
        profilePage.profileTabs("Edit Profile");


        String expectedEmail="alp@gmail.com";
        System.out.println("expectedEmail = " + expectedEmail);
        extentLogger.info("Verify that email values is " + expectedEmail);
        Assert.assertEquals(profilePage.profilEmail_loc.getAttribute("value"),expectedEmail);
        String actualEmail=profilePage.profilEmail_loc.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        extentLogger.info("navigate back");
        driver.navigate().back();

        extentLogger.info("Verify that Dashboard page with url");
        Assert.assertEquals(driver.getCurrentUrl()
                ,"https://www.krafttechexlab.com/index");
        extentLogger.pass("PASSED");


    }


}
