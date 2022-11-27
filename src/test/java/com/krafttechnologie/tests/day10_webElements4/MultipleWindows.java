package com.krafttechnologie.tests.day10_webElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class MultipleWindows {
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
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick=driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(2000);

//        String titleAfterClick=driver.getTitle();
//        System.out.println("titleAfterClick = " + titleAfterClick);
//        Thread.sleep(2000);

        String currentTab = driver.getWindowHandle(); // title The Internet and has ID --> CDwindow-2BA8CC3999672098BF7E9E6CE8800510
        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles(); // List değilde Set in içine
        // atamasının nedeni uniqe değer almasından ötürü. çünkü Set ler dublicate veriyi kabul etmiyor..

        for (String tab : windowHandles) { // go and check one by one
            if(!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
    @Test
    public void multipleWindows(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
           // if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows")){
            // multiple windows larda get title yada getCurrentUrl ile belirlediğimiz pencereye gidebiliyoruz.
            // yani for loop un içine bir condition koymaK gerekiyor..
            if (driver.getTitle().equals("New Window")){
                // stop on this tab
                break;
            }
        }

    }
}
