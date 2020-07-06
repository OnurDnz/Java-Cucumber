package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitHelper {
    private static void waitForDocumentLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return  document.readyState").equals("complete");
            }
        });
    }

    private static void waitForAjaxLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By.cssSelector(".waiting, .tb-loading")).size() == 0;
            }
        });
    }

    public static void WaitForPageLoad(WebDriver driver) {
        waitForDocumentLoad(driver);
        waitForAjaxLoad(driver);
        waitForDocumentLoad(driver);
    }

    public static WebElement waitUntilFind(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            return element;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void waitUntil(WebDriver driver, By by) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(15, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Hata");
    }
}
