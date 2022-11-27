package com.krafttechnologie.tests.day8_webElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isDisplayed {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        //isDisplayed metodu elementin gorunup gorunmedigini assert etmek icin kullaniriz
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement inputBox=driver.findElement(By.id("firstName"));
        System.out.println(inputBox.isDisplayed());

        // verify inputbox is displayed or not
        Assert.assertTrue(inputBox.isDisplayed(),"verify is Faıled");
    }
}
