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
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_VERIFY_SMALL,"aria-label"),"Size S");
    }

    /**
     * Test #2
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverNFLButton(){
        shop.hoverOverNFLButton();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_BUTTON_NFL,"class"),"top-nav-league-icon logo-nfl logo-c");
    }

    /**
     * Test #3
     */

    @Test(enabled = false)
    public void testNFLButtonIsDisplayed(){
        shop.hoverOverNFLButton();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_BUTTON_NFL));
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testNFLButtonIsEnabled(){
        shop.hoverOverNFLButton();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_BUTTON_NFL));
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testNFLButtonIsNotSelected(){
        shop.hoverOverNFLButton();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_BUTTON_NFL));
    }

    /**
     * Test #6
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSendKeysToSearchField() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_INPUT_SEARCH_BAR,"value"),"Bootcamp404");
    }

    /**
     * Test #7
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchFieldIsDisplayed() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_INPUT_SEARCH_BAR));
    }

    /**
     * Test #8
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchFieldIsEnabled() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_INPUT_SEARCH_BAR));
    }

    /**
     * Test #9
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchFieldIsSelected() throws AWTException, InterruptedException {
        shop.sendKeysToSearchField();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_INPUT_SEARCH_BAR));
    }

    /**
     * Test #10
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = ShopsPage.class)
    @Ignore
    public void testSearchUsingDataProvider(String searchKey) {
        try {
            clickUsingJavaScript(WEB_ELEMENT_INPUT_SEARCH_BAR);
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
            clickUsingJavaScript(WEB_ELEMENT_INPUT_SEARCH_BAR);
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
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.fanatics.com/");
    }


}
