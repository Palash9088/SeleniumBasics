package Assignment;//import java.util.*;

/*Assignment 11
 *1. Navigate to http://automationbykrishna.com/
  2. Go to IFram Demo
  3. Switch to 1st Frame click on Menu
  4. Click on Project and Verify Header1
  5. Switch to 3rd Frame and click on License
  6. Switch to main page and click on Automation By Krishna link
  7. After navigating page Verify the Text */

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment11IframeHandle extends PredefinedActions {
    WebDriver driver;
    void setDriver() {
        driver = start();
    }
    void iFrameAccess() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("Step -> Go to Iframe Demo Page");
        driver.findElement(By.linkText("IFrame Demo")).click();

        System.out.println("Step -> Switch to 1st Iframe");
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='site1']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("site1"));

        Thread.sleep(1000);
        System.out.println("Step -> Click on Menu inside Iframe");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Toggle navigation']"))).click();


        System.out.println("Step -> Click on Projects");
        driver.findElement(By.xpath("//*[@class='nav-link']/span[text()='Projects']"));
        WebElement e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nav-link']/span[text()='Projects']")));
        e2.click();

        System.out.println("Step -> Verify Header");
        String actualText = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-center']/h1")))
                .getText();

        if (actualText.equals("Selenium Projects"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");

        System.out.println(driver.getTitle());


        System.out.println("Step -> Switch to 3rd Iframe");
        driver.switchTo().defaultContent();
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));


        System.out.println("Step -> Click on License");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='menuheader']/ul/li/a[text()='License']")));


        System.out.println("Step Switch to Main Page & Click on Automation By Krishna");
        driver.switchTo().defaultContent();
        //driver.findElement(By.xpath(""));
        WebElement e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Automation By Krishna']")));
        e4.click();

        System.out.println("Step -> Verify Page Title");
        String expected = "This is Maulik.";
        String pageEleAct = driver.findElement(By.xpath("//div[@id='indexBody']")).getText();

        if (driver.getTitle().equals("Login Signup Demo") && pageEleAct.equals(expected)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Assignment11IframeHandle obj = new Assignment11IframeHandle();
        obj.setDriver();
        obj.iFrameAccess();
        obj.tearDown();

    }

    private void tearDown() {
        System.out.println("Step -> Driver Closed");
        driver.quit();
    }
}
