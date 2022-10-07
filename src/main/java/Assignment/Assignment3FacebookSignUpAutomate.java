package Assignment;//import java.util.*;
/*
* 1. Navigate to facebook sign in page using url https://www.facebook.com/r.php
2. Verify page title is “Sign up for Facebook | Facebook”.
3. Enter Firstname, surname.	ong mobile number (like 788898989hjhj88)
5. Enter any combination of password
6. Using Select class select Date, Month and Year using sequentially selectByValue(), selectByIndex() and selectByVisibleText()
7. Select gender from given radio button options.
8. Click on SignUp button.
(No need to validate error occurred for not entering a valid phone number.)
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpAutomateAssignment3 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        System.out.println("Step -> Opening Chrome");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Step -> Opening URL");
        String url = "https://www.facebook.com/r.php";
        driver.navigate().to(url);

        Thread.sleep(3000);

        System.out.println("Step -> Verify Title");
        if(driver.getTitle().equals("Sign up for Facebook | Facebook"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        System.out.println("Step -> Enter Firstname, surname. wrong mobile number (like 788898989hjhj88)");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Palash");
        driver.findElement(By.xpath("//input[@aria-label='Surname']")).sendKeys("Soni");
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("8517979799");
        driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("Palash@123");

        System.out.println("Step -> sing Select class select Date, Month and Year using sequentially selectByValue(), selectByIndex() and selectByVisibleText()");
        WebElement dateOfBirth = driver.findElement(By.id("day"));
        Select oSelect = new Select(dateOfBirth);
        //Select oSelect = new Select(driver.findElement(By.id("day")));
        oSelect.selectByValue("6");

        WebElement birthMonth = driver.findElement(By.id("month"));
        Select oSelect1 = new Select(birthMonth);
        oSelect1.selectByIndex(8);

        WebElement birthYear = driver.findElement(By.id("year"));
        Select oSelect2 = new Select(birthYear);
        int year = Integer.parseInt("1996");
        oSelect2.selectByVisibleText("1996");

        System.out.println("Step -> Select gender from given radio button options.");
        driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']")).click();

        System.out.println("Step -> Click on SignUp button");
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();






    }
}
