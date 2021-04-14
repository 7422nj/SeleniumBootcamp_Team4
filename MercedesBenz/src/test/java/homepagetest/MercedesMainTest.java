package homepagetest;

import common.WebAPI;
import HomePage.MercedesMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static HomePage.MercedesMainWebElement.*;

public class MercedesMainTest extends WebAPI {
    // Test class
    MercedesMainPage benz = new MercedesMainPage();
////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test #1
     * @throws Exception
     */

    @Test(enabled = false)
    public void testRegisterAccountInvalidCredsUsingExcel() throws Exception {
       benz.registerAccountInvalidCredsUsingExcel();
       assertEqualsGetText("The notification could not be delivered. Please check that the e-mail address exists and that it can receive e-mails, then try again later.",WEB_ELEMENT_VERIFY_ERROR_REGISTER);
    }

    /**
     * Test #2
     * @throws Exception
     */

    @Test(enabled = false)
    public void testRegisterAccountValidCredsUsingExcel() throws Exception {
        benz.registerAccountValidCredsUsingExcel();
        assertEqualsGetText("We have sent you a confirmation code to pritamdas15217@gmail.com for the purpose of verification. Please enter the code to complete the account opening process.",WEB_ELEMENT_VERIFY_VALID);
    }

    /**
     * Test #3
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchInterestUsingExcel() throws Exception {
        benz.searchInterestsUsingExcel();
        assertEqualsGetAttribute("Finest", WEB_ELEMENT_INPUT_SEARCH_FIELD,"value");
    }

    /**
     * Test #4
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = MercedesMainPage.class)
    @Ignore
    public void testSearchUsingDataProvider(String searchKey) {
        try {
            clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH);
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_INPUT_SEARCH_FIELD));
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
     * Test #5
     * @param author
     * @param searchKey
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = MercedesMainPage.class)
    @Ignore
    public void testSearchUsingDataProvider2(String author, String searchKey) throws InterruptedException, AWTException {
        try {
            clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH);
            WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_INPUT_SEARCH_FIELD));
            WebDriverWait0(20);
            searchText.sendKeys(searchKey);
            String testValue = searchText.getAttribute("value");
            WebDriverWait0(20);
            clearInput(WEB_ELEMENT_INPUT_SEARCH_FIELD);
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
        }
    }

    /**
     * Test #6
     * @throws IOException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testSearchItemsUsingExcel() throws IOException, AWTException {
        benz.searchItemsUsingExcel();
        assertFalseIsSelected(WEB_ELEMENT_INPUT_SEARCH_FIELD);
    }

    /**
     * Test #7
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchItemUsingMYSQLDB() throws Exception {
        benz.searchItemUsingMYSQLDB();
        assertEqualsGetAttribute("Auto Pilot",WEB_ELEMENT_INPUT_SEARCH_FIELD,"value");
    }

    /**
     * Test #8
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSubscribeToReceivingNewsUsingMYSQLDB() throws Exception {
        benz.subscribeToReceivingNewsInvalidEmailUsingMYSQLDB();
        assertEqualsGetText("Invalid email address", WEB_ELEMENT_VERIFY_INVALID_EMAIL);
    }

    /**
     * Test #9
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSubscribeToReceivingNewsValidEmailUsingMYSQLDB() throws Exception {
        benz.subscribeToReceivingNewsValidEmailUsingMYSQLDB();
        assertEqualsGetText("Thank you for subscribing. Please check your email to verify your subscription.",WEB_ELEMENT_VERIFY_VALID_EMAIL);
    }

    /**
     * Test #10
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchNearbyDealersUsingMYSQLDB() throws Exception {
        benz.findADealerNearbyUsingMYSQLDB();
        assertEqualsGetText("214 West Lancaster Ave.\n" +
                "Devon, PA, 19333",WEB_ELEMENT_BUTTON_VERIFY_LOCATION);
    }

    /**
     * Test #11
     */

    @Test(enabled = false)
    public void testNavigateBackToMainPage(){
        benz.NavigateBackToMainPage();
        assertEqualsGetCurrentUrl("https://www.mbusa.com/en/home?search=boot");
    }

    /**
     * Test #12
     */

    @Test
    public void testHoverOverNearbyDealersNVerifyIsDisplayed(){
        benz.hoverOverNearbyDealers();
        assertTrueIsDisplayed(WEB_ELEMENT_BUTTON_NEARBY);
    }

    /**
     * Test #13
     */

    @Test
    public void testHoverOverNearbyDealersNVerifyIsNotSelected() {
        benz.hoverOverNearbyDealers();
        assertFalseIsSelected(WEB_ELEMENT_BUTTON_NEARBY);
    }

    /**
     * Test #14
     */

    @Test
    public void testHoverOverNearbyDealersNVerifyIsEnabled() {
        benz.hoverOverNearbyDealers();
        assertTrueIsEnabled(WEB_ELEMENT_BUTTON_NEARBY);
    }

    }

