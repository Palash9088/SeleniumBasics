package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicElementFormsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
        System.out.println("Step -> Go to Basic Element Page");
        driver.findElement(By.id("basicelements")).click();
        Thread.sleep(3000);

        System.out.println("Step -> Enter Email ID");
        driver.findElement(By.cssSelector("input#exampleInputEmail1")).sendKeys("Palash@gmail.com");

        System.out.println("Step -> Enter Password");
        driver.findElement(By.cssSelector("input#pwd")).sendKeys("Palash");

        System.out.println("Step -> Click on submit button");
        driver.findElement(By.cssSelector("button#submitb2")).click();

        String expectedAlert = "You successfully clicked on it";
        Alert alert = driver.switchTo().alert();
        String actualAlert = alert.getText();

        if(actualAlert.equals(expectedAlert))
            System.out.println("Test Pass");
        else
            System.out.println("Test Failed");

        alert.accept();

        driver.quit();






    }
}
