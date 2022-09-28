package ClassCodes;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertHandle extends PredefinedActions {
    WebDriver driver;

    void setDriver(String url)
    {
        driver = start(url);
    }
    void handleAlert() throws InterruptedException {
        System.out.println("Step -> Enter Customer ID");
        driver.findElement(By.xpath("//*[@name='cusid']")).sendKeys("Palash");

        Thread.sleep(2000);
        System.out.println("Step -> Click on Submit button");
        driver.findElement(By.xpath("//*[@name='submit']")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        Thread.sleep(3000);
        String actual = alert.getText();

        if(actual.equals("Customer Successfully Delete!"))
        {
            alert.accept();
            System.out.println("User Deleted successfully");
        }
        else
        {
            System.out.println("Please try again");
        }
    }
    void tearDown()
    {
        System.out.println("Closing the driver");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        AlertHandle alertHandle = new AlertHandle();
        alertHandle.setDriver("https://demo.guru99.com/test/delete_customer.php");
        alertHandle.handleAlert();
        alertHandle.tearDown();
    }
}
