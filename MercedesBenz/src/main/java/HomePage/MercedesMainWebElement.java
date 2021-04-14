package HomePage;

public class MercedesMainWebElement {

    //Register for Account Invalid Credentials Using Excel
    public static final String WEB_ELEMENT_BUTTON_MY_ACCOUNT = "//span[@class='global-header__menu-l1-list-button-utility-inner']";
    public static final String WEB_ELEMENT_BUTTON_REGISTER = "//li[@class='global-header__menu-l3-panel-item global-header__menu-l3-panel-item--profile']//button[@class='nav-profile__register nav-profile__link ']";
    public static final String WEB_ELEMENT_INPUT_USERNAME = "//input[@id='username']";
    public static final String WEB_ELEMENT_INPUT_FIRST_NAME = "//input[@id='firstname']";
    public static final String WEB_ELEMENT_INPUT_LAST_NAME = "//input[@id='lastname']";
    public static final String WEB_ELEMENT_INPUT_PASSWORD = "//input[@id='password']";
    public static final String WEB_ELEMENT_CHECKBOX_SUBMIT = "//div[@class='ui checkbox']/input[1]";
    public static final String WEB_ELEMENT_BUTTON_CONTINUE = "//button[@id='continue']";
    public static final String WEB_ELEMENT_VERIFY_ERROR_REGISTER = "//li[contains(.,'The notification could not be delivered. Please check that the e-mail address ex')]";

    //Register for Account Valid Credentials Using Excel
    public static final String WEB_ELEMENT_VERIFY_VALID = "//p[contains(.,'We have sent you a confirmation code to pritamdas15217@gmail.com for the purpose')]";

    //Search Using Excel
    public static final String WEB_ELEMENT_BUTTON_SEARCH = "//button[@class='global-header__menu-l1-list-button global-header__menu-l1-list-button--search icon-mb icon-search']";
    public static final String WEB_ELEMENT_BENZ_LOGO = "//div[@class='top-bar__inner']//img[@alt='Mercedes-Benz']";
    public static final String WEB_ELEMENT_INPUT_SEARCH_FIELD = "//input[@name='search']";

    //Subscribe to Receiving News Using MYSQLDB
    public static final String WEB_ELEMENT_HEADER_STAY = "//h4[@class='stay-connected__title footer__accordion-item-heading']";
    public static final String WEB_ELEMENT_INPUT_EMAIL_NEWS = "//div[@class='form__input ']/input[@class='form__input-field form__input-field--can-reset']";
    public static final String WEB_ELEMENT_BUTTON_SUBSCRIBE = "//button[@class='button button_secondary_alt   stay-connected__subscribe-cta']";
    public static final String WEB_ELEMENT_VERIFY_INVALID_EMAIL = "//span[.='Invalid email address']";
    public static final String WEB_ELEMENT_VERIFY_VALID_EMAIL = "//p[@class='stay-connected__subscribed-message']";

    //Find a Dealer Nearby Using MYSQLDB
    public static final String WEB_ELEMENT_BUTTON_NEARBY = "//button[@class='global-header__menu-l1-list-button global-header__menu-l1-list-button--icon-pin']";
    public static final String WEB_ELEMENT_INPUT_ZIP_CODE = "//div[@class='form__input form__input--inline']/input[@class='form__input-field form__input-field--can-reset']";
    public static final String WEB_ELEMENT_BUTTON_SUBMIT_SEARCH = "//button[@class='button button_primary']";
    public static final String WEB_ELEMENT_BUTTON_CLICK_LOCATION = "//div[@class='wrapper dealer-result__wrapper dealer-result__wrapper--has-eyebrow']//div[@class='dealer-result__address-heading']";
    public static final String WEB_ELEMENT_BUTTON_VERIFY_LOCATION= "//div[@class='dealer-detail__address']";

    //Navigate Back to Main Page
    public static final String WEB_ELEMENT_LINK_CONTACT_US = "//a[.='Contact Us']";







}
