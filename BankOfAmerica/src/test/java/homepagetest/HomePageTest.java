package homepagetest;

import common.WebAPI;
import HomePage.HomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static HomePage.HomePageWebElement.*;

public class HomePageTest extends WebAPI {
    // Test class
    HomePage home = new HomePage();
    // Registration registration;


    /**
     * Test #1
     * Refresh Page using Robot Class
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testRobotRefreshPage() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F5);
        sleepFor(5);
        assertEqualsGetTitle("Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }

    /**
     * Test #2
     * Sign in with Invalid Credentials Using Excel
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignInInvalidCredUsingExcel() throws Exception {
        home.signUpUsingExcel();
        assertEqualsGetText(WEB_ELEMENT_VERIFY_ERROR_HEADER, "Forgot ID/Passcode");
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
        home.searchInterestsUsingExcel();
        assertEqualsGetAttribute("Bootcamp404", WEB_ELEMENT_SEARCH_BANK, "value");
    }

    /**
     * Test #4
     * Sign in using MYSQL Database
     *
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignInUsingMYSQLDB() throws Exception {
        home.signInUsingMYSQLDB();
        assertEqualsGetText(WEB_ELEMENT_VERIFY_ERROR_HEADER, "Forgot ID/Passcode");
    }

    /**
     * Test #5
     *
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testPopUpHandling() throws AWTException, InterruptedException {
        home.popUpHandling();
        assertEqualsGetTitle("Bank of America Financial Centers and ATMs");
    }

    /**
     * Test #6
     * Login Using Fluent Wait
     */

    @Test(enabled = false)
    public void testLoginUsingFluentWait() {
        home.signInUsingFluentWait();
        assertEqualsGetTitle("Bank of America | Online Banking | Forgot Online ID & Passcode");
    }

    /**
     * Test #7
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testManageCookies() throws InterruptedException {
        home.manageCookies();
        Cookie actualText = driver.manage().getCookieNamed("BOFA_LOCALE_COOKIE");//actualCookieName
        Assert.assertNotNull(actualText, "\nTest Fail");
    }

    /**
     * Test #8
     */

    @Test(enabled = false)
    public void testChangeLanguagesFromEngToEsp(){
        home.changeLanguageFromEngToEspanol();
        assertEqualsGetTitle("Bank of America: operaciones bancarias, tarjetas de crédito, préstamos e inversiones con Merrill");
    }

    /**
     * Test #9
     */

    @Test(enabled = false)
    public void testCheckBoxIsNotSelectedAfterDoubleClick(){
        home.doubleClickCheckBox();
        assertFalseIsSelected(WEB_ELEMENT_CHECKBOX_SIGN_IN);
    }

    /**
     * Test #10
     * Hover over Cash Card -> Get Attribute
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverCashRewardsImage() throws InterruptedException {
        home.hoverOverCashRewards();
        assertEqualsGetAttribute("card-cta",WEB_ELEMENT_VERIFY_IMAGE_CARD,"class");
    }

    /**
     * Test #11
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testFindFinancialCenterNearMe() throws InterruptedException {
        home.findFinancialCenterNearMe();
        assertEqualsGetText(WEB_ELEMENT_VERIFY_ERROR,"You Are Leaving Bank of America");
    }

    /**
     * Test #12
     * Open Parent Window then Open Incognito Window
     * Close both windows
     */

    @Test(enabled = false)
    public void testIncognitoMode(){
        home.IncognitoMode();
        assertEqualsGetTitle("Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }

    /**
     * Test #13
     * Open Parent Window then Child Window -> Close Child Window
     * Open Incognito Window -> Close Incognito Window -> Close Parent Window
     */

    @Test
    public void testSwitchWindow(){
        home.openParentChildIncognitoWindowNCloseAll();
        assertEqualsGetTitle("Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
    }
}

