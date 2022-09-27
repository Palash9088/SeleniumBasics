package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Set;

public class TableEx6 extends PredefinedActions {
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
    void empManagerId() //how many employees are attached to a manager
    {
       HashMap<String,Integer> empManagerIdMap = new HashMap<String,Integer>();

       int totalRows = driver.findElements(By.xpath("//*[@class='table table-striped']//tbody//tr")).size();
       for(int index=1;index<=totalRows;index++)
       {
           String empManagerId = driver.findElement(By.xpath("//*[@class='table table-striped']//tbody//tr["+index+"]//td[4]")).getText();

           if(empManagerIdMap.containsKey(empManagerId))
           {
               if(empManagerIdMap.get(empManagerId) == 1)
                    System.out.println("Duplicate Manager ID is :   " + empManagerId);
               empManagerIdMap.put(empManagerId,empManagerIdMap.get(empManagerId)+1);
           }
           else
           {
               empManagerIdMap.put(empManagerId,1);
           }
       }
        //System.out.println(empManagerIdMap);

       //If we want only duplicates
        Set<String> keys = empManagerIdMap.keySet();
        for( String empManagerIdKeys: keys)
            if(empManagerIdMap.get(empManagerIdKeys)>1)
                System.out.println(empManagerIdKeys + " -> " + empManagerIdMap.get(empManagerIdKeys));

    }
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx6 tableEx1 = new TableEx6();
        tableEx1.setUp();
        tableEx1.openPage();
        tableEx1.empManagerId();
        tableEx1.tearDown();


    }

}
