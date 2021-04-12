package SupportHome;

import SupportHome.SupportDataDriver.DataSource;
import common.WebAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import java.awt.*;
import java.io.IOException;
import java.util.List;

import static SupportHome.SupportWebElements.*;


public class SupportHome extends WebAPI {

    public SupportHome() {
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
        //WEB_ELEMENT_SEARCH_BOX_MAIN
//    @FindBy (how = How.XPATH, using =searchButtonLocator ) public WebElement searchButton;
//    @FindBy (how = How.XPATH, using =searchTextLocator ) public WebElement searchText;

        // Action Method
    }

    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Pritam", "Cottage"},
                {"George", "Farm House"},
                {"Achene", "Room Service"},
                {"Nabila", "Has Pool"},
                {"Mariam", "Near City"}
        };
    }

    @DataProvider(name = "SearchInterests")
    public static Object[] searchUsingDataProvider() {
        return new Object[]{
                "Beach",
                "Views",
                "Nature",
                "Travel",
                "Condo"
        };
    }

    @DataProvider(name = "SendNumbersForApp")
    public static Object[] sendNumbersUsingDataProvider() {
        return new Object[]{
                "4846788989",
                "2345668787",
                "1625262535",
                "8972728891",
                "2677172822"
        };
    }

    public void scrollToAndIdentifyQRCode() {
        scrollToElementUsingJavaScript(WEB_ELEMENT_IMG_QR_CODE_APP);
    }

    public void virtualAssistance() throws InterruptedException, AWTException {
        refresh();
        implicitWait(10);
        WebWaitUntilClickableNClick(20,WEB_ELEMENT_VIRTUAL_ASSISTANCE);
    }

    public void checkContactUsLink(){
        waitTimeUsingFluent(WEB_ELEMENT_BUTTON_CONTACT_US);
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_BUTTON_CONTACT_US,WEB_ELEMENT_BUTTON_CONTACT_US);
    }

    public void changeLanguageAndRegion(){
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHANGE_LANGUAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CHANGE_LANGUAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_RADIO_BUTTON_ESPANOL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SAVE_ESPANOL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CHANGE_REGION);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BRAZIL_CHANGE_REGION);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SAVE_BRAZIL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DONE_LANGUAGE_CHANGE);
    }

    public void searchInterestsUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String interest = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,interest);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String newInterest = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,newInterest);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String newInterest1 = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,newInterest1);
        implicitWait(10);
    }

    public void searchInterestsUsingExcelPart2() throws IOException, AWTException {
         DataSource.enterExcelDataInSearchNRefreshExpedia();
    }
}
