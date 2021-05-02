package homepage;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.HomePageWebElement.*;

public class HomePage extends WebAPI {

    @FindBy(xpath = WEB_ELEMENT_INPUT_SEARCH_ANYTHING)
    WebElement inputSearchAnything;

    @FindBy(xpath = WEB_ELEMENT_CLICK_ALL_CATEGORY)
    WebElement buttonAllCategory;

    @FindBy(xpath = WEB_ELEMENT_CLICK_SEARCH_BUTTON)
    WebElement selectFromDropdown;

    @FindBy(xpath = WEB_ELEMENT_EXPECTED_VALUE_ASSERTION)
    WebElement expectedValue;


//
//    //@FindBy turns the String to a web element
//    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEARCH_ALL_CATEGORY)
//    WebElement buttonSearchAllCategory;
//
//    @FindBy(xpath = WEB_ELEMENT_SELECT_SEARCH_APPLE)
//    WebElement clickCiscoLink;
//
//    @FindBy(xpath = WEB_ELEMENT_SELECT_NETWORK_BOX)
//    WebElement clickViewCartBox;
//
//    @FindBy(xpath = WEB_ELEMENT_CLICK_PLAN_BOX_YEARS)
//    WebElement clickAddToYears;

    //initializing all the we element on this page, using PageFactory
    public HomePage() {
        PageFactory.initElements(driver, this);//it initializes the web driver
    }

    public void searchPhonesAndAccessories() throws InterruptedException {
        typeOnElementNEnter(WEB_ELEMENT_INPUT_SEARCH_ANYTHING, "cell phones");
        selectAndAssertDropDown(WEB_ELEMENT_CLICK_ALL_CATEGORY, 9);
        clickByXpath(WEB_ELEMENT_CLICK_SEARCH_BUTTON);
        waitTimeExplicit(WEB_ELEMENT_CLICK_SEARCH_BUTTON);
        //driver.wait(1000);
        clickByXpath(WEB_ELEMENT_CLICK_IPHONE );
        staticSelection(WEB_ELEMENT_SELECT_SCREEN_SIZE,2);
        staticSelection(WEB_ELEMENT_SELECT_STORAGE_SIZE, 2);
        staticSelection(WEB_ELEMENT_SELECT_NETWORK, 3);
        staticSelection(WEB_ELEMENT_SELECT_COLOR, 2);
        staticSelection(WEB_ELEMENT_SELECT_CONDITION, 1);
        clickByXpath(WEB_ELEMENT_BUTTON_ADD_CART);
        assertEqualByXpath(WEB_ELEMENT_BUTTON_ASSERT_GO_TO_CHECKOUT, "Go to checkout");


    }


    public void ebayClickElement() {
//click
        clickByXpath(WEB_ELEMENT_CLICK_BUTTON );
        //hover and clik on sign in

    }

}


