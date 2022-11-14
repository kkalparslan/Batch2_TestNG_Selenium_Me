package com.krafttechnologie.tests.day8_webElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isSelected_RadioButton {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement radioButton1=driver.findElement(By.cssSelector("#gridRadios1"));
        System.out.println("radioButton1.isSelected() = " + radioButton1.isSelected());

        WebElement radioButton2=driver.findElement(By.cssSelector("#gridRadios2"));
        System.out.println("radioButton2.isSelected() = " + radioButton2.isSelected());

        Assert.assertTrue(radioButton1.isSelected(),"FAIL");
        Assert.assertFalse(radioButton2.isSelected(),"FAIL");
        //isSelected metonu ile elementin secilip secilmedigini assert etmek icin kullaniriz

        Thread.sleep(2000);
        radioButton2.click();
        Thread.sleep(2000);

        Assert.assertFalse(radioButton1.isSelected(),"FAIL");
        //System.out.println("radioButton1.isSelected() = " + radioButton1.isSelected());
        Assert.assertTrue(radioButton2.isSelected(),"FAIL");
       // System.out.println("radioButton2.isSelected() = " + radioButton2.isSelected());

    }
}
