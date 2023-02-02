package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ListingPage extends BasePage {

    By firstProductBox = By.xpath("/html/body/main/div/div[9]/div[1]/div/div/a/div[2]/div");
//    By categoryFilter = By.xpath("/html/body/main/div/div[2]/div[1]/div[1]/div/div[1]/div/a");
    By categoryFilter = By.cssSelector(".js-filter-item:first-child");
//    By categoryFilterSearch = By.xpath("/html/body/main/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[1]/div[2]/input");
    By categoryFilterSearch = By.cssSelector(".js-category-filter-input:first-child");
    By filterCheckBox = By.xpath("/html/body/main/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[1]/ul/li[13]/label");
    By clickFilterApply = By.xpath("/html/body/main/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]/button");
    By categoryFilterPelus = By.xpath("/html/body/main/div/div[2]/div[2]/div[1]/div");
    By clearCategoryFilter = By.cssSelector(".filter__clean-btn");
    By showPastProductButton = By.cssSelector(".js-category-previous");
    By pageUpButton = By.cssSelector(".scroll-top");
    By searchSuggestionsRightArrow = By.xpath("/html/body/main/div/div[4]/div/div/div/div/div[3]/button[2]");
    By searchSuggestionsLastCategory = By.xpath("/html/body/main/div/div[4]/div/div/div/div/div[3]/div/div/div[12]/div/a/span");
    By favoriteButton = By.xpath("/html/body/main/div/div[9]/div[1]/div/div/a/div[1]/span");

    public ListingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickproductBox() {
        click(firstProductBox);
    }

    public void firstCategoryFilter() {
        click(categoryFilter);
    }

    public void categoryFilterSearch1(String key) {
        sendKeys(categoryFilterSearch, key);

    }

    public void clickCheckBox() {
        waitUntilElementVisible(filterCheckBox);
        click(filterCheckBox);

    }

    public void clickCategoryFilterApply() {
        click(clickFilterApply);

    }

    public String categoryFilterText() {
        return driver.findElement(categoryFilterPelus).getText();
    }

    public void clearCategoryFilter() {
        click(clearCategoryFilter);


    }

    public void showPastProduct() {
        click(showPastProductButton);

    }

    public void pageUp() {
        click(pageUpButton);

    }

    public void searchSuggestionsScroll() {
        click(searchSuggestionsRightArrow);

    }

    public void searchSuggestionsSelectCategory() {
        click(searchSuggestionsLastCategory);

    }

    public boolean isPageUpVisible() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(pageUpButton).isDisplayed();
    }


    public boolean isClearButtonVisible() throws InterruptedException {
        waitUntilElementVisible(searchSuggestionsRightArrow);
        return isElementPresent(clearCategoryFilter);

    }

    public void addFavorite() {
        click(favoriteButton);

    }
}

