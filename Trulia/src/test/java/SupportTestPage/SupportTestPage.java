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
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsDisplayed(){
        help.searchBoxInspectionIsDisplayed();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testSearchBoxInspectionIsNotSelected(){
        help.searchBoxInspectionIsNotSelected();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #6
     * @throws IOException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testSearchItemsUsingExcel() throws IOException, AWTException {
        help.searchItemsUsingExcel();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_SEARCH_LOCATOR));
    }

    /**
     * Test #7
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchFarmHousesUsingMYSQLDB() throws Exception {
        help.searchFarmUsingMYSQLDB();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_LOCATOR,"value"),"Farm");
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

    @Test(enabled = true)
    public void testSearchForBeachesUsingExcel() throws Exception {
        help.searchBeachesUsingExcel();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_HEADER),"No results for \"Beach\"");
    }

    /**
     * Test #10
     * @throws Exception
     */

    @Test(enabled = false)
    public void SearchUsingExcelNavigateBackToSupportPage() throws Exception {
        help.searchBeachesUsingExcelNavigateToSupportPage();
        Assert.assertEquals(getTitleText(driver.getTitle()),"trulia");
    }

    /**
     * Test #11
     */

    @Test(enabled = false)
    public void testClickOnLogoImage(){
        help.clickOnImageLogo();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_LOGO_TRULIA));
    }

    /**
     * Test #12
     */

    @Test(enabled = false)
    public void testLogoIsClickable(){
        help.clickOnImageLogo();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_LOGO_TRULIA));
    }



}
