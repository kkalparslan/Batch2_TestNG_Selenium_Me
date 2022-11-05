package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithEndsWith {
    public static void main(String[] args) throws InterruptedException {
        /*
        TASK 4: amazon.com a git
        search box a API yaz
        Search button unna click yap
                */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com/");
        WebElement searchbox=driver.findElement(By.cssSelector("input[id$='textbox']"));
        searchbox.sendKeys("API");
        WebElement searcbtn=driver.findElement(By.cssSelector("input[id$='-button']"));
        searcbtn.click();
        Thread.sleep(2000);
        driver.quit();


    }
}
