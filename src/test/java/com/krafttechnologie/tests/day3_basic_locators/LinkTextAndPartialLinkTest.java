package com.krafttechnologie.tests.day3_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkTest {
    public static void main(String[] args) throws InterruptedException {

        /*
        1- https://the-internet.herokuapp.com/dynamic_loading
        2- https://demoqa.com/text-box
        3- https://mvnrepository.com/
        4- https://www.krafttechexlab.com/index
        5- https://demo.aspnetawesome.com/
        6- https://the-internet.herokuapp.com/inputs
        7-
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1=driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();

        String expectedText="Example 1: Element on page that is hidden";
        String actualText=driver.findElement(By.tagName("h4")).getText();

        if(actualText.contains(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.findElement(By.partialLinkText("Example 2: Element rendered after the fact")).click();
        // PartialLinkTest te texti alırken uniqe bir bölümü almak yeterli oluyorken LinkTest te bu
        // mümkün olmuyor. yani sadece Example 2 ya da fact kısmını da alsak sağlıklı olarak locate edilebiliyor.
        String expectedText2="Example 2: Element rendered after the fact";
        String actualText2= driver.findElement(By.tagName("h4")).getText();

        if(actualText2.contains(expectedText2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(2000);
        driver.close();





    }
}
