package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableEx2 extends PredefinedActions {
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
    void printTable() throws InterruptedException { // Table Print without loop

        WebElement row = driver.findElement(By.xpath("//*[@id='table1']"));
        System.out.println(row.getText());
    }
    void printIfSurnameContains(String sname)
    {
        for(int index=1;index<=5;index++) {
                WebElement surname = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+index+"]/td[3]"));
            if (surname.getText().equals(sname))
                System.out.println(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+index+"]")).getText());
        }
    }
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx2 tableEx1 = new TableEx2();
        tableEx1.setUp();
        tableEx1.openPage();
        //tableEx1.printTable();
        tableEx1.printIfSurnameContains("Sharma");
        tableEx1.tearDown();

    }

}
