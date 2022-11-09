package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathWithAndAndOr {
    public static void main(String[] args) {
        // //input[@type='text' and @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://hepsiburada.com/");
        //driver.get("https://b2c-tr.tiens.com/product/list/11229874");

//        WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Lütfen anahtar kelimeleri girin']"));
//        searchbox.sendKeys("kitosan");
//        searchbox.click();
        //driver.findElement(By.cssSelector(".icon.iconfont.tiens-search")).click();



       // WebElement searchbox=driver.findElement(By.xpath("//input[@type='text' and @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        WebElement searchbox=driver.findElement(By.xpath("//input[@type='text' or @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        searchbox.sendKeys("JAVA");
        driver.quit();


    }
}
