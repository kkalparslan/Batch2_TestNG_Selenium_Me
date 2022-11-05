package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         *  go to the amazon webpage
         *  write "selenium" to search box
         *  verify that the result of the search
         */
        String product="Selenium";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com.tr/");
        WebElement cookiesAccept=driver.findElement(By.id("sp-cc-accept"));
        cookiesAccept.click();
        //WebElement searchbox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(product);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[value='Git']")).click();
        Thread.sleep(1000);

        String actualText=driver.findElement(By.xpath("//span[contains(text(),'Aranan ürün:')]/..")).getText();
        // String actualText=driver.findElement(By.xpath("//span[contains(text(),'results for')]/..")).getText(); ahmet koçak
        System.out.println("actualText = " + actualText);
        Thread.sleep(1000);

        if(actualText.contains(product)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }

        driver.quit();
        //WebElement text=driver.findElement(B)



    }

}
