package NewsPage;

import NewsPage.NewsDataDriver.DataSource;
import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.util.List;

import static NewsPage.NewsWebElements.*;

public class NewsPage extends WebAPI {

    /////////////////////////////////////////////////////////////////
    public NewsPage() {
        PageFactory.initElements(driver, this);
    }
    /////////////////////////////////////////////////////////////////


    /**
     * Action Method #1
     * @return
     */

    @DataProvider(name = "SearchInterests")
    public static Object[] searchUsingDataProvider() {
        return new Object[]{
                "Danger",
                "Views",
                "Nature",
                "Travel",
                "Condo",
                "Bootcamp404"
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

    public void searchBoxInspectionIsDisplayed() {
        find(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Action Method #4
     */

    public void searchBoxInspectionIsEnabled() {
        click(WEB_ELEMENT_SEARCH_LOCATOR);
    }

    /**
     * Action Method #5
     */

    public void scrollToElementUsingJS() {
        scrollToElementUsingJavaScript(WEB_ELEMENT_HEADER_HOUSE);
    }

    /**
     * Action Method #6
     */

    public void hoverOverDropDownAndSelectSellingWorthIt() {
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_DROP_DOWN_SELL, WEB_ELEMENT_DROP_DOWN_SELECT);
    }

    /**
     * Action Method #7
     * @throws Exception
     */

    public void newsLetterValidCredsEnterKeysUsingMYSQLDB() throws Exception {
        implicitWait(20);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String email = elementFromDatabase.get(5);
        typeOnElementNEnter(WEB_ELEMENT_INPUT_EMAIL, email);
    }

    /**
     * Action Method #8
     * @throws Exception
     */

    public void newsLetterInvalidCredsEnterKeysUsingMYSQLDB() throws Exception {
        implicitWait(20);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String email = elementFromDatabase.get(6);
        typeOnElementNEnter(WEB_ELEMENT_INPUT_EMAIL, email);
    }

    /**
     * Action Method #9
     * @throws Exception
     */

    public void sendKeysToSearchUsingMYSQLDB() throws Exception {
        implicitWait(20);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String word = elementFromDatabase.get(3);
        typeOnElement(WEB_ELEMENT_SEARCH_LOCATOR, word);
    }

    public void navigateToNewsPage(){
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_CONTACT);
        navigateBack();
        WebDriverWait0(20);
    }

}
