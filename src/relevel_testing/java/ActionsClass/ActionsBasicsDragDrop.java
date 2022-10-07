package ActionsClass;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsBasicsDragDrop extends PredefinedActions {
    static WebDriver driver;
    void setDriver(String url) {
        driver = start(url);
    }
    void actionClick() throws InterruptedException {
        Actions actions = new Actions(driver);
        System.out.println("Step -> Open Demos Page");

        Thread.sleep(3000);
        System.out.println("Step -> scroll down to element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='tabstrip']/ul/li/span[text()='EXAMPLE']")));

        System.out.println("Step -> Performing Drag and Drop");
        WebElement source = driver.findElement(By.xpath("//*[@class='kd-example-runner tabstrip-container']/div//div[@id='draggable']"));
        WebElement destin = driver.findElement(By.xpath("//*[@class='kd-example-runner tabstrip-container']/div//div[@id='droptarget']"));
        actions.dragAndDrop(source,destin).build().perform();

        String text = driver.findElement(By.xpath("//*[@class='kd-example-runner tabstrip-container']/div//div[@id='droptarget']")).getText();
        String failed = driver.findElement(By.xpath("//*[@class='kd-example-runner tabstrip-container']/div//div[@id='droptarget']")).getText();

        if (text.equals("You did great!"))
        {
            System.out.println("Test Pass");
        }
        else if(failed.equals("Try again!"))
        {
            System.out.println("Drop failed Try again");
        }
        else
        {
            System.out.println("Test Failed");
        }
    }
    public static void tearDownBrowser()
    {
        System.out.println("Step -> Closing Browser");
        driver.quit();
        System.out.println("Step -> Browser Closed");
    }

    public static void main(String[] args) throws InterruptedException {
        ActionsBasicsDragDrop actionsBasics = new ActionsBasicsDragDrop();
        actionsBasics.setDriver("https://demos.telerik.com/kendo-ui/dragdrop/index");
        actionsBasics.actionClick();
        tearDownBrowser();
    }
}




