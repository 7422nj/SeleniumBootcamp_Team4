package ShopsPage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.awt.*;

import static ShopsPage.ShopsWebElements.*;

public class ShopsPage extends WebAPI {

    public ShopsPage() {
        PageFactory.initElements(driver, this);
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    //    // Find By Annotation: First Approach
    @FindBy(xpath = WEB_ELEMENT_BUTTON_NFL)
    public WebElement NFL;

    /**
     * Action Method #1
     * @throws InterruptedException
     * @throws AWTException
     */

    public void findPerfectEaglesJerseyUsingSizeTable() throws InterruptedException, AWTException {
        try {
            implicitWait(25);
            basicHoverUsingXpath(WEB_ELEMENT_BUTTON_NFL);
            hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_BUTTON_NFL, WEB_ELEMENT_LINK_EAGLES);
            implicitWait(25);
            clickByXNCssUsingJavaScript(WEB_ELEMENT_RADIO_BUTTON_MEN);
            implicitWait(15);
            clickByXNCssUsingJavaScript(WEB_ELEMENT_TABLE_SMALL);
            clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_JERSEY);
            implicitWait(15);
            click(WEB_ELEMENT_TABLE_SMALL);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Action Method #2
     */

    public void hoverOverNFLButton() {
        try {
            basicHoverUsingXpath(WEB_ELEMENT_BUTTON_NFL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Action Method #3
     * @throws InterruptedException
     * @throws AWTException
     */

    public void sendKeysToSearchField() throws InterruptedException, AWTException {
        refresh();
        typeOnElement(WEB_ELEMENT_INPUT_SEARCH_BAR, WEB_ELEMENT_INPUT_TEXT);
    }

    /**
     * Action Method #4
     * @return
     */

    @DataProvider(name = "SearchInterests")
    public static Object[] searchUsingDataProvider() {
        return new Object[]{
                "Base",
                "Catch",
                "Block",
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
                {"Pritam", "Boxing"},
                {"George", "Finest"},
                {"Achene", "Baseball"},
                {"Nabila", "Gloves"},
                {"Mariam", "Bootcamp404"}
        };
    }

    /**
     * Action Method #6
     * @throws InterruptedException
     * @throws AWTException
     */

    public void navigateBackToShopsPage() throws InterruptedException, AWTException {
        robotScrollDown(10);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_CAREERS);
        implicitWait(20);
        navigateBack();
        implicitWait(20);
    }
}
