package com.krafttechnologie.tests.day16_POM2;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void navigateToTabAndModule() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.navigateToModele("Components", "Charts");

        String actualsubtitle= dashboardPage.subTitle("Charts");
        Assert.assertEquals(actualsubtitle, "Charts");


    }

    @Test
    public void getUser() throws InterruptedException {

        loginPages.loginUser();
        String actualUser=dashboardPage.UsersNames("Alpcan");
        System.out.println("actualUser = " + actualUser);
        String expectedUser="Alpcan";
        System.out.println("expectedUser = " + expectedUser);

        Assert.assertEquals(actualUser, expectedUser);

    }

    @Test
    public void myProfile() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.myProfile_loc.click();

    }

    @Test
    public void aFmTitle(){

        loginPages.loginUser();

        System.out.println("Title = " + dashboardPage.aFmTitle_loc.getText());

    }

    @Test
    public void copyRight(){

        loginPages.loginUser();
        System.out.println("dashboardPage.copyRight.getText() = " + dashboardPage.copyRight_loc.getText());

    }






}
