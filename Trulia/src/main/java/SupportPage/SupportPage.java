package SupportPage;

import SupportPage.SupportDataDriver.DataSource;
import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.awt.*;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import static SupportPage.SupportDataDriver.DataSource.*;
import static SupportPage.SupportWebElements.*;

public class SupportPage extends WebAPI {

    /////////////////////////////////////////////////////////////////////////////////////////
    public SupportPage() { PageFactory.initElements(driver, this); }
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

    ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Action Method #1
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
     * Action Method #2
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
     * Action Method #3
     */

    public void searchBoxInspectionIsNotSelected() {
        click(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Action Method #4
     */

    public void searchBoxInspectionIsDisplayed() {
        find(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Action Method #5
     */

    public void searchBoxInspectionIsEnabled() {
        click(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Action Method #6
     * @throws IOException
     * @throws AWTException
     */

    public void searchItemsUsingExcel() throws IOException, AWTException {
        enterExcelDataInSearchNRefreshTrulia();
    }

    /**
     * Action Method #7
     * @throws Exception
     */

    public void searchFarmUsingMYSQLDB() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String farm = elementFromDatabase.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, farm);
    }

    /**
     * Action Method #8
     * @throws Exception
     */

    public void signInUsingMYSQLDB() throws Exception {
        click(WEB_ELEMENT_BUTTON_SIGN_IN);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String email = elementFromDatabase.get(5);
        typeOnElement(WEB_ELEMENT_INPUT_EMAIL, email);
        WebDriverWait0(15);
        String password = elementFromDatabase.get(6);
        typeOnElement(WEB_ELEMENT_INPUT_PASSWORD, password);
        find(WEB_ELEMENT_BUTTON_SUBMIT);
        clickUsingJavaScript(WEB_ELEMENT_BUTTON_SUBMIT);
        sleepFor(120);
    }

    /**
     * Action Method #9
     * @throws Exception
     */

    public void searchBeachesUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String interest = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, interest);
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        System.out.println("" + cal.getTime());
    }

    /**
     * Action Method #10
     * @throws Exception
     */

    public void searchBeachesUsingExcelNavigateToSupportPage() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String interest = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, interest);
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        System.out.println("" + cal.getTime());
        navigateBack();
    }

    /**
     * Action Method #11
     */

    public void clickOnImageLogo(){
        click(WEB_ELEMENT_LOGO_TRULIA);
    }
}


