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
    ElectronicsHomePage electronics = new ElectronicsHomePage();
    /////////////////////////////////////////////////////////////////////

    /**
     * Test #1
     * Description: Look for an item in electronics made by google
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testGoogleLinkInElectronics() throws InterruptedException {
        electronics.ElectronicsClickSmartHome();
        String expectedText = "Google";
        assertEqualByXpath(webElementVerifyGoogleLinkText,expectedText);

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
     */

    @Test(enabled = false)
    public void testPurchaseArloWirelessCam() throws InterruptedException {
        electronics.purchaseArloWireFreeSecurityCamera();
        String expectedText = "1 item added to cart";
        assertEqualByXpath(webElementTitleAddedToCart,expectedText);

    }

    /**
     * Test #4
     * Description: Test functionalities of the left body
     * Using checkbox,radioButton,dropDown, textField & mouseHover
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testFindProductWithin50MilesOf19082() throws InterruptedException, AWTException {
        electronics.findItemWithin50MilesOf19082();
        String expectedText = "50 miles from 19082\n" +
                "Remove filter";
        assertEqualByXpath(WEB_ELEMENT_VERIFY_HEADER_MILES,expectedText);

    }

    /**
     * Test #5
     *  Send Data To Search Bar Using Excel
     *  Verify Attribute of Search Bar When Clicked
     * @throws IOException
     */

    @Test(enabled = true)
    public void enterDataIntoSearchNEnterUsingExcel() throws IOException, AWTException, InterruptedException {
        electronics.searchItemUsingExcel();
        assertEqualsGetAttribute("gh-tb ui-autocomplete-input ui-autocomplete-loading",webElementSearchBox,"class");

    }

    /**
     * Test #6
     * @throws Exception
     */

    @Test(enabled = false)
    public void enterMacbookInSearchUsingExcel() throws Exception {
        electronics.enterMacBookIntoSearchUsingExcel();
        assertEqualByXpath(WEB_ELEMENT_SEARCH_BAR,"Macbook");
    }
}
