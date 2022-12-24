package com.krafttechnologie.tests.day9_webElmenets3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class DropDownWithSelect {
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

        // 1. eğer locate edeceğimiz elementin tag name i select ise; dropdown ı diğer elementeler gibi locate ediyoruz,
        // aşağıda açıklandığı üzere locate ettiğimiz bu elementi select classından oluşturduğumuz objeye constryctor
        // olarak atıyoruz. böylece oluşan bu nesne select clasının sunmuş olduğu mehodlar ile diğer açılan sekmelerdeki
        // seçenekleri seçmemize ve farklı uygulamaları text getirmek gibi sağlamış oluyor.
        WebElement dropdownElement=driver.findElement(By.cssSelector("#oldSelectMenu"));

        // 2. elementi constructor gibi atayarak selenium (select) classından bir obje olusturuyoruz
        Select selectMenu=new Select(dropdownElement); // burası önemli..element locate ederken tagname i select
        // olanlar için uyguluyoruz select sınıfından obje oluşturmayı

        // secilen ilk elementi test edelim
        String expectedOption="Red";
        String actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption, expectedOption,"FAIL");
        //-----------------------------------------------------------------

        // Dropdown dan diğer options lar nasıl getirilir?
        // 1. select visibleText kullanacağız
        Thread.sleep(2000);
        selectMenu.selectByVisibleText("Black");
        expectedOption="Black";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        //------------------------------------------------------------
        // 2. ındex kullanarak cağırıyoruz

        Thread.sleep(2000);
        selectMenu.selectByIndex(6);
        expectedOption="White";

        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        //-----------------------------------------------------------
        // 3. value değerine göre çağırıyoruz
        Thread.sleep(2000);
        selectMenu.selectByValue("3");
        expectedOption="Yellow";

        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

    }

}
