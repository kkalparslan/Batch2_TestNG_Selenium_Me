package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithClass {
    public static void main(String[] args) {
        /*
        TASK 2: amazon.com a git
        search box a testng yaz
        Search button unna click yap
                */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com/");
        WebElement searchbox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchbox.sendKeys("testng");
        WebElement searchbtn=driver.findElement(By.cssSelector(".nav-search-submit-text.nav-sprite.nav-progressive-attribute"));
        searchbtn.click();
        driver.quit();


    }
}
