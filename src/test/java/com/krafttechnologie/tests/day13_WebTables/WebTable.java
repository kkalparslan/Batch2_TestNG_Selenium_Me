package com.krafttechnologie.tests.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class WebTable {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
            }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void printTable() throws InterruptedException {
        WebElement table=driver.findElement(By.xpath("//table[@class='table" +
                " table-light traversal-table']"));
        System.out.println("table.getText() = " + table.getText());
    }
    @Test
    public void printAllHeaders() throws InterruptedException {
        WebElement headers=driver.findElement(By.xpath("//table[@class='table" +
                " table-light traversal-table']/thead"));
        System.out.println("headers.getText() = " + headers.getText());
    }
    @Test
    public void printTableSize() throws InterruptedException {
        List<WebElement> thSize=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//th"));
        System.out.println("thSize.size() = " + thSize.size());
        List<WebElement>rowSize=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tr"));
        System.out.println("rowSize.size() = " + rowSize.size());
        List<WebElement> allRowsWithoutheaders=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr"));
        System.out.println("allRowsWithoutheaders.size() = " + allRowsWithoutheaders.size());
    }
    @Test
    public void getRow(){
        WebElement secondRow = driver.findElement(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr[2]"));
        System.out.println("secondRow.getText() = " + secondRow.getText());
    }
    @Test
    public void getAllRows() throws InterruptedException {
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr"));
        Thread.sleep(2000);

        for (int i=1; i<=allRows.size(); i++) {
            WebElement row=driver.findElement(By.xpath("//table[@class='table" +
                    " table-light traversal-table']//tbody//tr["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }
    }
    @Test
    public void getAllCellsOneRow(){
        List<WebElement>allCells=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr[2]/td"));
        for (WebElement element:allCells) {
            System.out.println("element.getText() = " + element.getText());
        }
        WebElement jacob=driver.findElement(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr[2]/td[1]"));
        System.out.println("jacob.getText() = " + jacob.getText());

        WebElement scott=driver.findElement(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr[3]/td[2]"));
        System.out.println("scott.getText() = " + scott.getText());
    }
    @Test
    public void ıframeWorking() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/iframe");
//        WebElement iframe = driver.findElement(By.cssSelector(".alert.alert-primary.bg-primary.text-light.border-0.alert-dismissible.fade.show"));
//        driver.switchTo().frame(iframe);
//        Thread.sleep(2000);
        WebElement iframe= driver.findElement(By.tagName("iframe")); // önce girmek istediğimiz
        // ıframe i bulduk..tag name ile bir tane olduğunu gördük.

        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        WebElement box=driver.findElement(By.xpath("(//button[@class='btn-close btn-close-white'])[1]"));
        box.click();

        driver.switchTo().defaultContent();
        WebElement title= driver.findElement(By.xpath("//h1[.='Iframe']"));

        System.out.println("title.getText() = " + title.getText());
        Thread.sleep(2000);
    }

}
