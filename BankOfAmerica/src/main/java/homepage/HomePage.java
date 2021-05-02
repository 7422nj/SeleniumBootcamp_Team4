package homepage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.BOFHomePageWebElement.*;

public class HomePage  extends WebAPI {



        /////////////////////////////////////////////////////////////////////////////////////////

        // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;

        // Action Method
        @FindBy(xpath = WEB_ELEMENT_CLICK_HOMELOAN_BUTTON)
        WebElement clickButton;


    //initialization of web elements
    public HomePage() {
        PageFactory.initElements(driver, this);

    }
    // Action Method
    public void clickingHomeLoansButton() throws InterruptedException {
        clckingOnButton(WEB_ELEMENT_CLICK_HOMELOAN_BUTTON);
        clckingOnButton(WEB_ELEMENT_SEARCH_BUTTON_FIRST_TIME_BUYER);
        waitUntilClickAble1(WEB_ELEMENT_SEARCH_BUTTON_OVERVIEW, 02);
        clckingOnButton(WEB_ELEMENT_SEARCH_BUTTON_OVERVIEW);
        waitUntilClickAble1(WEB_ELEMENT_SEARCH_BUYING_HOME_BUTTON, 05);
        clckingOnButton(WEB_ELEMENT_SEARCH_BUYING_HOME_BUTTON);
        //scrollingWindow(WEB_ELEMENT_SEARCH_SCROLL_TO_TODAYS_MORTGAGE_RATE);
        Thread.sleep(1000);
        clckingOnButton(WEB_ELEMENT_IFRAME_SCROLL_TO_TODAYS_MORTGAGE_RATE);
        Thread.sleep(4000);
       switchingWindow(WEB_ELEMENT_IFRAME_SCROLL_TO_TODAYS_MORTGAGE_RATE);
        waitUntilClickAble1(WEB_ELEMENT_SEARCH_PURCHASE_PRICE ,10);
        clearDefaultInboxTest(WEB_ELEMENT_SEARCH_PURCHASE_PRICE );
        typeOnElement1(WEB_ELEMENT_SEARCH_PURCHASE_PRICE ,"550000");

        clearDefaultInboxTest(WEB_ELEMENT_SEARCH_DOWN_PAYMENT);
        typeOnElement1(WEB_ELEMENT_SEARCH_DOWN_PAYMENT,"30000");
        clearDefaultInboxTest(WEB_ELEMENT_SEARCH_ZIP_CODE);
        typeOnElement1(WEB_ELEMENT_SEARCH_ZIP_CODE,"22192");
        clckingOnButton(WEB_ELEMENT_ENTER_UPDATE_RATE_BUTTON);
        Thread.sleep(6000);
        assertEqualByXpath(WEB_ELEMENT_UPDATE_RATE_BUTTON_NEGATIVE_ASSERTION_1, "Private mortgage insurance may be required for loans with a down payment of less than 20%.");
        Thread.sleep(6000);
        assertEqualByXpath(WEB_ELEMENT_UPDATE_RATE_BUTTON_POSITIVE_ASSERTION_2, "$3,012");
        Thread.sleep(6000);
//typeOnElement1(WEB_ELEMENT_SEARCH_DOWN_PAYMENT,"Private mortgage insurance may be required " +
//                "for loans with a down payment of less than 20%.");
//        clckingOnButton(WEB_ELEMENT_CLICK_TODAY_MORTGAGE_RATE );
//        switchingWindow (WEB_ELEMENT_CLICK_TODAY_MORTGAGE_RATE);
//
//
//        assertEqualByXpath(WEB_ELEMENT_UPDATE_RATE_BUTTON_NEGATIVE_ASSERTION,"$2,344");
    }
}
























