package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TableEx8 extends PredefinedActions {
    WebDriver driver;

    void setUp() {
        driver = start(); // if we did not catch here in driver it will give null pointer exception
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }

    void openPage() throws InterruptedException {
        System.out.println("Opening Demo Table page");
        driver.findElement(By.linkText("Demo Tables")).click();
        Thread.sleep(3000);
    }

    // Print Total employee managers
    void findAllManagerUsingHashMap() {
        HashMap<String, Integer> managerIdMap = new HashMap<>();
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        for (int index = 1; index <= totalRows; index++) {
            String managerId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText();

            if (managerIdMap.containsKey(managerId)) {
                managerIdMap.put(managerId, managerIdMap.get(managerId) + 1);
            } else {
                managerIdMap.put(managerId, 1);
            }
        }
        System.out.println(managerIdMap);

        //if we want to print only keys
        Set<String> setOfManagerIdKeys = managerIdMap.keySet();
        System.out.println(setOfManagerIdKeys);
    }

    void findAllManagerUsingSet() {
        Set<String> managerIdSet = new LinkedHashSet<String>();
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        for (int index = 1; index <= totalRows; index++) {
            String managerId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText();

            managerIdSet.add(managerId); // for condition check if true then add
            /*if(managerIdSet.add(managerId))
                System.out.println(managerIdSet);*/
        }
        System.out.println(managerIdSet.size()); // for count
        System.out.println(managerIdSet); //// for managerIDs key Set
    }

    void findAllManagerUsingList() {
        List<String> managerIdList = new ArrayList<>();
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        for (int index = 1; index <= totalRows; index++) {
            String managerId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText();
            managerIdList.add(managerId);
        }
        System.out.println(managerIdList);
        //making set for unique value
        Set<String> managerIdSet = new HashSet<>(managerIdList);
        System.out.println(managerIdSet);
    }

    public static void main(String[] args) throws InterruptedException {
        TableEx8 tableEx1 = new TableEx8();
        tableEx1.setUp();
        tableEx1.openPage();
        //tableEx1.findAllManagerUsingHashMap();
        //tableEx1.findAllManagerUsingSet();
        tableEx1.findAllManagerUsingList();
        tableEx1.tearDown();


    }

    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }
}
