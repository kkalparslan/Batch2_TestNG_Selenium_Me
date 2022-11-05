package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmation {
    public static void main(String[] args) {
        /**
         *  open chrome browser
         *  go to https://www.krafttechexlab.com/login
         *  enter email as mike@gmail.com
         *  enter password as 12345
         *  click login btn
         *  verify that home page is "Dashboard"
                */

        String email="mike@gmail.com";
        String password="12345";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailInputbox=driver.findElement(By.id("email"));
        emailInputbox.sendKeys("mike@gmail.com");
        WebElement passwordInputbox=driver.findElement(By.name("password"));
        passwordInputbox.sendKeys("12345");
        WebElement clickbutton=driver.findElement(By.cssSelector(".btn.btn-primary.w-100"));
        clickbutton.click();
        String expectedHomePageTest="Dashboard";
        String actualHomePage=driver.findElement(By.tagName("h1")).getText();

        if(expectedHomePageTest.equals(actualHomePage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAİLED");
        }
        driver.quit();


    }
}
