package com.krafttechnologie.tests.day17_POM3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {
    ProfilePage profilePage=new ProfilePage();
    DashboardPage dashboardPage=new DashboardPage();
    LoginPage loginPage =new LoginPage();
    /**
     * https://www.krafttechexlab.com/ sayfasina login olun, MyProfile gidin, Edit Profile Gidin,
     * Admin ve social Network harici tum islemleri yapin sonra save yapin
     */

    @Test
    public void editProfile(){
        loginPage.loginUser();
        dashboardPage.myProfile_loc.click();
        profilePage.profileTabs("Edit Profile");

        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Alican");


        profilePage.about.clear();
        profilePage.about.sendKeys("some words are here");

        profilePage.company.clear();
        profilePage.company.sendKeys("KRAFT");
        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"), 3);
        BrowserUtils.dragAndDropBy(profilePage.slider);

        Select select=new Select(profilePage.job);
        select.selectByVisibleText("QA Automation Engineer");

        profilePage.website.clear();
        profilePage.website.sendKeys("https://www.krafttechexlab.com/myprofile");

        profilePage.location.clear();
        profilePage.location.sendKeys("Kırıkkale");

        profilePage.skills.clear();
        profilePage.skills.sendKeys("TestNG, Cucumber");

        //profilePage.save.click();
        BrowserUtils.clickWithJS(profilePage.save);

    }

    @Test
    public void addExperience() throws InterruptedException {
        loginPage.loginUser();
        dashboardPage.myProfile_loc.click();
        profilePage.profileTabs("Add Experience");

        profilePage.jobTitle.clear();
        profilePage.jobTitle.sendKeys("QA Tester");

        profilePage.companyexperience.clear();
        profilePage.companyexperience.sendKeys("Kraft");

        profilePage.locationExperience.clear();
        profilePage.locationExperience.sendKeys("Ankara");

        profilePage.startYear.clear();
        profilePage.startYear.sendKeys("10/10/2022");

        profilePage.endYear.clear();
        profilePage.endYear.sendKeys("20/20/2023");

        profilePage.jobDescription.clear();
        profilePage.jobDescription.sendKeys("Cool workplace");

        profilePage.addExperienceBtn.click();
        BrowserUtils.waitFor(5);


    }
}
