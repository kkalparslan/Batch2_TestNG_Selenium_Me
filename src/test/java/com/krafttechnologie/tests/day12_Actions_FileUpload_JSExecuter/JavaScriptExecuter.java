package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecuter;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class JavaScriptExecuter {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS() throws InterruptedException {
        /**
         * Selenium ile cozemedigimiz bazi sorunları javascript executor kullanarak
         * cozebiliriz. Bu sorunlar neler olabili?: clicking, sendkeys, scroll down or
         * scroll up vb..
         * Javascriptexecutor bir interface oldugu icin new kullanarak yeni bir obje
         * olusturamiyoruz.bu nedenle driver i casting yaparak kullaniyoruz
         */

        driver.get("https://the-internet.herokuapp.com/floating_menu");

        WebElement button=driver.findElement(By.linkText("Elemental Selenium"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);"
                +"arguments[0].click()",button);
        Thread.sleep(2000);
        /**
         * notlardan iki method ile title ve url i getirdik github dan çek daha sonra
         */
       // System.out.println("title: " + js.executeScript("return document.title;").toString());
        System.out.println("URL: " + js.executeScript("return document.URL;").toString());


        String currentTab = driver.getWindowHandle();
        System.out.println("Title() = " + driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) { // go and check one by one
            if(!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                System.out.println("Url() = " + driver.getCurrentUrl());
                String expectedUrl="http://elementalselenium.com/";
                String actualUrl=driver.getCurrentUrl();
                Assert.assertEquals(actualUrl, expectedUrl);
            }
        }
        System.out.println("Title() = " + driver.getTitle());
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");
        WebElement firstName = driver.findElement(By.xpath("//input[@class='nameFld'][1]"));
        WebElement lastName = driver.findElement(By.xpath("//input[@class='nameFld'][2]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //executeScript("arguments[0].setAttribute('value', 'text')", WebElement);
        String name="Alparslan";
        String surname="Öztürk";
        js.executeScript("arguments[0].setAttribute('value', '"+name+"')", firstName);
        js.executeScript("arguments[0].setAttribute('value', '"+surname+"')", lastName);
        Thread.sleep(2000);

    }
    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://www.krafttechnologie.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,3000);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-3000);");
        Thread.sleep(2000);

    }

    }

