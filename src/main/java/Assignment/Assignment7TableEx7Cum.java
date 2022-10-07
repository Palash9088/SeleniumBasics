package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Set;

public class Assignment7TableEx7Cum extends PredefinedActions {
    WebDriver driver;
    void setDriver() {
        driver = start();
    }

    void openPage() throws InterruptedException {
        driver.findElement(By.linkText("Demo Tables")).click();
        Thread.sleep(2000);

    }
    void empReportingToEachManager() {
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        HashMap<String,Integer> managerIdMap = new HashMap<String,Integer>();

        for (int index = 1; index <= totalRows; index++) {
            String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
            //System.out.println(empName);
            String empManagerId = (driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText());
            //System.out.println(empManagerId);


            if(managerIdMap.containsKey(empManagerId))
            {
                managerIdMap.put(empManagerId,managerIdMap.get(empManagerId)+1);
            }
            else {
                managerIdMap.put(empManagerId,1);
            }
        }
        System.out.println(managerIdMap);

        System.out.println("Max employees reporting to Manager");
        Set<String> keys= managerIdMap.keySet();
        String deptId = "";
       int count = 0;

       for (String managerId : keys)
       {
           System.out.println(managerId + " -> " + managerIdMap.get(managerId));
           if(count<managerIdMap.get(managerId))
           {
               count = managerIdMap.get(managerId);
               deptId = managerId;
           }
       }
        System.out.println("Maximum Employees : " + count + " Manager ID is : " + deptId );
    }
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        Assignment7TableEx7Cum obj = new Assignment7TableEx7Cum();

        obj.setDriver();
        obj.openPage();
        obj.empReportingToEachManager();
        obj.tearDown();

    }
}
