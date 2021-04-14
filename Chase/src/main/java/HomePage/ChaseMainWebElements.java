package HomePage;

public class ChaseMainWebElements {

    //Navigate to Main Page
    public static final String WEB_ELEMENT_LINK_CAREERS = "//a[.='Careers']";
    public static final String WEB_ELEMENT_DISCLAIMER = "//span[@class='disclaimer']";

    //Hover over Open An Account
    public static final String WEB_ELEMENT_BUTTON_SIGN_IN = "//a[.='Sign in']";
    public static final String WEB_ELEMENT_BUTTON_OPEN_ACCOUNT = "//a[@class='btn cta cta--primary cta--large cta--btn-green-aloe']";

    //Sign In using Invalid Credentials
    public static final String WEB_ELEMENT_INPUT_USER_ID = "//input[@id='userId-text-input-field']";
    public static final String WEB_ELEMENT_INPUT_PASSWORD = "//input[@id='password-text-input-field']";
    public static final String WEB_ELEMENT_BUTTON_SUBMIT_SIGN_IN = "//button[@id='signin-button']";
    public static final String WEB_ELEMENT_VERIFY_ERROR_HEADER = "//h2[@id='inner-logon-error']";
    public static final String WEB_ELEMENT_IFRAME_HANDLE = "//iframe[@id='logonbox']";

    //Change Language to Espanol
    public static final String WEB_ELEMENT_LINK_ESPANOL = "//ul[@class='header-navigation__contact--links']/li[@class='header-navigation__contact--link ']/a[contains(.,'Español')]";

    //Find Company Owner JPMorgan Chase & Co..
    public static final String WEB_ELEMENT_TEXT_JPMORGAN = "//p[.='© 2021 JPMorgan Chase & Co..']";

    //Chase Logo Inspection
    public static final String WEB_ELEMENT_LOGO_CHASE = "//div[@class='header-navigation__logo']";




}
