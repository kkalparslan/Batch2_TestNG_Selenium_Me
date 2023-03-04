package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecuter;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Actions1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        // Action class ileri düzey etkileşimler sunar
        // doubleclick, drogganddropp, hover, rightclick ... vb
        // Action class seleniumdan gelir. webdriver constructor gibi parametre olarak atanır.
        // çünkü driveri browserla etkileşime geçebilmesi için..
        // perform action ı tamamlamak için kullanılır.

        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement ciftclick = driver.findElement(By.cssSelector("#double-click"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.doubleClick(ciftclick).perform();

    }

    @Test
    public void dragAndDropp() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        // actions.dragAndDrop(draggable, droppable).perform();
        actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().perform();
        Thread.sleep(2000);

    }

    /**
     * go to  https://www.krafttechexlab.com/javascript/droppable
     * Drag Me to my target elementini Drop here elementinin uzerine surukle birak
     */
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/droppable");
        WebElement dragMe = driver.findElement(By.cssSelector(".ui-widget-content.ui-draggable.ui-draggable-handle"));
        WebElement dropHere = driver.findElement(By.cssSelector(".ui-widget-header.ui-droppable"));
        System.out.println("dropHere.getText() = " + dropHere.getText());

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe, dropHere).perform();
        Thread.sleep(2000);
        System.out.println("dropHere.getText() = " + dropHere.getText());
        String expected = "Dropped!";
        Assert.assertEquals(dropHere.getText(), expected, "FAIL");
    }

    @Test
    public void hover1() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement hoverMe = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement link1 = driver.findElement(By.xpath("(//a[.='Link 1'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMe).perform();
        Thread.sleep(2000);
        Assert.assertTrue(link1.isDisplayed());
        link1.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        String expected = "Well done you clicked on the link!";
        Assert.assertEquals(alert.getText(), expected);
        Thread.sleep(2000);
        alert.accept();

    }

    @Test
    public void hover2() throws InterruptedException {
        /**
    go to  https://www.krafttechexlab.com/components/tooltips
    Tooltip on top elementine hover yap
    sonrasinda diger elementleri de tek tek hover yap
     */

        driver.get("https://www.krafttechexlab.com/components/tooltips");
        WebElement tooltiptop = driver.findElement(By.xpath("//button[@class='btn btn-secondary'][1]"));
        WebElement tooltipright=driver.findElement(By.xpath("//button[@class='btn btn-secondary'][2]"));
        WebElement tooltipbottom=driver.findElement(By.xpath("//button[@class='btn btn-secondary'][3]"));
        WebElement tooltipleft=driver.findElement(By.xpath("//button[@class='btn btn-secondary'][4]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(tooltiptop).perform();
        actions.moveToElement(tooltipright).perform();
        actions.moveToElement(tooltipbottom).perform();
        actions.moveToElement(tooltipleft).perform();
        //System.out.println("tooltiptop.getText() = " + tooltiptop.getText());
        String expected="Tooltip on top";
        System.out.println("expected = " + expected);
        String  actual=tooltiptop.getText();
        System.out.println("actual = " + actual);
        Assert.assertEquals(tooltiptop.getText(), expected);

//        List<WebElement> element = driver.findElements(By.xpath("//button[@class='btn btn-secondary']"));
//        for (WebElement hover:element){
//            actions.moveToElement(hover).pause(2000).perform();
//        }

    }
    @Test
    public void test() throws InterruptedException {
        /**
     go to https://demoqa.com/buttons
     Right Click Me elementine sag click yap ve
     Assert et
     */
        driver.get("https://demoqa.com/buttons");
        WebElement right=driver.findElement(By.id("rightClickBtn"));
        Actions actions=new Actions(driver);
        actions.contextClick(right).perform();
        Thread.sleep(2000);
        WebElement msj=driver.findElement(By.id("rightClickMessage"));
        String expected="You have done a right click";
        String actual=msj.getText();
        Assert.assertEquals(actual, expected, "FAIL");


    }

}
