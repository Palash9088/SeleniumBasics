package Assignment;//import java.util.*;
/*Assignment 13 :  28th Aug 2020
Handle multi window
1) Print page title and then close that window & open next window for same operation.*/


import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment13MultiWindowHandling extends PredefinedActions {
    WebDriver driver;
    void setDriver(String url) {
        driver = start(url);
    }
    void browserHandling() {
        try {
            String mainWindow = driver.getWindowHandle(); // will return session ID for main window

            driver.findElement(By.xpath("//a[@value='Google']")).click();
            driver.findElement(By.xpath("//a[@value='ThoughtWorks']")).click();
            driver.findElement(By.xpath("//a[@value='FB']")).click();
            driver.findElement(By.xpath("//a[@value='Amazon']")).click();
            driver.findElement(By.xpath("//a[@value='Flipkart']")).click();
            driver.findElement(By.xpath("//a[@value='Nvidia']")).click();
            driver.findElement(By.xpath("//a[@value='VMware']")).click();

            Set<String> multiWindow = driver.getWindowHandles(); // return set of string
            System.out.println("Please find below all the titles of windows open: ");
            iterator(multiWindow, mainWindow);
        } catch (Exception ne) {
            ne.printStackTrace();
        } finally {
            driver.close();
        }
    }

    void iterator(Set<String> multiTab, String mainWin) {
        Iterator<String> itr = multiTab.iterator();
        while (itr.hasNext()) {
            String currentTab = itr.next();
            if (!mainWin.equals(currentTab)) {
                driver.switchTo().window(currentTab);
                String text = "Current Title is : " + driver.getTitle();
                System.out.println(text);
                driver.close();
            }
        }
        driver.switchTo().window(mainWin);
    }

    public static void main(String[] args) {
        Assignment13MultiWindowHandling obj = new Assignment13MultiWindowHandling();
        obj.setDriver("D:\\Relevel Classes\\_Java_Study\\Selenium Session Videos\\Session 12 - MultiBrowser, MultiWindow Handiling\\NewTab.html");
        obj.browserHandling();
    }
}
