import Base.PredefinedActions;
import org.openqa.selenium.WebDriver;

public class MakeMyTripLogin extends PredefinedActions {
    WebDriver driver;

    void openBrowserWithLink(String url)
    {
        driver = start(url);
    }
    void loginMakeMyTrip() throws InterruptedException {
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[text()='Login or Create Account']")).click();
        //driver.findElement(By.xpath("//*[@data-cy='account']//child::p[@data-cy='LoginHeaderText']")).click();
        //driver.findElement(By.xpath("//*[@data-cy='LoginHeaderText']")).click();
        //driver.findElement(By.xpath("//*[contains(text(),'Login or Create Account')][@data-cy='LoginHeaderText']")).click();
        //driver.findElement(By.xpath("//*[starts-with(@data-cy,'LoginHeaderText')]")).click();
        //driver.findElement(By.xpath("//*[@data-cy='account'][contains(@class,'user')]")).click();
        //driver.findElement(By.xpath("//span[@data-cy='myIconWhite' or text()='landingSprite myIconWhite']"));
        //driver.findElement(By.xpath("//*[@class='userSection pushRight']//following::span[@class='landingSprite myIconWhite']")).click();
        //driver.findElement(By.xpath("//*[@class='userSection pushRight']//following::p[text()='Login or Create Account']")).click();
        //driver.findElement(By.xpath("//li[@data-cy='account']//following-sibling::div//p[text()='Login or Create Account']")).click();
        //driver.findElement(By.xpath("//*[@class='makeFlex column makeRelative vrtlCenter conCurLang geoSwitcher']//ancestor::div//div[@class='makeFlex column flexOne whiteText latoBold']")).click();
        //driver.findElement(By.xpath("//*[contains(@class,'makeFlex hrtlCenter prependTop5 appendBottom40')]//child::div//p[@data-cy='LoginHeaderText']")).click();
        
        Thread.sleep(2000);


        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        MakeMyTripLogin makeMyTripLogin = new MakeMyTripLogin();
        makeMyTripLogin.openBrowserWithLink("https://www.makemytrip.com/");
        makeMyTripLogin.loginMakeMyTrip();

    }
}
