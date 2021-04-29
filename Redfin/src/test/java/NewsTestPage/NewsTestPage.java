package NewsTestPage;

import NewsPage.NewsPage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static NewsPage.NewsWebElements.*;

public class NewsTestPage extends WebAPI {

    ////////////////////////////////////////
    NewsPage news = new NewsPage();
    SoftAssert softAssert = new SoftAssert();
    ///////////////////////////////////////


    /**
     * Test #1
     *
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = NewsPage.class)
    @Ignore
    public void testSearchUsingDataProvider2(String searchKey) {
        try {
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_LOCATOR));
            WebDriverWait0(20);
            searchText.sendKeys(searchKey);
            String testValue = searchText.getAttribute("value");
            searchText.clear();
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
        }
    }

    /**
     * Test #2
     *
     * @param searchKey
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = NewsPage.class)
    @Ignore
    public void testSearchUsingDataProvider(String searchKey) {
        try {
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_LOCATOR));
            clickUsingJavaScript(WEB_ELEMENT_SEARCH_LOCATOR);
            WebDriverWait0(20);
            searchText.sendKeys(searchKey);
            String testValue = searchText.getAttribute("value");
            WebDriverWait0(20);
            clearInput(WEB_ELEMENT_SEARCH_LOCATOR);
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
        }
    }

    /**
     * Test #3
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsDisplayed() {
        news.searchBoxInspectionIsDisplayed();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsEnabled() {
        news.searchBoxInspectionIsEnabled();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testScrollDownToElementUsingJavaScript() {
        news.scrollToElementUsingJS();
        try {
            softAssert.assertEquals(getTextFromElement(WEB_ELEMENT_HEADER_HOUSE),"Housing Market");
            softAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test #6
     */

    @Test(enabled = false)
    public void testHoverOverSellDropDownNSelectItemInList() {
        news.hoverOverDropDownAndSelectSellingWorthIt();
        softAssert.assertEquals(getTextFromElement(WEB_ELEMENT_HEADER_SELLING),"What Can I Make from Selling My Home?");
        softAssert.assertAll();
    }

    /**
     * Test #7
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testNewsLetterValidCredsEnterKeysUsingMYSQLDB() throws Exception {
        news.newsLetterValidCredsEnterKeysUsingMYSQLDB();
        softAssert.assertEquals(getTextFromElement(WEB_ELEMENT_CONFIRMATION_MESSAGE), "Thanks for signing up for Redfin updates.");
        softAssert.assertAll();
    }

    /**
     * Test #8
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testNewsLetterInvalidCredsEnterKeysUsingMYSQLDB() throws Exception {
        news.newsLetterInvalidCredsEnterKeysUsingMYSQLDB();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_ERROR_MESSAGE),"Please enter a valid email address.");
    }

    /**
     * Test #9
     */

    @Test(enabled = false)
    public void testCurrentPageUrl() {
        softAssert.assertTrue(isCurrentUrlTrue("https://www.redfin.com/news/"));
    }

    /**
     * Test #10
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSendKeysToSearchBarUsingMYSQLDB() throws Exception {
        news.sendKeysToSearchUsingMYSQLDB();
        softAssert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_LOCATOR, "value"),"Farm");
        softAssert.assertAll();
    }

    /**
     * Test #11
     */

    @Test(enabled = false)
    public void testNavigateToNewsPage() throws InterruptedException {
        news.navigateToNewsPage();
        softAssert.assertTrue(isCurrentUrlTrue("https://www.redfin.com/news/"));
        softAssert.assertAll();
    }

    /**
     * Test #12
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchUsingMYSQLDBAndSwitchToChildWindow() throws Exception {
        news.handleNewWindow();
        softAssert.assertTrue(isElementDisplayed(WEB_ELEMENT_KING_FARM));
        softAssert.assertAll();
    }

    /**
     * Test #13
     */

    @Test(enabled = false)
    public void testVerifyPageTitle() {
        String exp = "REDFIN REAL ESTATE NEWS";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));

    }

    /**
     * Test #14
     */

    @Test(enabled = false)
    public void testPageTitleInspection() {
        String expectedTitle = "Redfin Real Estate News";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }
}
