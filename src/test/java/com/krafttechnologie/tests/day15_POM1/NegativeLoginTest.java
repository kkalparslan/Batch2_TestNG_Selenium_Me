package com.krafttechnologie.tests.day15_POM1;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    //LoginPages loginPages=new LoginPages();

    @Test
    public void wrongPassword() {
        LoginPage loginPage =new LoginPage();

        driver.get(ConfigurationReader.get("url"));

        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInput_loc.sendKeys("some password");
        loginPage.submitButton_loc.click();

//        WebElement usernameInput = driver.findElement(By.name("email"));
//        WebElement passwordInput = driver.findElement(By.name("password"));
//
//        usernameInput.sendKeys(ConfigurationReader.get("username"));
//        passwordInput.sendKeys("some password");
//
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        WebElement warningMessage = driver.findElement
//                (By.xpath("//*[contains(text(),'Email address or password is incorrect. Please check')]"));
//
//        Assert.assertEquals(warningMessage.getText(),
//                "Email address or password is incorrect. Please check",
//                "Verify that user is NOT login");
    }
    @Test
    public void wrongUsername(){
        LoginPage loginPage =new LoginPage();
        driver.get(ConfigurationReader.get("url"));

        loginPage.userEmailInput_loc.sendKeys("alparslan");
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        loginPage.submitButton_loc.click();

        String actualMessage= loginPage.warningMessage_loc.getText();
        String expectedMessage="Email address or password is incorrect. Please check";

        Assert.assertEquals(actualMessage, expectedMessage,"FAIL");
    }
}
