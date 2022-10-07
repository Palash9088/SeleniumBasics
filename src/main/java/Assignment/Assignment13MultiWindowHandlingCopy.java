package Assignment;//import java.util.*;
/*Assignment 13 :  28th Aug 2020
Handle multi window
1) Print page title and then close that window & open next window for same operation.*/


import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment13MultiWindowHandling extends PredefinedActions {

    WebDriver driver;

    void setDriver(String url) {
        driver = start(url);
    }

    void browserHandling() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        String mainWin = driver.getWindowHandle();
        System.out.println(mainWin);

        System.out.println("Step -> Click on Google Button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='Google']"))).click();

        Set<String> multiTab = driver.getWindowHandles();
        iterator(multiTab,mainWin);

        System.out.println("Step -> Click on ThoughtWorks Button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='ThoughtWorks']"))).click();

        Iterator<String> itr = multiTab.iterator();
        while (itr.hasNext()) {
            String currentTab = itr.next();
            if (!currentTab.equals(mainWin))
                driver.switchTo().window(currentTab);
            System.out.println(driver.getTitle());
        }
        driver.close();
        driver.switchTo().window(mainWin);

    }

    void iterator(Set <String> multiTab, String mainWin) {
        Iterator<String> itr = multiTab.iterator();
        while (itr.hasNext()) {
            String currentTab = itr.next();
            if (!currentTab.equals(mainWin))
                driver.switchTo().window(currentTab);
            System.out.println(driver.getTitle());

        }
        driver.close();
        driver.switchTo().window(mainWin);

    }

    public static void main(String[] args) {
        Assignment13MultiWindowHandling obj = new Assignment13MultiWindowHandling();
        obj.setDriver("D:\\Relevel Classes\\_Java_Study\\Selenium Session Videos\\Session 12 - MultiBrowser, MultiWindow Handiling\\NewTab.html");
        obj.browserHandling();
    }
}
