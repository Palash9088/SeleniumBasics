package Assignment;
//import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLoginAutomate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
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

        driver.quit();
    }
}
