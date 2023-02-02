package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    public void click (By element )
    {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
    }

    public void sendKeys (By element,String key)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(key);
    }

    public void waitURLToBe (String URL)
    {
        wait.until(ExpectedConditions.urlContains(URL));
    }

    public void waitUntilElementVisible(By element)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


}
