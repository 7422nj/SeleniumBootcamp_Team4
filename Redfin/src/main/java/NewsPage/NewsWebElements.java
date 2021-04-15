package NewsPage;

public class NewsWebElements {

    //Search Items Using Data Provider
    public static final String WEB_ELEMENT_SEARCH_LOCATOR = "//input[@name='s']";

    //Scroll down to Element
    public static final String WEB_ELEMENT_HEADER_HOUSE = "//h3[.='Housing Market']";

    //Hover Over Sell & Select from DropDown
    public static final String WEB_ELEMENT_DROP_DOWN_SELL = "//a[.='Sell']";
    public static final String WEB_ELEMENT_DROP_DOWN_SELECT = "//span[.='Will Selling Pay Off?']";
    public static final String WEB_ELEMENT_HEADER_SELLING = "//h1[@class='heading']";

    //Sign Up for News Letter using MYSQLDB
    public static final String WEB_ELEMENT_INPUT_EMAIL = "#input_1_1";
    public static final String WEB_ELEMENT_CONFIRMATION_MESSAGE = "//div[@class='gform_confirmation_message_1 gform_confirmation_message']";
    public static final String WEB_ELEMENT_ERROR_MESSAGE = "//div[@id='validation_message_1_1']";

    //Navigate Between Pages
    public static final String WEB_ELEMENT_BUTTON_CONTACT = "//nav[@class='elementor-nav-menu--main elementor-nav-menu__container elementor-nav-menu--layout-horizontal e--pointer-underline e--animation-none']//a[.='Contact']";
}
