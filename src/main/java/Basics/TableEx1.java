package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableEx1 extends PredefinedActions {
    WebDriver driver;

    void setUp()
    {
       driver =  start(); // if we did not catch here in driver it will give null pointer exception
    }

    void openPage() throws InterruptedException {
        System.out.println("Opening Demo Table page");
        driver.findElement(By.linkText("Demo Tables")).click();
        Thread.sleep(3000);
    }
    void printTable() throws InterruptedException {
        List<WebElement> headerList = driver.findElements(By.xpath("//*[@id='table1']//thead/tr/th")); //Headers Xpath with Find Elements
        System.out.println("Printing Table Header");
        System.out.println("Total Headers : " + headerList.size());

        System.out.println("Printing Table Data");
        for (WebElement element : headerList)
            System.out.print(element.getText() + "\t");
        System.out.println();

        int rowSize = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr")).size();
        for (int index = 1; index <= rowSize; index++) {
            List<WebElement> tableData = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr["+index+"]/td"));

            for (WebElement element : tableData) {
                System.out.print(element.getText() + "\t");
            }
            System.out.println();
        }
    }
    void surnamePrint()
    {
        System.out.println("Printing Surname");

        List <WebElement> surname = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[3]"));

        System.out.print("Surnames are : ");
        for(WebElement element : surname ) {
            System.out.print(element.getText() + ",");
        }
        System.out.println();
    }

    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx1 tableEx1 = new TableEx1();
        tableEx1.setUp();
        //tableEx1.printTable();
        tableEx1.openPage();
        tableEx1.surnamePrint();
        tableEx1.tearDown();

    }

}
