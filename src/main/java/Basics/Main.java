package Basics;//import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main  {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        System.out.println("Step -> Opening Chrome Browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(3000);
        //JavascriptExecutor js = (JavascriptExecutor) driver;

       // js.executeScript("window.scrollBy(0,document.body.scrollHeight)",driver.findElement(By.xpath("//*[text()='Drag the following blocks into empty cells below']")));
        WebElement from = driver.findElement(By.xpath("//div[@id='products']//following::li/a[text()=' 5000 ']"));
        WebElement to = driver.findElement(By.xpath("//*[@class='shoppingCart']/div/ol[@id='amt7']"));
        Actions act=new Actions(driver);
        act.dragAndDrop(from,to).build().perform();
        Thread.sleep(2000);



    }
}
