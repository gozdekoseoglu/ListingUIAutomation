package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By extraBanner = By.cssSelector(".item-extra a");
    By searchBox = By.cssSelector(".js-product-search-input");
    By searchButton = By.xpath("//*[@id=\"product-search-1\"]/div[1]/button");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickExtraBanner() {
        click(extraBanner);
    }

    public void searchBoxSendKey(String key) {
        sendKeys(searchBox, key);
    }

    public void clickSearchButton() {
        click(searchButton);
    }
}
