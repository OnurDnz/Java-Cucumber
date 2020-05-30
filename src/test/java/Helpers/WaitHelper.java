package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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

}
