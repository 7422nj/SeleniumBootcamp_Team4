package homepage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.HomePageWebElement.*;

public class HomePage  extends WebAPI {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
        /////////////////////////////////////////////////////////////////////////////////////////
    // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;
@FindBy(xpath = WEB_ELEMENT_DROPDOWN_MORE_TRAVEL)
    WebElement clickMoreElement;
    // Action Method




// first commit

    public void selectionMoreTravel() {
        waitTimeExplicit(WEB_ELEMENT_DROPDOWN_MORE_TRAVEL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DROPDOWN_MORE_TRAVEL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DROPDOWN_MORE_TRAVEL_CRUISE);

    }

}




















