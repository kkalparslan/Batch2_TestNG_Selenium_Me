package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {
    public static void main(String[] args) throws InterruptedException {


/*
        TASK 7: hepsi burada com a git // nthwith
        search box a database Selector yaz
        Search button unna click yap
                */
//        WebDriver driver= WebDriverFactory.getDriver("chrome");
//        driver.get("http://www.krafttechexlab.com/");
//        WebElement element = driver.findElement(By.cssSelector("div[class='row']:nth-of-type(1)"));
//        System.out.println("element.getText() = " + element.getText());

//        /*
//        TASK 8: hepsi burada com a git // nthwith
//        search box a database Selector yaz
//        Search button unna click yap
//                */
//        WebDriver driver= WebDriverFactory.getDriver("chrome");
//        driver.get("http://www.krafttechexlab.com/");
//        WebElement componentText = driver.findElement(By.cssSelector("div[class='row']>div[class='col-md-4']"));
//        System.out.println("componentText.getText() = " + componentText.getText());
//        Thread.sleep(2000);
//        driver.quit();

        /*
        TASK 9: kardeşler
        search box a database Selector yaz
        Search button unna click yap
                */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.krafttechexlab.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement modul = driver.findElement(By.cssSelector("li[class='nav-item']~li[class='nav-item'] :nth-of-type(1)"));
        modul.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
