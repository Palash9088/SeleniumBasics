import Base.PredefinedActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertNotEqualTest extends PredefinedActions {
    WebDriver driver;

    @BeforeClass
    public void setDriver() {
        driver = start("https://relevel.com/");
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
        String expectedTitle = "Relevel - Unlock your dream job";
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
