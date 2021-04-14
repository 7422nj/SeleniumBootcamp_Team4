package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static homepage.HomePageWebElement.*;

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
        assertEqualsGetCurrentUrl("https://www.airbnb.com/");
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
        assertTrueIsEnabled(WEB_ELEMENT_SEARCH_LOCATOR);
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
        assertTrueIsDisplayed(WEB_ELEMENT_SEARCH_LOCATOR);
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
        assertFalseIsSelected(WEB_ELEMENT_SEARCH_LOCATOR);
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
        assertEqualsGetAttribute("bootcamp404", WEB_ELEMENT_SEARCH_LOCATOR, "value");
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
        assertFalseIsSelected(WEB_ELEMENT_SEARCH_LOCATOR);
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
            assertTrueIsDisplayed(WEB_ELEMENT_VERIFY_COTTAGE_HEADER);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                assertTrueIsDisplayed(WEB_ELEMENT_VERIFY_COTTAGE_HEADER2);
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
        assertEqualsGetText("Stays in Beach", WEB_ELEMENT_VERIFY_STAYS_IN_BEACH);

    }

    /**
     * Test #11
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchFarmUsingMYSQLDB() throws Exception {
        home.searchFarmUsingMYSQLDB();
        assertEqualsGetAttribute("Farm", WEB_ELEMENT_SEARCH_LOCATOR, "value");
    }

    /**
     * Test #12
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignUpUsingMYSQLDB() throws Exception {
        home.signUpUsingMYSQLDB();
        try {
            assertEqualsGetText("You'll need to use a different phone number, we can't support this one.", WEB_ELEMENT_ERROR_NUMBER_HEADER);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                assertEqualsGetText("Check the box to verify that you're human.", WEB_ELEMENT_RECAPTCHA_HEADER);
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
        assertEqualsGetText("Stays in Farmington", WEB_ELEMENT_VERIFY_FARM_HEADER);
    }

    /**
     * Test #14
     * Enter in Search "farm" -> Submit -> Price Button -> Adjust Price using Drag And Drop
     * @throws InterruptedException
     */

    @Test
    public void testDragPrice() throws InterruptedException {
        home.dragPrice();
        assertEqualsGetAttribute("108",WEB_ELEMENT_VERIFY_PRICE,"value");

    }
}


