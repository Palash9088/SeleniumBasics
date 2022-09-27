package Base;//import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PredefinedActions {
    static WebDriver driver;
   public static WebDriver start(String url) {
       System.out.println("STEP -> Opening Chrome Browser");
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        System.out.println("STEP -> Opening Given " + url);
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver start()
    {
        return start("http://automationbykrishna.com");
    }
}
