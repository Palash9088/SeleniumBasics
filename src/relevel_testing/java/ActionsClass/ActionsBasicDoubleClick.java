package ActionsClass;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsBasicDoubleClick extends PredefinedActions {
    WebDriver driver;

    void setDriver() {
        driver = startFirefox("http://automationbykrishna.com/index.html");
    }

    void actionClick() throws InterruptedException {
        Actions actions = new Actions(driver);

        String expectedAlertText = "You successfully double clicked it";

        System.out.println("Step -> Open Basic Elements Page");
        driver.findElement(By.linkText("Basic Elements")).click();
       // WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-12']/div/a"));

        Thread.sleep(3000); //always keep this if you don't want your script to fail
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//div[@class='col-lg-12']/div/a")));

        System.out.println("Step -> Double click on Button");
        actions.doubleClick(driver.findElement(By.xpath("//*[@class='col-lg-12']/div/a"))).build().perform();

        System.out.println("Step -> Alert Handle");
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();

        Thread.sleep(3000);
        if(actualAlertText.equals(expectedAlertText))
        {
            alert.accept();
            System.out.println("Test Passed");
        }
        else {
            alert.accept();
            System.out.println("Test Failed");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ActionsBasicDoubleClick actionsBasics = new ActionsBasicDoubleClick();
        actionsBasics.setDriver();
        Thread.sleep(2000);
        actionsBasics.actionClick();
    }
}




