package Basics;//import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        System.out.println("Step -> Opening Chrome Browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://google.com");
        driver.quit();

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("hi")));


    }
}
