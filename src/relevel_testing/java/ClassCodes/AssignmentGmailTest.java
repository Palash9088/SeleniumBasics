package ClassCodes;//import java.util.*;


import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentGmailTest  extends PredefinedActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = start("https://accounts.google.com/v3/signin/identifier?dsh=S-401697392%3A1663255300801088&continue=https%3A%2F%2Faccounts.google.com%2F&followup=https%3A%2F%2Faccounts.google.com%2F&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWpPxeXS3285KmayR8f0ycv6u-unp7AKTaWJX5RRbHIJAwg9v9aWqjKqv9C0tu0qibV-U00Z1A");

        System.out.println("Step -> Entering Email id");
        Thread.sleep(2000);
        driver.findElement(By.id("identifierId")).sendKeys("palashsoni5@gmail.com");

        System.out.println("Step -> Click on next");
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();


    }
}
