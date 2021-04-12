package SupportHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import java.awt.*;
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
    public static Object[] searchUsingDataProvider(){
        return new Object[]{
                "Beach",
                "Views",
                "Nature",
                "Travel",
                "Condo"
        };
    }
}
