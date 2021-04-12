package homepage;

import BOADataDriver.DataSource;
import common.WebAPI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static homepage.HomePageWebElement.*;

public class HomePage extends WebAPI {

    public HomePage() {
        PageFactory.initElements(driver, this);

        /////////////////////////////////////////////////////////////////////////////////////////

        //Robot Available for All Below Methods
        Robot robot;

        {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

        //JavaScriptExecutor available for all below methods
        JavascriptExecutor js;

        {
            try {
                js = (JavascriptExecutor) driver;
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Actions available for all below methods
            Actions actions;

            {
                try {
                    actions = new Actions(driver);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (xpath = searchBoxLocator ) public WebElement searchBox;
//    @FindBy (how = How.XPATH, using =searchButtonLocator ) public WebElement searchButton;
//    @FindBy (how = How.XPATH, using =searchTextLocator ) public WebElement searchText;

        // Action Method
    }

    /**
     * Action Method #1
     *
     * @throws Exception
     */

    public void signUpUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String username = elementFromExcel.get(1);
        typeOnElement(WEB_ELEMENT__ENTRY_USERNAME, username);
        WebDriverWait0(10);
        String password = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_ENTRY_PASSWORD, password);
    }

    /**
     * Action Method #2
     *
     * @throws IOException
     * @throws AWTException
     */

    public void searchInterestsUsingExcel() throws IOException, AWTException {
        WebDriverWait0(20);
        enterExcelDataInSearchNRefreshBOA();
    }

    /**
     * Action Method #3
     *
     * @throws Exception
     */

    public void signInUsingMYSQLDB() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String username = elementFromDatabase.get(0);
        typeOnElement(WEB_ELEMENT__ENTRY_USERNAME, username);
        WebDriverWait0(10);
        String password = elementFromDatabase.get(1);
        typeOnElementNEnter(WEB_ELEMENT_ENTRY_PASSWORD, password);
    }

    /**
     * Action Method #4
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    public void popUpHandling() throws InterruptedException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        clickByXpath(WEB_ELEMENT_LINK_APPOINTMENT);
        js.executeScript("window.scrollBy(0,200)");
        js.executeScript("window.scrollBy(0,200)");
        js.executeScript("window.scrollBy(0,200)");
        js.executeScript("window.scrollBy(0,200)");
        clickByXpath(WEB_ELEMENT_CLICK_APPOINTMENT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        //Robot Clicks On Enter Button in The Keyboard
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    /**
     * Action Method #5
     */

    public void signInUsingFluentWait() {
        typeOnElement(WEB_ELEMENT__ENTRY_USERNAME, WEB_ELEMENT_SEND_KEYS_USER);
        waitTimeUsingFluent(WEB_ELEMENT_ENTRY_PASSWORD);
        typeOnElementNEnter(WEB_ELEMENT_ENTRY_PASSWORD, WEB_ELEMENT_SEND_KEYS_PASS);
    }

    /**
     * Action Method #6
     *
     * @throws InterruptedException
     */

    public void manageCookies() throws InterruptedException {
//        driver.manage().getCookies();   // Return The List of all cookies
//        driver.manage().deleteAllCookies();  // Delete all cookies
        driver.manage().getCookieNamed("BOFA_LOCALE_COOKIE=en-US");
    }

    /**
     * Action Method #7
     */

    public void changeLanguageFromEngToEspanol() {
        WebWaitUntilClickableNClick(20, WEB_ELEMENT_LINK_LANGUAGES);
    }

    /**
     * Action Method #8
     */

    public void doubleClickCheckBox() {
        doubleClickUsingXAndCSS(WEB_ELEMENT_CHECKBOX_SIGN_IN);
    }

    /**
     * Action Method #9
     */

    public void hoverOverCashRewards() {
        basicHoverUsingXpath(WEB_ELEMENT_IMAGE_CARD);
    }

    /**
     * Action Method #10
     *
     * @throws InterruptedException
     */

    public void findFinancialCenterNearMe() throws InterruptedException {//needs work
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_NEAR_ME);
        WebDriverWait0(20);
        clickByXpathUsingJavaScript(WEB_ELEMENT_MAP_NEAR_ME);
    }

    public void IncognitoMode() {
        try {
            IncognitoMode(WEB_ELEMENT_URL_BOA);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** Incognito Mode Failed ***");
        } finally {
            driver.manage().window().setPosition(new Point(0, -2000));
        }
    }

    public void openParentChildIncognitoWindowNCloseAll() {
        try {
            openNewWindow(WEB_ELEMENT_URL_BOA);
            switchWindows();
            WebDriverWait0(20);
            driver.manage().window().setPosition(new Point(0, -2000));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(getCurrentPageUrl());
        }finally {
        IncognitoMode();
            driver.manage().window().setPosition(new Point(0, -2000));
        }
    }
    }























