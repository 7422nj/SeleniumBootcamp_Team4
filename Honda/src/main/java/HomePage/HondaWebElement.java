package HomePage;

public class HondaWebElement {


    // Search reliability using excel
    public static final String WEB_ELEMENT_BUTTON_SEARCH_ICON = "//div[@class='search-icon-glass']";
    public static final String WEB_ELEMENT_SEARCH_FIELD = "//input[@id='searchInput']";
    public static final String WEB_ELEMENT_VERIFY_SEARCH_RESULTS = "//div[@class='middle ellipsis']";

    //Search hybrid and get more details using MYSQLDB
    public static final String WEB_ELEMENT_LINK_CLICK_HERE = "//a[contains(.,'here')]";
    public static final String WEB_ELEMENT_LINK_PLUGIN_HYBRID = "//a[@role=\"button\"][normalize-space()=\"PLUG-IN HYBRID\"]";
    public static final String WEB_ELEMENT_LINK_PDF = "//span[contains(.,'VIEW PDF')]";
    public static final String WEB_ELEMENT_VERIFY_HYBRID = "//div[@class='rzf-gry-slide  resp-loaded active']//div[@class='rzf-gry-heading text-x-small-center text-small-center text-medium-center text-large-center text-x-large-center white-foreground palette-2']";
    public static final String WEB_ELEMENT_VERIFY_HEADER_HYBRID = "//h2[contains(.,'Benefits of Electrified Vehicles')]";






}
