package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {
    public static void main(String[] args) {
        /** ClassTask
         * open the chrome browser
         * go to https://www.krafttechexlab.com/login
         * click on login botton
         * verify that url didnt changed
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        String expectedUrl=driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);

        WebElement clickbutton=driver.findElement(By.cssSelector(".btn.btn-primary.w-100"));
        clickbutton.click();
        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL same");
        }else{
            System.out.println("URL change");
        }
        driver.quit();



    }
}
