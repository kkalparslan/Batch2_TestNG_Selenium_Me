package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathWithStartsAndContainsWith {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://hepsiburada.com/");

        WebElement searchbox = driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]"));
        searchbox.sendKeys("Selenium");
        WebElement searchbtn=driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));
        searchbtn.click();
        driver.quit();


    }
}
