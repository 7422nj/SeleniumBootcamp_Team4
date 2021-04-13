package homepage;

import common.WebAPI;
import homepage.AirDataDriver.DataSource;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static homepage.HomePageWebElement.*;

public class HomePage extends WebAPI {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    /////////////////////////////////////////////////////////////////////////////////////////

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;
//    @FindBy (how = How.XPATH, using =searchButtonLocator ) public WebElement searchButton;
//    @FindBy (how = How.XPATH, using =searchTextLocator ) public WebElement searchText;

    /**
     * Action Method #1
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    public void enterTextInLocationField() throws InterruptedException, AWTException {
        refresh();
        fluentWait();
        typeOnElement(WEB_ELEMENT_SEARCH_LOCATOR, WEB_ELEMENT_VALUE_SEARCH_LOCATION);
        implicitWait(10);
    }

    /**
     * Action Method #2
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    public void getCurrentSiteUrl() throws InterruptedException, AWTException {
        refresh();
        getCurrentPageUrl();
        System.out.println("Current Url : " + getCurrentPageUrl());
    }

    /**
     * Action Method #3
     *
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
     * Action Method #4
     *
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
     * Action Method #5
     *
     * @throws IOException
     * @throws AWTException
     */

    public void searchItemsUsingExcel() throws IOException, AWTException {
        waitTimeUsingFluent();
        DataSource.enterExcelDataInSearchNRefreshAirbnb();
    }

    /**
     * Action Method #6
     *
     * @throws Exception
     */

    public void searchCottageUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String interest = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, interest);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SUBMIT_SEARCH);
        implicitWait(15);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_SUPER_HOST_AIRBNB);
        implicitWait(15);
        robotScrollDown(4);
    }

    /**
     * Action Method #7
     *
     * @throws Exception
     */

    public void searchCottageUsingExcelSwitchTabs() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String interest = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, interest);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SUBMIT_SEARCH);
        implicitWait(15);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_SUPER_HOST_AIRBNB);
        implicitWait(15);
        robotScrollDown(4);
        switchTabToDefault();
    }

    public void searchFarmUsingMYSQLDB() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String interest = elementFromDatabase.get(3);
        typeOnElement(WEB_ELEMENT_SEARCH_LOCATOR, interest);
    }

    public void signUpUsingMYSQLDB() throws Exception {
        clickByXNCssUsingJavaScript(WEB_ELEMENT_DROP_DOWN_MENU);
        enterKey();
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String number = elementFromDatabase.get(6);
        find(WEB_ELEMENT_TEXT_FIELD_SIGN_UP);
        typeOnElementNEnter(WEB_ELEMENT_TEXT_FIELD_SIGN_UP, number);
    }

    public void findADateUsingCalendarPicker() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String farm = elementFromDatabase.get(3);
        find(WEB_ELEMENT_SEARCH_LOCATOR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, farm);
        find(WEB_ELEMENT_CALENDAR);
        click(WEB_ELEMENT_CALENDAR);
        implicitWait(15);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_DATE_STAY_PICKED);
        implicitWait(15);
        find(WEB_ELEMENT_CALENDAR_LEAVE);
        click(WEB_ELEMENT_CALENDAR_LEAVE);
        implicitWait(15);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_DATE_LEAVE_PICKED);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_SUBMIT_DATE);
        implicitWait(20);
    }
}


























