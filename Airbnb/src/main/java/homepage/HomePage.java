package homepage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.HomePageWebElement.*;

public class HomePage extends WebAPI {
    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;
    @FindBy(xpath = WEB_ELEMENT_LINK_ONLINE_EXPERIENCE)
    WebElement clickLink;
    @FindBy(xpath = WEB_ELEMENT_LINK_ONLINE_EXPERIENCE_FILTER)
    WebElement clickFilter;
   // @FindBy(xpath = WEB_ELEMENT_FILTER_SCROW_BUTTON_EXPECTED_POSITION)
    WebElement moveSlide1;
    @FindBy(xpath = WEB_ELEMENT_FILTER_MAXPRICE_SCROW_BUTTON)
    WebElement maxPrice;

    //initialization of web elements
    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    // Action Method
    public void onLineCustomerExperience() throws InterruptedException {
        waitTimeExplicit(WEB_ELEMENT_LINK_ONLINE_EXPERIENCE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_ONLINE_EXPERIENCE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_ONLINE_EXPERIENCE_FILTER);
        waitTimeExplicit(WEB_ELEMENT_FILTER_SCROW_BUTTON_MinMax);
       draggingMaxToMin(WEB_ELEMENT_FILTER_SCROW_BUTTON_MinMax,677,256);
//        waitUntilClickAble1(WEB_ELEMENT_FILTER_SCROW_BUTTON_MaxMin);
//        draggingMaxToMin(WEB_ELEMENT_FILTER_SCROW_BUTTON_MaxMin,256,-740);


//        resizingElement(WEB_ELEMENT_FILTER_SCROW_BUTTON_RIGHT, WEB_ELEMENT_FILTER_SCROW_BUTTON_EXPECTED_POSITION);
//        waitTimeExplicit(WEB_ELEMENT_MINIPRICE_INPUT_BUTTON);
//        sendingKeys(WEB_ELEMENT_MINIPRICE_INPUT_BUTTON ,25);
//        waitUntilVisible1(WEB_ELEMENT_MAXPRICE_INPUT_BUTTON);
//        sendingKeys(WEB_ELEMENT_MAXPRICE_INPUT_BUTTON,85);




    }



}























