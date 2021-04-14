package MercedesMainPage;

import MercedesMainPage.BenzDataDriver.DataSource;
import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static MercedesMainPage.BenzDataDriver.DataSource.enterExcelDataInSearchNRefreshMercedes;
import static MercedesMainPage.MercedesMainWebElement.*;

public class MercedesMainPage extends WebAPI {

    public MercedesMainPage() {
        PageFactory.initElements(driver, this);
    }

    /////////////////////////////////////////////////////////////////////////////////////////


    // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;
//    @FindBy (how = How.XPATH, using =searchButtonLocator ) public WebElement searchButton;
//    @FindBy (how = How.XPATH, using =searchTextLocator ) public WebElement searchText;

    /**
     * Action Method #1
     * @throws Exception
     */

    public void registerAccountInvalidCredsUsingExcel() throws Exception {
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_MY_ACCOUNT);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_REGISTER);
        implicitWait(15);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String username = elementFromExcel.get(1);
        typeOnElement(WEB_ELEMENT_INPUT_USERNAME, username);
        implicitWait(15);
        String firstName = elementFromExcel.get(2);
        typeOnElement(WEB_ELEMENT_INPUT_FIRST_NAME, firstName);
        implicitWait(15);
        String lastName = elementFromExcel.get(3);
        typeOnElement(WEB_ELEMENT_INPUT_LAST_NAME, lastName);
        implicitWait(15);
        String password = elementFromExcel.get(4);
        typeOnElement(WEB_ELEMENT_INPUT_PASSWORD, password);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_CHECKBOX_SUBMIT);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_CONTINUE);
    }

    /**
     * Action Method #2
     * @throws Exception
     */

    public void registerAccountValidCredsUsingExcel() throws Exception {
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_MY_ACCOUNT);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_REGISTER);
        implicitWait(15);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel2();
        String username = elementFromExcel.get(1);
        typeOnElement(WEB_ELEMENT_INPUT_USERNAME, username);
        implicitWait(15);
        String firstName = elementFromExcel.get(2);
        typeOnElement(WEB_ELEMENT_INPUT_FIRST_NAME, firstName);
        implicitWait(15);
        String lastName = elementFromExcel.get(3);
        typeOnElement(WEB_ELEMENT_INPUT_LAST_NAME, lastName);
        implicitWait(15);
        String password = elementFromExcel.get(4);
        typeOnElement(WEB_ELEMENT_INPUT_PASSWORD, password);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_CHECKBOX_SUBMIT);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_CONTINUE);
    }

    /**
     * Test #3
     * @throws Exception
     */

    public void searchInterestsUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel3();
        String interest = elementFromExcel.get(1);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH);
        typeOnElementNEnter(WEB_ELEMENT_INPUT_SEARCH_FIELD, interest);
        implicitWait(20);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BENZ_LOGO);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH);
        String item = elementFromExcel.get(2);
        typeOnElement(WEB_ELEMENT_INPUT_SEARCH_FIELD, item);
    }

    /**
     * Action Method #4
     * @return
     */

    @DataProvider(name = "SearchInterests")
    public static Object[] searchUsingDataProvider() {
        return new Object[]{
                "Recent",
                "Finest",
                "Rare",
                "Review",
                "Bootcamp404"
        };
    }

    /**
     * Action Method #5
     * @return
     */

    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Pritam", "Rare"},
                {"George", "Finest"},
                {"Achene", "Luxury"},
                {"Nabila", "Auto Pilot"},
                {"Mariam", "Bootcamp404"}
        };
    }

    /**
     * Action Method #6
     * @throws IOException
     * @throws AWTException
     */

    public void searchItemsUsingExcel() throws IOException, AWTException {
        enterExcelDataInSearchNRefreshMercedes();
    }

    /**
     * Action Method #7
     * @throws Exception
     */

    public void searchItemUsingMYSQLDB() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH);
        String interest = elementFromDatabase.get(3);
        typeOnElementNEnter(WEB_ELEMENT_INPUT_SEARCH_FIELD, interest);
    }

    /**
     * Action Method #8
     * @throws Exception
     */

    public void subscribeToReceivingNewsInvalidEmailUsingMYSQLDB() throws Exception {
        scrollToElementUsingJavaScript(WEB_ELEMENT_HEADER_STAY);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_EMAIL_NEWS);
        String email = elementFromDatabase.get(3);
        typeOnElement(WEB_ELEMENT_INPUT_EMAIL_NEWS, email);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SUBSCRIBE);
    }

    /**
     * Action Method #9
     * @throws Exception
     */

    public void subscribeToReceivingNewsValidEmailUsingMYSQLDB() throws Exception {
        scrollToElementUsingJavaScript(WEB_ELEMENT_HEADER_STAY);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_EMAIL_NEWS);
        String email = elementFromDatabase.get(6);
        typeOnElement(WEB_ELEMENT_INPUT_EMAIL_NEWS, email);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SUBSCRIBE);
    }

    /**
     * Action Method #10
     * @throws Exception
     */

    public void findADealerNearbyUsingMYSQLDB() throws Exception {
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_NEARBY);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_ZIP_CODE);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String zipcode = elementFromDatabase.get(7);
        typeOnElementNEnter(WEB_ELEMENT_INPUT_ZIP_CODE, zipcode);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_CLICK_LOCATION);
    }

    /**
     * Action Method #11
     */

    public void NavigateBackToMainPage(){
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_CONTACT_US);
        navigateBack();
    }

    /**
     * Action Method #12
     */

    public void hoverOverNearbyDealers(){
        basicHoverUsingXpath(WEB_ELEMENT_BUTTON_NEARBY);
    }
}

























