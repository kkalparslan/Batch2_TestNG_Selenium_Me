package com.krafttechnologie.tests.day2_WEbDriver_Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        //go to google -google a git
        //go to facebook - facebook a git
        //back to google -google geri dön

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(); // polly

        driver.get("https://www.google.com");

        //wait 3 second here then move on - 3 saniye bekleyecek ve hareket edecek
        Thread.sleep(3000);

        // navigate to websitelerine erişim için kullandığımız diğer bir selenium method dur
        driver.navigate().to("http://www.facebook.com");

        Thread.sleep(3000);

        //goes back to previous page- önceki sayfaya dön
        driver.navigate().back();

        Thread.sleep(3000);

        //goes back to back - ileri git
        driver.navigate().forward();

        Thread.sleep(3000);

        //refresh to webpage- sayfayı yenile
        driver.navigate().refresh();

    }
}
