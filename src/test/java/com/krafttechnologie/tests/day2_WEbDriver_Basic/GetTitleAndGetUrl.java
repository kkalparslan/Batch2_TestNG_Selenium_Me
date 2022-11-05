package com.krafttechnologie.tests.day2_WEbDriver_Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        //Task open chrome and navigate to https://www.krafttechnologie.com/
        //get page title

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        // getting title with selenium- selenium ile title alma
        String title=driver.getTitle();

        System.out.println("title = " + title);


        // get the url from browser - browserdan url alma
        String currentUrl= driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        //get the source of page- sayfanın kaynak alma
        String pageSource=driver.getPageSource();

        System.out.println("pageSource = " + pageSource);


    }
}
