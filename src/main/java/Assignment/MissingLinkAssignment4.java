package Assignment;//import java.util.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
/*
* 1) Find total number of links.
Output : 6 links on the page.

2) Print text of all links.

3) Print text of Missing links.
Output : Missing Link -> Instagram

4) Print the name of link where href attribute is missing.
Output : Synechron*/

public class MissingLinkAssignment4 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///D:/Relevel%20Classes/Practice/New%20Text%20Document%20(2).html");

        System.out.println("Find Total Number of Links");

        List<WebElement> linkList = driver.findElements(By.xpath("//a"));
        System.out.println("Total Number of links are " + linkList.size());
        System.out.println("---------------------------------------");

        System.out.println("Print all the Links Present on Page");

        for (WebElement element : linkList) {
            System.out.println(element.getText());
        }
        System.out.println("---------------------------------------");

        System.out.println("Print text of Missing links");
        for (WebElement webElement : linkList) {
            try {
                if (webElement.getAttribute("href").equals("")) {
                    System.out.println("Missing Link -> " + webElement.getText());
                }
            } catch (NullPointerException e) {
                System.out.println("href Attribute is missing -> " + webElement.getText());
            }


        /*    int index = 0;
        for(index =0;index<linkList.size();index++) {
            String linkHref = linkList.get(index).getAttribute("href");
            if (linkHref == null || linkHref.length() == 0)
            {
                System.out.println("Missing Link -> " + linkList.get(index).getText());
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Print the name of link where href attribute is missing");

        for(index =0;index<linkList.size();index++) {
            String linkHref = linkList.get(index).getAttribute("href");
            if (linkHref.equals("href"))
            {
                System.out.println();
            }
            else
            {
                System.out.println("Missing href is " + linkList.get(index).getText());
            }
        }*/

        }
    }
}
