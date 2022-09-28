package ActionsClass;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsBasicsClick extends PredefinedActions {
    WebDriver driver;

    void setDriver(String url) {
        driver = start(url);
    }

    void actionClick() throws InterruptedException {
        Actions actions = new Actions(driver);
        System.out.println("Step -> Open Elements Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='Elements']")));
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Elements']"))).click().perform();


        System.out.println("Step -> Open Button Page");
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@class='menu-list']//li[5]/span[text()='Buttons']")));

        actions.moveToElement(driver.findElement(By.xpath("//*[@class='menu-list']//li[5]/span[text()='Buttons']"))).click().perform();

        Thread.sleep(3000);
        System.out.println("Step -> click on button");
        driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div/div[@class='mt-4'][2]")).click();
        Thread.sleep(2000);
        String act = driver.findElement(By.id("Q799B")).getAttribute("value");
        System.out.println(act);

    }

    public static void main(String[] args) throws InterruptedException {
        ActionsBasicsClick actionsBasics = new ActionsBasicsClick();
        actionsBasics.setDriver("https://demoqa.com/");
        Thread.sleep(2000);
        actionsBasics.actionClick();
    }
}




