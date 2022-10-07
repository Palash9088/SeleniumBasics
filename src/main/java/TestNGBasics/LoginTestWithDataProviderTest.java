package TestNGBasics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestWithDataProviderTest extends PredefinedActions {

    WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        driver = start();
    }

    @Test(dataProvider = "loginDataProvider")

    public void loginTest(String uname,String pass, String expText)
    {
        System.out.println("Step -> Go to Login Page");
        driver.findElement(By.linkText("Registration")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Step -> Fill login information");
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
        userNameElement.sendKeys(uname);

        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pass);

        System.out.println("Step -> Click on submit");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        alert.accept();

        Assert.assertEquals(expText,actualText);

    }
   @DataProvider(name = "loginDataProvider")
    public Object[][] loginData()
    {
        Object [][] data = new Object[2][3];
        data [0][0] = "Palash";
        data [0][1] = "Palash@123";
        data [0][2] = "Success!";

        data [1][0] = "Parth123";
        data [1][1] = "P123";
        data [1][2] = "Failed! please enter strong password";

        return data;
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
