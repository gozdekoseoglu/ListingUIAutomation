package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListingPage;
import java.util.ArrayList;

public class ListingTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://test1.ciceksepeti.com");
        driver.manage().window().maximize();
        HomePage homepage = new HomePage(driver);
        homepage.clickExtraBanner();
        homepage.searchBoxSendKey("oyuncak");
        homepage.clickSearchButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://test1.ciceksepeti.com/arama?query=oyuncak&qt=oyuncak&choice=2","URL does not match");
    }


    @Test
    public void listingSecondPage() throws InterruptedException {

        ListingPage listingPage = new ListingPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 7000);");
        listingPage.waitURLToBe("page=2");
        driver.navigate().refresh();
        listingPage.showPastProduct();
        listingPage.pageUp();
        Assert.assertFalse(listingPage.isPageUpVisible(),"PageUp button is visible");

    }

    @Test
    public void listingFirstProductBox() throws InterruptedException {
        ListingPage listingPage = new ListingPage(driver);
        listingPage.clickproductBox();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://test1.ciceksepeti.com/konusan-altini-islatan-biberonlu-melis-oyuncak-et-bebek-35-cm-66576-kc8467757","URL does not match");

    }

    @Test
    public void listingTestFilterURLCheck() throws InterruptedException {

        ListingPage listingPage = new ListingPage(driver);
        listingPage.firstCategoryFilter();
        listingPage.categoryFilterSearch1("Peluş");
        listingPage.clickCheckBox();
        listingPage.clickCategoryFilterApply();
        listingPage.waitURLToBe("arama?c=12841&choice=2&query=oyuncak");
        Assert.assertEquals(listingPage.categoryFilterText(), "Kumaş, Peluş Bebek","Text does not match");
    }

    @Test
    public void listingTestFilterClear() throws InterruptedException {

        ListingPage listingPage = new ListingPage(driver);
        listingPage.firstCategoryFilter();
        listingPage.categoryFilterSearch1("Peluş");
        listingPage.clickCheckBox();
        listingPage.clickCategoryFilterApply();
        listingPage.waitURLToBe("arama?c=12841&choice=2&query=oyuncak");
        listingPage.clearCategoryFilter();
        listingPage.waitURLToBe("arama?choice=2&query=oyuncak");
        Assert.assertFalse(listingPage.isClearButtonVisible(),"Clear button is visible");

    }

    @Test
    public void searchSuggest() throws InterruptedException {
        ListingPage listingPage = new ListingPage(driver);
        listingPage.searchSuggestionsScroll();
        listingPage.searchSuggestionsSelectCategory();
        Assert.assertEquals(driver.getCurrentUrl(), "https://test1.ciceksepeti.com/arama?query=oyuncak%20erkek&qt=oyuncak%20erkek&OM.zn=q2q","URL does not match");
    }

    @Test
    public void productAddFavorite() throws InterruptedException {
        ListingPage listingPage = new ListingPage(driver);
        listingPage.addFavorite();
        listingPage.waitURLToBe("uye-girisi");
        Assert.assertEquals(driver.getCurrentUrl(), "https://test1.ciceksepeti.com/uye-girisi?returnUrl=%2Farama%3Fquery%3Doyuncak%26qt%3Doyuncak%26choice%3D2","URL does not match");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
