package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TableEx5 extends PredefinedActions {
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
    void empDept()
    {
       HashMap<String,Integer> deptFreqMap = new HashMap<String,Integer>();

       int totalRows = driver.findElements(By.xpath("//*[@class='table table-striped']//tbody//tr")).size();
       for(int index=1;index<=totalRows;index++)
       {
           String deptName = driver.findElement(By.xpath("//*[@class='table table-striped']//tbody//tr["+index+"]//td[5]")).getText();

           if(deptFreqMap.containsKey(deptName))
           {
               deptFreqMap.put(deptName,deptFreqMap.get(deptName)+1);
           }
           else
           {
               deptFreqMap.put(deptName,1);
           }
       }
        System.out.println(deptFreqMap);

       String maxKey = null;
       int maxValue = 0;
       for (Map.Entry<String,Integer> entry : deptFreqMap.entrySet())
       {
            if(entry.getValue() > maxValue)
            {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
       }
        System.out.println("Dept " + maxKey + " has max "+ maxValue + " of employees.");

    }
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx5 tableEx1 = new TableEx5();
        tableEx1.setUp();
        tableEx1.openPage();
        tableEx1.empDept();
        tableEx1.tearDown();


    }

}
