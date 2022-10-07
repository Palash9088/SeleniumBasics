package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Assignment10ValidateThroughProperty extends PredefinedActions {
    static WebDriver driver;
    String firstName, lastName,companyName;

    void setDriver() {
        driver = start();
    }


    void openBasicElement() {
        System.out.println("Step -> Open Basic element Page");
        driver.findElement(By.linkText("Basic Elements")).click();
    }

    void propRead() throws IOException {
        File file = new File("src/main/resources/InputProp.properties");
        // to open the file

        FileInputStream fileInputStream = new FileInputStream(file);
        // to read the file

        Properties properties = new Properties();
        // to load the file in memory

        properties.load(fileInputStream);

        firstName = properties.getProperty("FirstName");
        lastName = properties.getProperty("LastName");
        companyName = properties.getProperty("CompanyName");
    }
    void verifyAlert()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("STEP -> Fill First Name");
        WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='UserFirstName']")));
        e1.sendKeys(firstName);
        String fName = driver.findElement(By.cssSelector("input#UserFirstName")).getAttribute("value");

        System.out.println("STEP -> Fill Last Name");
        driver.findElement(By.xpath("//*[@id='UserLastName']")).sendKeys(lastName);
        String lName = driver.findElement(By.xpath("//input[@id='UserLastName']")).getAttribute("value");


        System.out.println("STEP -> Fill Company Name");
        driver.findElement(By.xpath("//*[@id='UserCompanyName']")).sendKeys(companyName);
        String cName = driver.findElement(By.xpath("//input[@id='UserCompanyName']")).getAttribute("value");

        System.out.println("STEP -> Submit Details");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

        Alert alert = driver.switchTo().alert();
        String actAlert = alert.getText();

        String expectedAlert = fName + " and "+ lName +" and "+ cName;
        if (actAlert.equals(expectedAlert))
        {
            alert.accept();
            System.out.println("Test Successful");
        }
        else {
            System.out.println("Test Fail");
        }
    }

    public static void main(String[] args) throws IOException {
        Assignment10ValidateThroughProperty obj = new Assignment10ValidateThroughProperty();
        obj.setDriver();
        obj.propRead();
        obj.openBasicElement();
        obj.verifyAlert();

    }

}
