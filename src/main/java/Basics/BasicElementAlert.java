package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasicElementAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
        Thread.sleep(3000);
        System.out.println("Step -> Go to Basic Element Page");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(3000);

        System.out.println("Step -> Scroll down to alert button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//button[@class='btn btn-success']")));

        System.out.println("Step -> Click on alert button");
        driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
        Thread.sleep(3000);

        System.out.println("Step -> Click ok On alert");
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.quit();

    }
}
