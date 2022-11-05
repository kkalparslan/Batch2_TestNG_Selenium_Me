package com.krafttechnologie.tests.day3_basic_locators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        Faker faker=new Faker();

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement inputUserName = driver.findElement(By.id("userName"));
        inputUserName.sendKeys(faker.name().firstName());
        Thread.sleep(2000);

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
        inputUserEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);

        driver.close();


    }

}
