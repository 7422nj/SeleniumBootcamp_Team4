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
     * @param searchKey
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = NewsPage.class)
    @Ignore
    public void testSearchUsingDataProvider(String searchKey){
        try {
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_LOCATOR));
            clickByXNCssUsingJavaScript(WEB_ELEMENT_SEARCH_LOCATOR);
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
    public void testSearchBoxInspectionIsDisplayed(){
        news.searchBoxInspectionIsDisplayed();
        softAssertAssertTrueIsDisplayed(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsEnabled(){
        news.searchBoxInspectionIsEnabled();
        assertTrueIsEnabled(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testScrollDownToElementUsingJavaScript(){
        news.scrollToElementUsingJS();
        try {
            softAssertAssertEqualsGetText("Housing Market", WEB_ELEMENT_HEADER_HOUSE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test #6
     */

    @Test(enabled = false)
    public void testHoverOverSellDropDownNSelectItemInList(){
        news.hoverOverDropDownAndSelectSellingWorthIt();
        assertEqualsGetText("What Can I Make from Selling My Home?",WEB_ELEMENT_HEADER_SELLING);
    }

    /**
     * Test #7
     * @throws Exception
     */

    @Test(enabled = false)
    public void testNewsLetterValidCredsEnterKeysUsingMYSQLDB() throws Exception {
        news.newsLetterValidCredsEnterKeysUsingMYSQLDB();
        assertEqualsGetText("Thanks for signing up for Redfin updates.",WEB_ELEMENT_CONFIRMATION_MESSAGE);
    }

    /**
     * Test #8
     * @throws Exception
     */

    @Test(enabled = false)
    public void testNewsLetterInvalidCredsEnterKeysUsingMYSQLDB() throws Exception {
        news.newsLetterInvalidCredsEnterKeysUsingMYSQLDB();
        assertEqualsGetText("Please enter a valid email address.",WEB_ELEMENT_ERROR_MESSAGE);
    }

    /**
     * Test #9
     */

    @Test(enabled = false)
    public void testCurrentPageUrl(){
        assertEqualsGetCurrentUrl("https://www.redfin.com/news/");
    }

    /**
     * Test #10
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSendKeysToSearchBarUsingMYSQLDB() throws Exception {
        news.sendKeysToSearchUsingMYSQLDB();
        assertEqualsGetAttribute("Farm",WEB_ELEMENT_SEARCH_LOCATOR,"value");
    }

    /**
     * Test #11
     */

    @Test(enabled = true)
    public void testNavigateToNewsPage() throws InterruptedException {
        news.navigateToNewsPage();
        assertEqualsGetCurrentUrl("https://www.redfin.com/news/");
    }

    /**
     * Test #12
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchUsingMYSQLDBAndSwitchToChildWindow() throws Exception {
        news.handleNewWindow();
       softAssertAssertTrueIsDisplayed(WEB_ELEMENT_KING_FARM);
    }

    /**
     * Test #13
     */

    @Test(enabled = false)
    public void testVerifyPageTitle(){
        //Page Title in All Caps
        String exp = "REDFIN REAL ESTATE NEWS";
        //Receives Actual Title of Page
        String act = driver.getTitle();
        //Compares 2 Strings -> equalsIgnoreCase Will Compare Strings Even If in Higher or Lower Case
        Assert.assertTrue(exp.equalsIgnoreCase(act));

    }

    /**
     * Test #14
     */

    @Test(enabled = false)
    public void testPageTitleInspection(){
        String expectedTitle = "Redfin Real Estate News";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle,expectedTitle);
        softAssert.assertAll();
    }
}