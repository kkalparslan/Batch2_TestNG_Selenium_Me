package com.krafttechnologie.tests.day8_webElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isEnabled {
    //isEnabled metodu elementin etkin/kullanilabilir olup olmadigini assert etmek icin kullaniriz
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
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkbox=driver.findElement(By.cssSelector("#gridCheck3"));

//        System.out.println("checkbox.isDisplayed() = " + checkbox.isDisplayed());
//        System.out.println("checkbox.isEnabled() = " + checkbox.isEnabled());
//        System.out.println("checkbox.isSelected() = " + checkbox.isSelected());

        System.out.println("checkbox.isEnabled() = " + checkbox.isEnabled());
        Assert.assertFalse(checkbox.isEnabled(),"FAIL");
        Thread.sleep(2000);

        WebElement checkbox2=driver.findElement(By.cssSelector("#gridCheck1"));
        Assert.assertTrue(checkbox2.isEnabled(),"pass");
        System.out.println("checkbox2.isEnabled() = " + checkbox2.isEnabled());
    }
}
