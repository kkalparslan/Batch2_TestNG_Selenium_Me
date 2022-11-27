package com.krafttechnologie.tests.day9_webElmenets3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithNoSelect {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        //dropdown kutusunu locate ediyoruz

        WebElement dropdownMenu=driver.findElement(By.xpath("( //div[@class=' css-1wa3eu0-placeholder'])[1]"));
        System.out.println("dropdownMenu.getText() = " + dropdownMenu.getText());
        // kutudaki ilk elementi assert edelim
        String expectedOption="Select Option";
        String actualOption=dropdownMenu.getText();
        Assert.assertEquals(actualOption, expectedOption, "FAIL");
        Thread.sleep(2000);

        // Dropdown içerisinden group 2 option 1 seceneğini cağıralım
        // buradaki sorunumuz inspect yapmak istediğimizde menünün gizleniyor olmasıdır
        // bunu aşmak için events listeners tab ından blur altındaki öğeler remove edilir

        dropdownMenu.click();
        WebElement group2option1=driver.findElement(By.id("react-select-2-option-1-0"));
        group2option1.click();
        Thread.sleep(2000);

        // group 2 option1 seçildikten sonra verify etmek için tekrar locate ediyoruz.
        WebElement selectOption=driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        System.out.println("selectOption.getText() = " + selectOption.getText());
        String expectedOption2="Group 2, option 1";
        String actualOption2=selectOption.getText();
        Assert.assertEquals(actualOption2, expectedOption2, "FAIL");


    }
}
