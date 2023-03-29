package com.krafttechnologie.tests.day2_WEbDriver_Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.krafttechnologie.com/");

        Thread.sleep(2000);

        driver.close(); // close current tab-geçerli sekmeyi kapatır

        Thread.sleep(2000);

        //go to https://www.facebook.com web address
        //givig new browser tab-> yeni browser ayarlandı-> // eğer yeni browser açılmazsa invalid session id hatası verir
        driver=new ChromeDriver();

        driver.get("https://www.facebook.com");

        Thread.sleep(3000);

        driver.quit(); // close all tab- bütün tabları /browser ı kapatır
    }
}
