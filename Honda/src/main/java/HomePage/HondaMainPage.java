package HomePage;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.util.List;

import static HomePage.HondaWebElement.*;

public class HondaMainPage extends WebAPI {

    //////////////////////////////////////////////////////////////////
    public HondaMainPage() {
        PageFactory.initElements(driver, this);
    }
    //////////////////////////////////////////////////////////////////

        // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;
//    @FindBy (how = How.XPATH, using =searchButtonLocator ) public WebElement searchButton;
//    @FindBy (how = How.XPATH, using =searchTextLocator ) public WebElement searchText;


    /**
     * Action Method #1
     * @throws Exception
     */

    public void searchReliabilitiesUsingExcel() throws Exception {
    clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH_ICON);
    List<String> reliabilities = DataSource.getItemsListFromExcel();
    String search = reliabilities.get(1);
    typeOnElementNEnter(WEB_ELEMENT_SEARCH_FIELD,search);
    }

    /**
     * Action Method #2
     * @throws Exception
     */

    public void searchHybridNGetMoreDetailsNSwitchTabsUsingMYSQLDB() throws Exception {
        DataSource.insertDataIntoDB();
        List<String> search = DataSource.getItemsListFromDB();
        String hybrid = search.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_FIELD,hybrid);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_CLICK_HERE);
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_PLUGIN_HYBRID);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_PLUGIN_HYBRID);
        WebElement element = driver.findElement(By.xpath(WEB_ELEMENT_LINK_PDF));
        scrollNClickElementUsingActions(element);
        robotScrollDown(6);
        switchTabToDefault();
    }

    /**
     * Action #3
     * @return
     */

    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Pritam", "Hybrid"},
                {"George", "Electric"},
                {"Achene", "Sports car"}
        };
    }

    public void searchItemsUsingDataProvider(){
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SEARCH_ICON);
    }
















}

























