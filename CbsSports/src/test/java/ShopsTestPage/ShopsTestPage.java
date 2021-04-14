package ShopsTestPage;

import ShopsPage.ShopsPage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;

import static ShopsPage.ShopsWebElements.*;

public class ShopsTestPage extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////
    ShopsPage shop = new ShopsPage();
    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test #1
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testFindPerfectEaglesJerseyUsingWebTable() throws InterruptedException, AWTException {
        shop.findPerfectEaglesJerseyUsingSizeTable();
        assertEqualsGetAttribute("Size S",WEB_ELEMENT_VERIFY_SMALL,"aria-label");
    }

    /**
     * Test #2
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverNFLButton() throws InterruptedException {
        shop.hoverOverNFLButton();
        assertEqualsGetAttribute("top-nav-league-icon logo-nfl logo-c",WEB_ELEMENT_BUTTON_NFL,"class");
    }

    /**
     * Test #3
     */

    @Test(enabled = false)
    public void testNFLButtonIsDisplayed(){
        shop.hoverOverNFLButton();
        assertTrueIsDisplayed(WEB_ELEMENT_BUTTON_NFL);
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testNFLButtonIsEnabled(){
        shop.hoverOverNFLButton();
        assertTrueIsEnabled(WEB_ELEMENT_BUTTON_NFL);
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testNFLButtonIsNotSelected(){
        shop.hoverOverNFLButton();
        assertFalseIsSelected(WEB_ELEMENT_BUTTON_NFL);
    }

    /**
     * Test #6
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSendKeysToSearchField() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        assertEqualsGetAttribute("Bootcamp404",WEB_ELEMENT_INPUT_SEARCH_BAR,"value");
    }

    /**
     * Test #7
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchFieldIsDisplayed() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        assertTrueIsDisplayed(WEB_ELEMENT_INPUT_SEARCH_BAR);
    }

    /**
     * Test #8
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchFieldIsEnabled() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        assertTrueIsEnabled(WEB_ELEMENT_INPUT_SEARCH_BAR);
    }

    /**
     * Test #9
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchFieldIsSelected() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        assertFalseIsSelected(WEB_ELEMENT_INPUT_SEARCH_BAR);
    }

    /**
     * Test #10
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = ShopsPage.class)
    @Ignore
    public void testSearchUsingDataProvider(String searchKey) {
        try {
            clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_SEARCH_BAR);
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_INPUT_SEARCH_BAR));
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
     * Test #11
     * @param author
     * @param searchKey
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = ShopsPage.class)
    @Ignore
    public void testSearchUsingDataProvider2(String author, String searchKey) throws InterruptedException, AWTException {
        try {
            clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_SEARCH_BAR);
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_INPUT_SEARCH_BAR));
            WebDriverWait0(20);
            searchText.sendKeys(searchKey);
            String testValue = searchText.getAttribute("value");
            WebDriverWait0(20);
            clearInput(WEB_ELEMENT_INPUT_SEARCH_BAR);
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
        }
    }

    /**
     * Test #12
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test
    public void navigateBackToShopsPage() throws AWTException, InterruptedException {
        shop.navigateBackToShopsPage();
        assertEqualsGetCurrentUrl("https://www.fanatics.com/");
    }


}
