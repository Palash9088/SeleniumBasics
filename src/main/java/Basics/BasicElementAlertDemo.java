package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicElementAlertDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

        System.out.println("STEP -> Navigate to Basic Element Page");
        driver.findElement(By.id("basicelements")).click();

        Thread.sleep(3000);

        System.out.println("STEP -> Fill First Name");
        String firstName = "Palash";
        driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
        String fName = driver.findElement(By.cssSelector("input#UserFirstName")).getAttribute("value");
        System.out.println(fName);
       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        Object input_shadow = js.executeScript('''return document.querySelector("$1").shadowRoot''');
        div_text = inputShadow.find_element_by_tag_name("div").text;*/

        System.out.println("STEP -> Fill Last Name");
        String lastName = "Soni";
        driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
        String lName = driver.findElement(By.xpath("//input[@id='UserLastName']")).getAttribute("value");

        System.out.println("STEP -> Fill Company Name");
        String companyName = "xyz";
        driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
        String cName = driver.findElement(By.xpath("//input[@id='UserCompanyName']")).getAttribute("value");

        System.out.println("STEP -> Submit Details");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

        Alert alert = driver.switchTo().alert();
        String actualAlert = alert.getText();

        alert.accept();


        String expectedAlert = fName + " and "+ lName +" and "+ cName;
        System.out.println(expectedAlert);

      if (actualAlert.equals(expectedAlert))
        {
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Failed");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
