package com.krafttechnologie.tests.day6_webElements;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserStackTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window
         *  accept cookies if any ,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");

        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement cookiesButton=driver.findElement(By.cssSelector("#accept-cookie-notification"));
        cookiesButton.click();
        Thread.sleep(1000);

        Faker faker=new Faker();
        WebElement name=driver.findElement(By.name("user[full_name]"));
        name.sendKeys(faker.name().fullName());
        Thread.sleep(1000);

        WebElement email=driver.findElement(By.name("user[email]"));
        email.sendKeys(faker.internet().emailAddress());
        Thread.sleep(1000);

        WebElement password=driver.findElement(By.name("user[password]"));
        password.sendKeys(faker.internet().password());
        Thread.sleep(1000);

        WebElement clickButton=driver.findElement(By.cssSelector("#tnc_checkbox"));
        clickButton.click();
        Thread.sleep(1000);

        driver.close();


         }

}
