package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.co.in";

        driver.get(url);

        String currentUrl =  driver.getCurrentUrl();

        if(url.equals(currentUrl))
        {
            System.out.println("Correct url is opened");
        }
        else {
            System.out.println("Not opened");
        }

        String title = driver.getTitle();
        System.out.println("Current page title is " + title);

        String pageSource = driver.getPageSource();
        driver.close();
    }
}
