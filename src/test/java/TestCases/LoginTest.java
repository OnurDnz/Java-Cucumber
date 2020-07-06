package TestCases;

import BaseClasses.BaseTest;
import Helpers.WaitHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static BaseClasses.BaseTest.selectBrowser;

public class LoginTest {
    public static WebDriver driver;
    protected WaitHelper helper;

    @Before
    public static void beforeScenario() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = selectBrowser(BaseTest.browsers.Chrome);
        driver.manage().window().maximize();
    }

    @After
    public static void afterScenario() {
        driver.quit();
    }

    @Step
    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        driver.get("https://www.trendyol.com/");
        WaitHelper.WaitForPageLoad(driver);
    }

    @Step
    @When("User Navigate to LogIn Page")
    public void userNavigateToLogInPage() throws InterruptedException {
        Thread.sleep(2000);
        //driver.findElement(By.className("fancybox-item")).click();
        WaitHelper.waitUntilFind(driver, By.className("fancybox-item")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("accountBtn")).click();
        Thread.sleep(2000);
    }

    @And("User enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(arg0);
        driver.findElement(By.id("password")).sendKeys(arg1);
        Thread.sleep(2000);
    }
}
