package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    private WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public WebDriver initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }
}
