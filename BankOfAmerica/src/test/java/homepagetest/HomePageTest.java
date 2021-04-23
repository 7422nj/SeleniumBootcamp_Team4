package homepagetest;

import HomePage.BankOfAmericaPage;
import common.WebAPI;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static HomePage.BankOfAmericaWebElement.*;

public class HomePageTest extends WebAPI {

    ////////////////////////////////////////////
    public static BankOfAmericaPage bank = new BankOfAmericaPage();
    ///////////////////////////////////////////


    /**
     * Test #1
     * Refresh Page using Robot Class
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testRobotRefreshPage() throws InterruptedException, AWTException {
        refresh();
        Assert.assertEquals(driver.getTitle(),"Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }

    /**
     * Test #2
     * Sign in with Invalid Credentials Using Excel
     * @throws Exception
     */

    @Test(enabled = true)
    public void testSignInInvalidCredUsingExcel() throws Exception {
        bank.signUpUsingExcel();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_ERROR_HEADER),"Forgot ID/Passcode");
    }

    /**
     * Test #3
     * Search Multiple Items in Search Bar using Excel
     *
     * @throws IOException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testSearchInterestsUsingExcel() throws IOException, AWTException, InterruptedException {
        bank.searchInterestsUsingExcel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BANK, "value"),"Bootcamp404");
    }

    /**
     * Test #4
     * Sign in using MYSQL Database
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignInUsingMYSQLDB() throws Exception {
        bank.signInUsingMYSQLDB();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_ERROR_HEADER),"Forgot ID/Passcode");
    }

    /**
     * Test #5
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testPopUpHandling() throws AWTException, InterruptedException {
        bank.popUpHandling();
        Assert.assertEquals(driver.getTitle(),"Bank of America Financial Centers and ATMs");
    }

    /**
     * Test #6
     * Login Using Fluent Wait
     */

    @Test(enabled = false)
    public void testLoginUsingFluentWait() {
        bank.signInUsingFluentWait();
        Assert.assertEquals(driver.getTitle(),"Bank of America | Online Banking | Forgot Online ID & Passcode");
    }

    /**
     * Test #7
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testManageCookies() throws InterruptedException {
        bank.manageCookies();
        Cookie actualText = driver.manage().getCookieNamed("BOFA_LOCALE_COOKIE");
        Assert.assertNotNull(actualText, "\nTest Fail");
    }

    /**
     * Test #8
     */

    @Test(enabled = false)
    public void testChangeLanguagesFromEngToEsp(){
        bank.changeLanguageFromEngToEspanol();
        Assert.assertEquals(driver.getTitle(),"Bank of America: operaciones bancarias, tarjetas de crédito, préstamos e inversiones con Merrill");
    }

    /**
     * Test #9
     */

    @Test(enabled = false)
    public void testCheckBoxIsNotSelectedAfterDoubleClick(){
        bank.doubleClickCheckBox();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_CHECKBOX_SIGN_IN));
    }

    /**
     * Test #10
     * Hover over Cash Card -> Get Attribute
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverCashRewardsImage() throws InterruptedException {
        bank.hoverOverCashRewards();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_VERIFY_IMAGE_CARD,"class"),"card-cta");
    }

    /**
     * Test #11
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testFindFinancialCenterNearMe() throws InterruptedException {
        bank.findFinancialCenterNearMe();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_ERROR),"You Are Leaving Bank of America");
    }

    /**
     * Test #12
     * Open Parent Window then Open Incognito Window
     * Close both windows
     */

    @Test(enabled = false)
    public void testIncognitoMode(){
        bank.IncognitoMode();
        Assert.assertEquals(driver.getTitle(),"Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }

    /**
     * Test #13
     * Open Parent Window then Child Window -> Close Child Window
     * Open Incognito Window -> Close Incognito Window -> Close Parent Window
     */

    @Test(enabled = false)
    public void testSwitchWindow(){
        bank.openParentChildIncognitoWindowNCloseAll();
        Assert.assertEquals(driver.getTitle(),"Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }
}

