package homepagetest;

import common.WebAPI;
import HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static HomePage.HomePageWebElement.*;

public class HomePageTest extends WebAPI {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    HomePage home = new HomePage();
    ////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Test #1
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testGetCurrentUrl() throws AWTException, InterruptedException {
        home.getCurrentSiteUrl();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.airbnb.com/");
    }

    /**
     * Test #2
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testLocationSearchFieldIsEnabled() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #3
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testLocationSearchFieldIsDisplayed() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #4
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testLocationSearchFieldIsSelected() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #5
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testLocationSearchFieldGetAttribute() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_LOCATOR, "value"),"bootcamp404");
    }

    /**
     * Test #6
     *
     * @param author
     * @param searchKey
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = HomePage.class)
    @Ignore
    public void testSearchUsingDataProvider(String author, String searchKey) throws InterruptedException, AWTException {
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
     * Test #7
     *
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = HomePage.class)
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
     * Test #8
     *
     * @throws IOException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testSearchUsingExcel() throws IOException, AWTException {
        home.searchItemsUsingExcel();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #9
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchCottageRoomingUsingExcel() throws Exception {
        home.searchCottageUsingExcel();
        try {
            Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_VERIFY_COTTAGE_HEADER));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_VERIFY_COTTAGE_HEADER2));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Test #10
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchCottageUsingExcelNSwitchTab() throws Exception {
        home.searchCottageUsingExcelSwitchTabs();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_STAYS_IN_BEACH),"Stays in Beach");
    }

    /**
     * Test #11
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchFarmUsingMYSQLDB() throws Exception {
        home.searchFarmUsingMYSQLDB();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_LOCATOR, "value"),"Farm");
    }

    /**
     * Test #12
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignUpUsingMYSQLDB() throws Exception {
        home.signUpUsingMYSQLDB();
        try {
            Assert.assertEquals(getTextFromElement(WEB_ELEMENT_ERROR_NUMBER_HEADER),"You'll need to use a different phone number, we can't support this one.");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Assert.assertEquals(getTextFromElement(WEB_ELEMENT_RECAPTCHA_HEADER),"Check the box to verify that you're human.");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Test #13
     * Enter Search "Farm" Using MYSQLDB -> Calendar Picker -> Submit -> Verify
     * @throws Exception
     */

    @Test(enabled = false)
    public void testFindFarmNCalendarPickDateUsingMYSQLDB() throws Exception {
        home.findADateUsingCalendarPicker();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_FARM_HEADER),"Stays in Farmington");
    }

    /**
     * Test #14
     * Enter in Search "farm" -> Submit -> Price Button -> Adjust Price using Drag And Drop
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testDragPrice() throws InterruptedException {
        home.dragPrice();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_VERIFY_PRICE,"value"),"108");
    }

    /**
     * Test #15
     * @throws Exception
     */

    @Test(enabled = false)
    public void testFindARoomUsingMYSQLDB() throws Exception {
        home.searchViewsUsingMYSQLDB();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_LOCATOR,"value"),"Views");
    }
}


