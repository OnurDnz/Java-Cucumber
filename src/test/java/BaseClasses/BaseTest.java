package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public static WebDriver driver;

    public static WebDriver selectBrowser(browsers browser) {
        if (browser == browsers.Chrome) {
            driver = new ChromeDriver();
        } else if (browser == browsers.Firefox) {
            System.setProperty("webdriver.gecko.driver", "C:/selenium-driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public enum browsers {
        Firefox,
        Chrome
    }
}
