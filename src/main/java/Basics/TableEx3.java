package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class TableEx3 extends PredefinedActions {
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
    void uniqueLastName()
    {
        List<WebElement> lastName = driver.findElements(By.xpath("//*[@id='table1']//tr//td[3]"));
        LinkedHashSet <String> lNameUnique = new LinkedHashSet<>();
        for(WebElement element : lastName)
        {
            lNameUnique.add((element.getText()));
        }

        Iterator <String> itr = lNameUnique.iterator();
        System.out.println("Unique surname in list is :" +lNameUnique.size());
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx3 tableEx1 = new TableEx3();
        tableEx1.setUp();
        tableEx1.openPage();
        tableEx1.uniqueLastName();
        tableEx1.tearDown();


    }

}
