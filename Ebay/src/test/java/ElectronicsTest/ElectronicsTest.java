package ElectronicsTest;

import ElectronicsHome.DataProviderClass;
import ElectronicsHome.ElectronicsHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static ElectronicsHome.ElectronicsWebElements.*;

public class ElectronicsTest extends WebAPI {

    ///////////////////  Object of Electronics Class /////////////////////
    public static ElectronicsHomePage electronics = new ElectronicsHomePage();
    /////////////////////////////////////////////////////////////////////

    /**
     * Test #1
     * Description: Look for an item in electronics made by google
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testGoogleLinkInElectronics() throws InterruptedException {
        electronics.ElectronicsClickSmartHome();
        Assert.assertEquals(getTextFromElement(webElementVerifyGoogleLinkText),"Google");
    }

    /**
     * Test #2
     * Description: Type 3 different item names in search bar using dataProvider then get the attributes
     * @param author
     * @param searchKey
     * @throws InterruptedException
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = DataProviderClass.class)
    @Ignore
    public void testMethod(String author, String searchKey) throws InterruptedException {
        driver.get(webElementElectronicsUrl);
        WebElement searchText = driver.findElement(By.xpath(webElementSearchBox));
        //Search text in google text box
        searchText.sendKeys(searchKey);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        //get text from search box
        String testValue = searchText.getAttribute(webElementGetAttributeValue);
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        //verify if search box has correct value
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

    }

    /**
     * Test #3
     * Description: Purchase a Arlo Cam using javascriptExecutor,Actions and Robot
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testPurchaseArloWirelessCam() throws InterruptedException {
        electronics.purchaseArloWireFreeSecurityCamera();
        Assert.assertEquals(getTextFromElement(webElementTitleAddedToCart),"1 item added to cart");
    }

    /**
     * Test #4
     * Description: Test functionalities of the left body
     * Using checkbox,radioButton,dropDown, textField & mouseHover
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testFindProductWithin50MilesOf19082() throws InterruptedException, AWTException {
        electronics.findItemWithin50MilesOf19082();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_HEADER_MILES),"50 miles from 19082\n" + "Remove filter");
    }

    /**
     * Test #5
     *  Send Data To Search Bar Using Excel
     *  Verify Attribute of Search Bar When Clicked
     * @throws IOException
     */

    @Test(enabled = false)
    public void testEnterDataIntoSearchNEnterUsingExcel() throws IOException, AWTException, InterruptedException {
        electronics.searchItemUsingExcel();
        Assert.assertEquals(getAttributeFromElement(webElementSearchBox,"class"),"gh-tb ui-autocomplete-input ui-autocomplete-loading");
    }

    /**
     * Test #6
     * @throws Exception
     */

    @Test(enabled = false)
    public void testEnterMacbookInSearchUsingExcel() throws Exception {
        electronics.enterMacBookIntoSearchUsingExcel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR_HEAD,"value"),"Macbook");
    }

    /**
     * Test #7
     * 1.Click on Laptops Link
     * 2.SendKeys To SearchBar Using Excel
     * 3.Click on Checkbox for $230 to $450
     * 4.Click on Affordable Laptop
     * 5.Confirm Affordable Price
     * @throws Exception
     */

    @Test(enabled = false)
    public void testFindAffordableLaptopUsingExcel() throws Exception {
        electronics.findAffordableLaptopUsingExcel();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_MACBOOK_PRICE),"US $419.00");
    }

    /**
     * Test #8
     * @throws Exception
     */

    @Test(enabled = false)
    public void testFindAffordableLaptopUsingMYSQLDB() throws Exception {
        electronics.findAffordableLaptopUsingMYSQLDB();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_MACBOOK_PRICE),"US $419.00");
    }

    /**
     * Test #9
     * Hover over Featured Items Dropdown + getAttribute during Hover
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverFeaturedItems() throws InterruptedException {
        electronics.hoverOverFeaturedItems();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_DROPDOWN_FEATURE_ITEMS,"class"),"srp-controls__control--legacy");
    }

    /**
     * Test #10
     * 1.Hover over Featured Items Dropdown -> click Lowest Price
     * 2.Hover over View Options Dropdown -> click View List
     * 3.Scroll to Element -> click on Chromebook
     * 4.Add to Cart -> verify Added to Cart Text
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverFeaturedItemsNClickLowPrice() throws InterruptedException {
        electronics.hoverOverFeaturedItemsNClick();
        Assert.assertEquals(getTextFromElement(webElementTitleAddedToCart),"1 item added to cart");
    }

    /**
     * Test #11
     * Double click on DropDown
     * Verify if selected after DoubleClick
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testDoubleClickDropDown() throws InterruptedException {
        electronics.doubleClickOnDropDown();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_DROPDOWN_DOUBLE_CLICK));
    }

    /**
     * Test #12
     * Right Click
     */

    @Test(enabled = false)
    public void testRightClickNewArlo(){
        electronics.rightClick();
        Assert.assertEquals(getTitleText(driver.getTitle()),"Electronics products for sale | eBay");
    }

    /**
     * Test #13
     */

    @Test(enabled = false)
    public void testScrollDownUsingRobotClass(){
        electronics.scrollDownPageUsingRobot();
        softAssert.assertTrue(isElementDisplayed(WEB_ELEMENT_SEARCH_BAR_HEAD));
        softAssert.assertAll();
    }

    /**
     * Test #14
     */

    @Test(enabled = false)
    public void testScrollDownToBottomUsingJavaScript(){
        electronics.scrollDownToBottomPageUsingJavaScript();
        softAssert.assertTrue(isElementDisplayed(WEB_ELEMENT_SEARCH_BAR_HEAD));
        softAssert.assertAll();
    }

    /**
     * Test #15
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testScrollDownToElementUsingActions() throws InterruptedException {
        electronics.scrollDownUsingActionsClass();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_HEADER),"Shop by Category");
    }

    /**
     * Test #16
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testScrollToElementUsingJavaScript() throws InterruptedException {
        electronics.scrollDownToElementUsingJavaScript();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_HEADER),"Shop by Category");
    }

}
