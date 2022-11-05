package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deneme {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://b2c-tr.tiens.com/");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[text()='Onaylamak']")).click();

        WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Lütfen anahtar kelimeleri girin']"));
        searchbox.sendKeys("kitosan");

        driver.findElement(By.xpath("//span[@class='icon iconfont tiens-search']")).click();

    }
}
