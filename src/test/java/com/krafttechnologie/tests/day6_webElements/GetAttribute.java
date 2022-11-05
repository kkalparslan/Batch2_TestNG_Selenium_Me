package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        // there are two ways to get text from web elements
        // 1. getText() --> it will work %99 and it will return string
        // 2. getAttribute("attributeName") --> second way of getting text especially input box

        String email="mike@gmail.com";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailInputbox=driver.findElement(By.id("email"));
        Thread.sleep(2000);

        String value=emailInputbox.getAttribute("class"); // class represant attribute name of email
        System.out.println("value = " + value);
        Thread.sleep(2000);

        driver.quit();



    }
}
