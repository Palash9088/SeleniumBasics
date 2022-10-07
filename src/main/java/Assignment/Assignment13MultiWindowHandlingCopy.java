package Assignment;//import java.util.*;
/*Assignment 13 :  28th Aug 2020
Handle multi window
1) Print page title and then close that window & open next window for same operation.*/


import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Assignment13MultiWindowHandlingCopy extends PredefinedActions {
    WebDriver driver;
    void setDriver(String url) {
        driver = start(url);
    }
    void browserHandling() {
        try {
            String mainWindow = driver.getWindowHandle(); // will return session Id for main window

            driver.findElement(By.xpath("//a[@value='Google']")).click();
            driver.findElement(By.xpath("//a[@value='ThoughtWorks']")).click();
            driver.findElement(By.xpath("//a[@value='FB']")).click();
            driver.findElement(By.xpath("//a[@value='Amazon']")).click();
            driver.findElement(By.xpath("//a[@value='Flipkart']")).click();
            driver.findElement(By.xpath("//a[@value='Nvidia']")).click();
            driver.findElement(By.xpath("//a[@value='VMware']")).click();

            Set<String> multiWindow = driver.getWindowHandles(); // return set of string
            System.out.println("Please find below all the titles of windows open: ");

            Iterator<String> itr = multiWindow.iterator();

            while (itr.hasNext()) {
                String currentBrowser = itr.next();
                if (!currentBrowser.equals(mainWindow)) {
                    driver.switchTo().window(currentBrowser);
                    System.out.println(driver.getTitle());
                    driver.close();
                }
            }
            driver.switchTo().window(mainWindow);
        } catch (NoSuchElementException ne) {
            ne.printStackTrace();
        } finally {
            driver.close();
        }
    }


    public static void main(String[] args) {
        Assignment13MultiWindowHandlingCopy obj = new Assignment13MultiWindowHandlingCopy();
        obj.setDriver("D:\\Relevel Classes\\_Java_Study\\Selenium Session Videos\\Session 12 - MultiBrowser, MultiWindow Handiling\\NewTab.html");
        obj.browserHandling();
    }
}
