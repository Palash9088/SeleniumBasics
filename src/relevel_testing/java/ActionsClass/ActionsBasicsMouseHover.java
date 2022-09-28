package ActionsClass;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsBasicsMouseHover extends PredefinedActions {
    WebDriver driver;
    void setDriver(String url) {
        driver = start(url);
    }
    void actionMouseHover() throws InterruptedException {
        Actions actions = new Actions(driver);
        System.out.println("Step -> Hover on Framework Menu Button");
        WebElement frameworkMenu = driver.findElement(By.xpath("//*[@class='TK-Context-Menu TK-Menu']/li[2]"));
        actions.moveToElement(frameworkMenu).build().perform();
        Thread.sleep(4000);

        System.out.println("Step -> Check the size of dropdown menu element");

        int element = driver.findElements(By.xpath("//*[@class='TK-Context-Menu TK-Menu']/li[2]/ul/li")).size();
        System.out.println("Element present in dropdown : " + element);
    }
    public static void main(String[] args) throws InterruptedException {
        ActionsBasicsMouseHover obj = new ActionsBasicsMouseHover();
        obj.setDriver("https://demos.telerik.com/kendo-ui/dragdrop/index");
        obj.actionMouseHover();
    }
}

