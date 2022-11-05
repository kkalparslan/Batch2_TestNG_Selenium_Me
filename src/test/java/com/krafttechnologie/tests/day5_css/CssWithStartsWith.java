package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithStartsWith {
    public static void main(String[] args) {
        /*
        TASK 3: amazon.com a git
        search box a cucumber yaz
        Search button unna click yap
                */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com/");
        WebElement searchbox=driver.findElement(By.cssSelector("input[id^='twotabse']"));
        searchbox.sendKeys("cucumber");
        WebElement searchbtn=driver.findElement(By.cssSelector("input[id^='nav-search-']"));
        searchbtn.click();
        driver.quit();

    }

}
