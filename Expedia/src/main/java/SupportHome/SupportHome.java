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
    }

    /**
     * Action Method #1
     * @return
     */

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

    /**
     * Action Method #2
     * @return
     */

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

    /**
     * Action Method #3
     * @return
     */

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

    /**
     * Action Method #4
     */

    public void scrollToAndIdentifyQRCode() {
        scrollToElementUsingJavaScript(WEB_ELEMENT_IMG_QR_CODE_APP);
    }

    /**
     * Action Method #5
     * @throws InterruptedException
     * @throws AWTException
     */

    public void virtualAssistance() throws InterruptedException, AWTException {
        refresh();
        implicitWait(10);
        WebWaitUntilClickableNClick(20,WEB_ELEMENT_VIRTUAL_ASSISTANCE);
    }

    /**
     * Action Method #6
     */

    public void checkContactUsLink(){
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_BUTTON_CONTACT_US,WEB_ELEMENT_BUTTON_CONTACT_US);
    }

    /**
     * Action Method #7
     */

    public void changeLanguageAndRegion(){
        clickByXNCssUsingJavaScript(WEB_ELEMENT_CHANGE_LANGUAGE);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_CHANGE_LANGUAGE);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_RADIO_BUTTON_ESPANOL);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_SAVE_ESPANOL);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_CHANGE_REGION);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BRAZIL_CHANGE_REGION);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_SAVE_BRAZIL);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_DONE_LANGUAGE_CHANGE);
    }

    /**
     * Action Method #8
     * @throws Exception
     */

    public void searchInterestsUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String interest = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,interest);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String newInterest = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,newInterest);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String newInterest1 = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,newInterest1);
        implicitWait(10);
    }

    /**
     * Action Method #9
     * @throws IOException
     * @throws AWTException
     */

    public void searchInterestsUsingExcelPart2() throws IOException, AWTException {
         DataSource.enterExcelDataInSearchNRefreshExpedia();
    }

    /**
     * Action Method #10
     * @throws Exception
     */

    public void searchItemsUsingMYSQLDB() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String interest = elementFromDatabase.get(0);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,interest);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String item = elementFromDatabase.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,item);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String newItem = elementFromDatabase.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,newItem);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LOGO);
        WebDriverWait0(20);
        String newItem1 = elementFromDatabase.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BOX_MAIN,newItem1);
        implicitWait(10);
    }

    /**
     * Action Method #11
     */

    public void scrollToExpediaRewards(){
        scrollToElementUsingJavaScript(WEB_ELEMENT_DROP_DOWN_EXPEDIA_REWARDS);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_DROP_DOWN_EXPEDIA_REWARDS);
    }
}
