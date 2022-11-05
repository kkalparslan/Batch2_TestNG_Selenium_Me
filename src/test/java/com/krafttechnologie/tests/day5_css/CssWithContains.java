package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithContains {
    public static void main(String[] args) throws InterruptedException {
/*
        TASK 5: amazon.com a git // containswith
        search box a postman yaz
        Search button unna click yap
                */
//        WebDriver driver= WebDriverFactory.getDriver("chrome");
//        driver.get("https://amazon.com/");
//        WebElement searchbox=driver.findElement(By.cssSelector("input[id*='searchtext']"));
//        searchbox.sendKeys("postman");
//        WebElement searcbtn=driver.findElement(By.cssSelector("input[id*='nav-search']"));
//        searcbtn.click();
//        driver.quit();


        /*
//        TASK 6: hepsi burada com a git // containswith
//        search box a database  yaz
//        Search button unna click yap
//                */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://hepsiburada.com/");
        WebElement searchbox=driver.findElement(By.cssSelector("input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b'][type='text']"));
        searchbox.sendKeys("database");
        //Thread.sleep(2000);
        WebElement searcbtn=driver.findElement(By.cssSelector("div[class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']"));
        searcbtn.click();
        //Thread.sleep(2000);
        driver.quit();
    }
}
