package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
   // WebDriver driver;
//    @BeforeMethod
//    public void setUp() {
//        driver= Driver.get();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void openBrowserUsingConfigurationReader() {

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email"))
                .sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password")
                        + Keys.ENTER);
        //actions.
        //wait.until(ExpectedConditions.visibilityOf(locator);

    }

    @Test
    public void loginWithMethod(){

        loginPages.loginUser();

        String actualTitle=dashboardPage.dashboardPageTitle("Dashboard");
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);


    }

}
