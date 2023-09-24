package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase{

    // class task
    // go to url
    // enter username
    // enter password
    // click login button
    @Test
    public void test1(){
        //WebDriver driver=Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("password") + Keys.ENTER);
    }
}
