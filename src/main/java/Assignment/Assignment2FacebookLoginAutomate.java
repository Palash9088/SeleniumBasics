package Assignment;
//import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment2FacebookLoginAutomate {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/geckodriver.exe");
        System.out.println("Step -> Opening Browser");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        String url = "https://www.facebook.com/";
        System.out.println("Step -> Opening :"+ url);
        driver.navigate().to(url);

        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        System.out.println("Step -> Checking Title");
        if(expectedTitle.equals(driver.getTitle()))
            System.out.println("Correct Title");
        else
            System.out.println("Incorrect Title");

        System.out.println("Step -> Login into Facebook");
        String email = "Hihello@gmail.com";
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        String password = "HiHello";
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);

        driver.findElement(By.xpath("//button[@name='login']")).click();

        Thread.sleep(3000);

        System.out.println("Step -> Verifying Title");
        String expectedPageTitle= "Facebook";
        String actualPageTitle = driver.getTitle();

        if (expectedPageTitle.equals(actualPageTitle))
            System.out.println("Correct Login Page Title");
        else
            System.out.println("Incorrect Login Page Title");


        System.out.println("Step -> Navigating to https://www.google.com/");
        driver.navigate().to("https://www.google.com/");

        System.out.println("Step -> Navigating back to Facebook");
        driver.navigate().back();
        String expectedNavBackTitle = "Facebook";
        String actualNavBackTitle = driver.getTitle();

        System.out.println("Step -> Verifying Title");
        if(expectedNavBackTitle.equals(actualNavBackTitle))
            System.out.println("Correct title in navigating back");
        else
            System.out.println("Incorrect title in navigating back");

        System.out.println("Step -> Navigating forward to Google");
        driver.navigate().forward();
        String expectedNavForwardTitle = "Google";
        String actualNavForwardTitle = driver.getTitle();

        if(expectedNavForwardTitle.equals(actualNavForwardTitle))
            System.out.println("Correct title in navigating Forward");
        else
            System.out.println("Incorrect title in navigating Forward");

        System.out.println("Step -> Verify when the page refreshes, title remains same");
        driver.navigate().refresh();
        String expectedNavRefreshTitle = "Google";
        String actualNavRefreshTitle = driver.getTitle();

        if(expectedNavRefreshTitle.equals(actualNavRefreshTitle))
            System.out.println("Correct title in Refreshing Page");
        else
            System.out.println("Incorrect title in Refreshing Page");

        Thread.sleep(4000);
        driver.quit();
    }
}
