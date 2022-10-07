package TestNGBasics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DemoTest extends PredefinedActions {

    WebDriver driver;
    @Test
    public void setUp()
    {
        driver = start();
    }
}
