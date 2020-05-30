package TestCases;

import Helpers.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    protected WebDriver driver;
    protected WaitHelper helper = new WaitHelper();

    @Given("I will launch browser")
    public void I_will_launch_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com.tr/");
        WaitHelper.WaitForPageLoad(driver);
    }

    @When("I will search in search box")
    public void I_Will_Search_In_Search_box() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Test");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
    }
}
