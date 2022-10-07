import Base.PredefinedActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
* https://relevel.com/courses/software-testing-course-0001/schedule/class-details/aabb5242-f5a4-4119-a379-71de87445a3e/assignment/f4f36bfc-38d0-4553-bec5-9ceb5fd8d625

Assignment -1
Submission Date - 11th Oct, 2022, 10 AM

1. Write a code when the actual string is not equal to the expected string using hard assert, and the result should be Pass?

2. Given the code below, which line of code stops the execution if the title is "Get your dream job in 15 days"?

Line1-driver.navigate().to("https://www.relevel.com/");
Line2-String getActualTitle = driver.getTitle();
Line3-Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Get your dream job in 15 days");
Line4-assertEquals(getActualTitle, "Get your dream job in 15 days");
Line5-assertNotEquals(getActualTitle, "Get your dream job in 15 days");
Line6-assertNull(verifyTitle);
Line7-assertNotNull(verifyTitle);
Line8-assertTrue("Relevel".equals("Relevel"), "First soft assert failed");
Line9-assertFalse("Relevel".equals("Relevel"), "Second soft assert failed");*/

public class AssertNotEqualTest extends PredefinedActions {
    WebDriver driver;

    @BeforeClass
    public void setDriver() throws InterruptedException {
        driver = start("https://relevel.com/");
        Thread.sleep(2000);
    }

    @Test
    public void assertNotEqualTestDemo() {
        System.out.println("Step -> verifying if page title match");
        String expectedTitle = "Relevel - Unlock your dream job";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void assertEqualTest() {
        System.out.println("Step -> verifying if page title does not match");
        String expectedTitle = "Relevel - Unlock your dream job!";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(expectedTitle, actualTitle);
    }

    @AfterClass
    public void tearDown()
    {
        System.out.println("Driver closed");
        driver.close();
    }

}
/*
* 2. Given the code below, which line of code stops the execution if the title is "Get your dream job in 15 days"?

Line1-driver.navigate().to("https://www.relevel.com/");
Line2-String getActualTitle = driver.getTitle(); //
Line3-Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Get your dream job in 15 days"); //true
Line4-assertEquals(getActualTitle, "Get your dream job in 15 days");
Line5-assertNotEquals(getActualTitle, "Get your dream job in 15 days");
Line6-assertNull(verifyTitle);
Line7-assertNotNull(verifyTitle);
Line8-assertTrue("Relevel".equals("Relevel"), "First soft assert failed");
Line9-assertFalse("Relevel".equals("Relevel"), "Second soft assert failed");*/


