package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class TableEx4 extends PredefinedActions {
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
    void duplicateEmpId()
    {
        List<WebElement> empId = driver.findElements(By.xpath("//*[@id='empmanager']//tr//td[2]"));
        int colSize = empId.size();
        HashSet<Integer> empSet = new HashSet<>();

    }
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx4 tableEx1 = new TableEx4();
        tableEx1.setUp();
        tableEx1.openPage();
        tableEx1.duplicateEmpId();
        tableEx1.tearDown();


    }

}
