package com.krafttechnologie.tests.day2_WEbDriver_Basic;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
//        driver.get("https://www.krafttechnologie.com/");
//
//        Thread.sleep(3000);
//
//        driver.close();

        /*
         * Task
         * go to http://www.krafttechexlab.com/  website
         * expected title = Dashboard- Kraft Techex Lab - aFm
         * get title and verify that expected title equal actual title
         */

        driver.get("http://www.krafttechexlab.com/");
        Thread.sleep(3000);
        String expectedTitle = "Dashboard - Kraft Techex Lab - aFm";
        System.out.println("expectedTitle = " + expectedTitle);
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }
        driver.close();
    }
}
