package com.krafttechnologie.tests.day8_webElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isSelected_ChechedBox {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkedbox1=driver.findElement(By.cssSelector("#gridCheck1"));
        WebElement checkedbox2=driver.findElement(By.cssSelector("#gridCheck2"));

        System.out.println("checkedbox1.isSelected() = " + checkedbox1.isSelected());
        System.out.println("checkedbox2.isSelected() = " + checkedbox2.isSelected());

        Assert.assertFalse(checkedbox1.isSelected(),"FAIL");
        Assert.assertTrue(checkedbox2.isSelected(),"FAIL");
        Thread.sleep(2000);
        checkedbox1.click();

        Assert.assertTrue(checkedbox1.isSelected(),"FAIL");
        Assert.assertTrue(checkedbox2.isSelected(),"FAIL");



    }

}
