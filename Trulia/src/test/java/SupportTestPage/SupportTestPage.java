package SupportTestPage;

import SupportPage.SupportPage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static SupportPage.SupportWebElements.*;

public class SupportTestPage extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////
    SupportPage help = new SupportPage();
    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test #1
     * @param author
     * @param searchKey
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = SupportPage.class)
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
     * Test #2
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = SupportPage.class)
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
     * Test #3
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsEnabled(){
        help.searchBoxInspectionIsEnabled();
        assertTrueIsEnabled(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsDisplayed(){
        help.searchBoxInspectionIsDisplayed();
        assertTrueIsDisplayed(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsNotSelected(){
        help.searchBoxInspectionIsNotSelected();
        assertFalseIsSelected(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Test #6
     * @throws IOException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testSearchItemsUsingExcel() throws IOException, AWTException {
        help.searchItemsUsingExcel();
        assertTrueIsEnabled(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Test #7
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchFarmHousesUsingMYSQLDB() throws Exception {
        help.searchFarmUsingMYSQLDB();
        assertEqualsGetAttribute("Farm",WEB_ELEMENT_SEARCH_LOCATOR,"value");
    }

    /**
     * Test #8
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignInUsingMYSQLDB() throws Exception {
       try {
           help.signInUsingMYSQLDB();
           assertEqualsGetText("",WEB_ELEMENT_VERIFY_ERROR_SQL);
       } catch (Exception e){
           e.printStackTrace();
       }
    }

    /**
     * Test #9
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchForBeachesUsingExcel() throws Exception {
        help.searchBeachesUsingExcel();
        assertEqualsGetText("No results for \"Beach\"",WEB_ELEMENT_VERIFY_HEADER);
    }

    /**
     * Test #10
     * @throws Exception
     */

    @Test(enabled = false)
    public void SearchUsingExcelNavigateBackToSupportPage() throws Exception {
        help.searchBeachesUsingExcelNavigateToSupportPage();
        assertEqualsGetTitle("trulia");
    }



}
