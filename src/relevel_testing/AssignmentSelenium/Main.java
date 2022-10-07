package com.relevel.relevelmodule;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(os + "os");
        System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
    }
}