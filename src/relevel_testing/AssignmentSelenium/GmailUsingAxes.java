
import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailUsingAxes extends PredefinedActions {
    WebDriver driver;

    void openBrowser(String url)
    {
        driver = start(url);
    }
    void locateToLogin() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='logo']/following::input[@aria-label='Email or phone']")).sendKeys("Palash");
    }

    public static void main(String[] args) throws InterruptedException {
        GmailUsingAxes gmailUsingAxes = new GmailUsingAxes();
        gmailUsingAxes.openBrowser("https://accounts.google.com/v3/signin/identifier?dsh=S67657515%3A1663750875425481&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWrvY-8gnLVk0MQFw4PKpu_TiafP_Q3k4Mbob_9wJIzVeltYfpuF6J22xebTs1D_REu9hsytQg");
        gmailUsingAxes.locateToLogin();
    }
}
