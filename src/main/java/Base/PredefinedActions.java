package Base;//import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PredefinedActions {
    static WebDriver driver;
   public static WebDriver start(String url) {
       System.out.println("STEP -> Opening Chrome Browser");
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


       System.out.println("STEP -> Opening Given URL : " + url);
        driver.get(url);
        return driver;
    }
    public static WebDriver startFirefox(String url) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        System.out.println("Step -> Opening Browser");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        System.out.println("STEP -> Opening Given URL : " + url);
        driver.get(url);
        return driver;
    }
    public static WebDriver start()
    {
        return start("http://automationbykrishna.com");
    }

}
