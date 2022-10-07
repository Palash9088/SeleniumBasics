package Assignment;//import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;

public class Assignment1 { 
    public static void setProperty() {
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
    }
    public static void main(String[] args) {
        Assignment1.setProperty();
        WebDriver driver = new ChromeDriver();

        System.out.println("Launching chrome with www.google.com");

        String url = "http://naukri.com";
        driver.get("https://google.com");

        String title = driver.getTitle();
        int titlelength = driver.getTitle().length();
        System.out.println("Page title is :" + title +"title length is :"+ titlelength);

        if(url.equals(driver.getCurrentUrl()))
        {
            System.out.println("URL" + url + "is correct");
        }
        else {
            System.out.println("URL" + url + "is not correct");
        }

        String pageSource = driver.getPageSource();
        int pageSourceLength = driver.getPageSource().length();
        System.out.println(pageSourceLength);

        try {
            FileWriter writer = new FileWriter("src\\main\\java\\org\\page-source.txt");
            writer.write(pageSource);
        } catch (IOException e) {
            System.out.println("Write Fail");
        }
        driver.quit();
    }
}
