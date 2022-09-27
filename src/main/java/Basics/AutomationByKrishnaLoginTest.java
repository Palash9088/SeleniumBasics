package Basics;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationByKrishnaLoginTest {
    public static void main(String[] args) throws InterruptedException {
        String expectedFailedAlert = "Failed! please enter strong password";
        String expectedSuccessAlert = "Success!";

        WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

        System.out.println("STEP -> Find Registration Page");
        driver.findElement(By.id("registration2")).click();

        Thread.sleep(5000);
        System.out.println("STEP -> Enter Username in Credentials");
        String username = "Palash9088";
        driver.findElement(By.id("unameSignin")).sendKeys(username);

        System.out.println("STEP -> Enter Password in Credentials");
        String password = "palash1234";
        driver.findElement(By.id("pwdSignin")).sendKeys(password);
        String getPass = driver.findElement(By.id("pwdSignin")).getAttribute("value");
        System.out.println(getPass);

        System.out.println("STEP -> Click on submit button");
            driver.findElement(By.id("btnsubmitdetails")).click();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);

        String alertActualText = alert.getText();

        System.out.println(getPass.length());
        if(getPass.length() > 8)
        {
            if(alertActualText.equals(expectedSuccessAlert))
                System.out.println("Test Pass");
            else
                System.out.println("Test Failed");
        }
        else {
            if(alertActualText.equals(expectedFailedAlert))
                System.out.println("Test Passed");
            else
                System.out.println("Test Failed");
        }

        System.out.println("STEP -> Dismiss the alert");
        alert.accept();

        System.out.println("STEP -> Closing the Browser");
        driver.quit();
    }
}
