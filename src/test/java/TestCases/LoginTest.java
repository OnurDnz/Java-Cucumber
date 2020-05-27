package TestCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    protected WebDriver driver;

    @Given("I will launch browser")
    public void I_will_launch_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.tr/");
    }

    @When("I will search in searchbox")
    public void ı_Will_Search_In_Searchbox() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Test");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
    }
}
