package Basics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.LinkedHashSet;
import java.util.Set;

public class EmployeeTableExComparator extends PredefinedActions {
    WebDriver driver;

    void setUp() {
        driver = start(); // if we did not catch here in driver it will give null pointer exception
    }

    void openPage() throws InterruptedException {
        System.out.println("Opening Demo Table page");
        driver.findElement(By.linkText("Demo Tables")).click();
        Thread.sleep(3000);
    }

    void addEmpToSet() {
        Set<Employee> employees = new LinkedHashSet<>();
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        for (int index = 1; index <= totalRows; index++) {
            int empId = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]")).getText());
            String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]")).getText();
            int empMgrId = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText());
            String empDept = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]")).getText();

            Employee e1 = new Employee();
            e1.setEmpId(empId);
            e1.setEmpName(empName);
            e1.setEmpManagerId(empMgrId);
            e1.setEmpDept(empDept);

            employees.add(e1);
        }
        System.out.println(employees.size());

        for (Employee em : employees) {
            System.out.println(em.getEmpName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EmployeeTableExComparator obj = new EmployeeTableExComparator();
        obj.setUp();
        obj.openPage();
        obj.addEmpToSet();
        obj.tearDown();
    }

    void tearDown() {
        driver.quit();
    }
}

