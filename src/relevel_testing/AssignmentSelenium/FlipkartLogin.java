
import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartLogin extends PredefinedActions {
    WebDriver driver;

    void openBrowserWithLink(String url)
    {
        driver = start(url);
    }
    void loginFlipkart() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("123");
    }

    public static void main(String[] args) throws InterruptedException {
        FlipkartLogin flipkartLogin = new FlipkartLogin();
        flipkartLogin.openBrowserWithLink("https://www.flipkart.com/");
        flipkartLogin.loginFlipkart();
    }
}
