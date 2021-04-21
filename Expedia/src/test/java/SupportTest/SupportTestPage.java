package SupportTest;

import SupportHome.SupportHome;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static SupportHome.SupportWebElements.*;

public class SupportTestPage extends WebAPI {

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    SupportHome support = new SupportHome();
    //////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Test #1
     *
     * @param author
     * @param searchKey
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = SupportHome.class)
    @Ignore
    public void testSearchUsingDataProvider(String author, String searchKey) {
        WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_BOX_MAIN));
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }

    /**
     * Test #2
     *
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = SupportHome.class)
    @Ignore
    public void testSearchUsingDataProvider2(String searchKey) {
        WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_BOX_MAIN));
        searchText.sendKeys(searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }

    /**
     * Test #3
     *
     * @param searchKey
     */

    @Test(dataProvider = "SendNumbersForApp", dataProviderClass = SupportHome.class)
    @Ignore
    public void testSendNumberForAppUsingDataProvider(String searchKey) {
        scrollToElementUsingJavaScript(WEB_ELEMENT_ENTRY_APP_SIGN_UP);
        WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_ENTRY_APP_SIGN_UP));
        searchText.sendKeys(searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }

    /**
     * Test #4
     * Scroll to Download Expedia App -> Verify QR Code Image Attribute = "src"
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testScrollToNVerifyQRCodeImage() throws InterruptedException {
        support.scrollToAndIdentifyQRCode();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_IMG_QR_CODE_APP,"src"),"https://a.travel-assets.com/mad-service/qr-code/150/1.jpg");
    }

    /**
     * Test #5
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testVirtualAssistanceChatNow() throws InterruptedException, AWTException {
        support.virtualAssistance();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_VERIFY_HEADER_CHAT_NOW));
    }

    /**
     * Test #6
     * Hover over Contact Us -> Get Attribute
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testContactUs() throws InterruptedException {
        support.checkContactUsLink();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_VERIFY_CONTACT_US,"class"),"virtual-travel-agent");
    }

    /**
     * Test #7
     * Change Language And Region -> Save & Get Title of Page
     */

    @Test(enabled = false)
    public void testChangeLanguageAndRegion(){
        support.changeLanguageAndRegion();
        Assert.assertEquals(getTitleText(driver.getTitle()),"Expedia: aluguéis de temporada, hotéis, aluguel de carros, voos e mais");
    }

    /**
     * Test #8
     * Get Current Page Url
     */

    @Test(enabled = false)
    public void testCurrentUrl(){
        getCurrentPageUrl();
        System.out.println("Current Url : "+getCurrentPageUrl());
        Assert.assertTrue(isCurrentUrlTrue("https://www.expedia.com/service/"));
    }

    /**
     * Test #9
     * Search items using Excel
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSendMultipleSearchItemsUsingExcel() throws Exception {
        support.searchInterestsUsingExcel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BOX_MAIN,"value"),"Food");
    }

    /**
     * Test #10
     * Search Items + Enter -> Refresh Page
     * @throws IOException
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testSearchItemsUsingExcelPart2() throws IOException, AWTException{
        support.searchInterestsUsingExcelPart2();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_SEARCH_BOX_MAIN));
    }

    /**
     * Test #11
     * Search Items + Enter -> Refresh Page
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchItemsUsingMYSQLDB() throws Exception {
        support.searchItemsUsingMYSQLDB();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BOX_MAIN,"value"),"Farm");
    }

    /**
     * Test #12
     * Scroll to Expedia Rewards using JavaScriptExecutor
     */

    @Test(enabled = false)
    public void testScrollToExpediaRewards() throws InterruptedException {
        support.scrollToExpediaRewards();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_EXPEDIA_REWARDS),"What is Expedia Rewards?");
    }
}
