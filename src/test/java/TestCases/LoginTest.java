package TestCases;

import Helpers.WaitHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    protected WebDriver driver;
    protected WaitHelper helper;

    @Step
    @Given("I will launch browser")
    public void I_will_launch_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com.tr/");
        WaitHelper.WaitForPageLoad(driver);
    }

    @Step
    @When("I will search in search box")
    public void I_Will_Search_In_Search_box() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Test");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
    }

    @Step
    @Then("I will check page")
    public void I_Will_Check_Page() {
        driver.quit();
    }
}
