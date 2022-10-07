/*https://relevel.com/courses/software-testing-course-0001/schedule/class-details/15c80436-ca9f-44d3-8b46-d9686ca47509/assignment/1c063de0-87ce-4c5c-aa0e-fa3541864d5b
Home/Software Testing Course/Real Time UI Scenario - 1/Assignment -1
Assignment -1
Submission Date - 4th Oct, 2022, 10 AM
Requirements: Route to easemytrip.com
Hover on more and select gift cards using actions click.
Scroll down to FAQs.
Hover on the same.
Right-click on the first question.
Pick the answer and print it in the Console.
* */
package ClassCodes;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EaseMyTrip extends PredefinedActions {
    WebDriver driver;

    void setDriver() throws InterruptedException {
         driver = start("https://www.easemytrip.com/");
        Thread.sleep(2000);
    }

    void actionOnEaseMyTrip() throws InterruptedException {
        Actions actions = new Actions(driver);
        System.out.println("Step -> Hover on More Button");
        WebElement menu = driver.findElement(By.xpath("//div[@ng-app='signup']//child::ul/li/a[text()='More ']"));
        actions.moveToElement(menu).build().perform();
        Thread.sleep(3000);

        System.out.println("Step -> Check the size of Menu");
        int size = driver.findElements(By.xpath("//div[@ng-app='signup']//child::ul/li/div[@class='dropdown-menu']/a")).size();
        System.out.println(size+ " Menu items present under More");

        System.out.println("Step -> Click on More");
        driver.findElement(By.xpath("//div[@ng-app='signup']//child::ul/li/div[@class='dropdown-menu']/a[@href='https://www.easemytrip.com/giftcard']")).click();

        System.out.println("Scroll to FAQ section");
        Thread.sleep(3000); //always keep this if you don't want your script to fail
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement destination = driver.findElement(By.xpath("//*[text()='EaseMyTrip Gift Card! Perfect gift for every occasion']"));
        js.executeScript("arguments[0].scrollIntoView(true)", destination);

        Thread.sleep(2000);
        System.out.println("Step -> Hover on Question");
        WebElement ques = driver.findElement(By.xpath("//*[@id='faq']/div/div[2]/div/div[1]/div[1]"));
        actions.moveToElement(ques).build().perform();

        Thread.sleep(2000);
        System.out.println("Step -> Right click on Question");
        actions.contextClick(ques).build().perform();

        Thread.sleep(2000);
        System.out.println("Step -> Print answer on console");
        String answer = driver.findElement(By.xpath("//*[@class='testfaw'][contains(text(),'Gift Cards are the Travel Gift')]")).getText();
        System.out.println(answer);
    }
    void tearDown()
    {
        System.out.println("Closing Browser");
        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {

        EaseMyTrip easeMyTrip = new EaseMyTrip();
        easeMyTrip.setDriver();
        easeMyTrip.actionOnEaseMyTrip();
        easeMyTrip.tearDown();
    }
}
