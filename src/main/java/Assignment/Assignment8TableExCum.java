package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableExCumAssignment8 extends PredefinedActions {
    WebDriver driver;

    void setUp() {
        driver = start(); // if we did not catch here in driver it will give null pointer exception
    }

    void openPage() throws InterruptedException {
        System.out.println("Opening Demo Table page");
        driver.findElement(By.linkText("Demo Tables")).click();
        Thread.sleep(3000);
    }

    void printTable() throws InterruptedException { // Table Print without loop

        WebElement row = driver.findElement(By.xpath("//*[@id='table1']"));
        System.out.println(row.getText());
    }

    void validateUserName() {
        System.out.println("Step -> verifying Username");
        boolean flag;

        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for (int index = 1; index <= totalRows; index++) {
            String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
            String lastname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
            String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText();

            flag = (firstname.toLowerCase().charAt(0) + lastname.toLowerCase()).equals(username);

            if (flag) {
                System.out.println(firstname + " " + lastname + " " + " -> " + username);
            } else
                System.out.println("Test Failed");
        }

    }

    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver Closed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        TableExCumAssignment8 tableEx1 = new TableExCumAssignment8();
        tableEx1.setUp();
        tableEx1.openPage();
        //tableEx1.printTable();
        tableEx1.validateUserName();
        tableEx1.tearDown();

    }

}
