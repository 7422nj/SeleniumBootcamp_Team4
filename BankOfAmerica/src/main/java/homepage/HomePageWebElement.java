package homepage;

import org.openqa.selenium.By;

public class HomePageWebElement {

    // Sign in Using Excel
    public static final String WEB_ELEMENT__ENTRY_USERNAME = "//div[@id='inputOnlineId']//input[@class='spa-input-text']";
    public static final String WEB_ELEMENT_ENTRY_PASSWORD = "//input[@class='tl-private spa-input-text']";
    public static final String WEB_ELEMENT_VERIFY_ERROR_HEADER = "//form[@id='ah-acct-ssn-form']//div[@class='column small-12 title-text']";

    //Search interests in search bar
    public static final String WEB_ELEMENT_SEARCH_BANK = "//input[@id='nav-search-query']";

    //PopUpHandling
    public static final String WEB_ELEMENT_LINK_APPOINTMENT  = "//a[@id='finCenterLocator']";
    public static final String WEB_ELEMENT_CLICK_APPOINTMENT = "//a[.='Schedule Now']";

    //SignIn Using Fluent Wait
    public static final String WEB_ELEMENT_SEND_KEYS_USER = "pritamdas@gmail.com";
    public static final String WEB_ELEMENT_SEND_KEYS_PASS = "bootcamp404";

    //Change language
    public static final String WEB_ELEMENT_LINK_LANGUAGES = "//a[@id='NAV_EN_ES']";

    //Double Click Checkbox
    public static final String WEB_ELEMENT_CHECKBOX_SIGN_IN = "//input[@id='saveOnlineId']";

    //Hover over Cash Rewards
    public static final String WEB_ELEMENT_IMAGE_CARD = "//div[@class='products-container ']/div[1]//span[@class='show-for-large-up']/a[1]";
    public static final String WEB_ELEMENT_VERIFY_IMAGE_CARD = "//div[@class='products-container ']/div[1]//span[@class='show-for-large-up']/a[1]";







}
