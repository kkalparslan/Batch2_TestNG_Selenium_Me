package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithId {
    /*
    TASK 1: amazon.com a git
    search box a Css yaz
    Search button unna click yap
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com/");
        WebElement searchbox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchbox.sendKeys("css");
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

        Thread.sleep(2000);

        driver.quit();
    }


}
