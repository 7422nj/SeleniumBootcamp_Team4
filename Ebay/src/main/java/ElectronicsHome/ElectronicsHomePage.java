package ElectronicsHome;

import ElectronicsHome.ElectricData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static ElectronicsHome.ElectronicsWebElements.*;

//packageName.className.*;
public class ElectronicsHomePage extends WebAPI {

    //Constructor of class
    public ElectronicsHomePage() {
        PageFactory.initElements(driver, this);

    }
    /////////////////////////////////////////////////////////////////////////////////////////

    //Robot Available for All Below Methods
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //JavaScriptExecutor available for all below methods
    JavascriptExecutor js = (JavascriptExecutor) driver;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Find By Annotation: First Approach <- Used to Convert String into WebElements
    @FindBy(xpath = exampleLocator)
    public WebElement ExampleName;
    @FindBy(xpath = webElementButtonElectronics)
    public WebElement electronics;
    @FindBy(xpath = webElementLinkSmartHome)
    public WebElement smartHome;
    @FindBy(xpath = webElementLinkGoogleItems)
    public WebElement googly;
    @FindBy(xpath = WEB_ELEMENT_HEADER)
    public WebElement header;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Action Method #1
     *
     * @throws InterruptedException
     */

    // Action Method class
    public void ElectronicsClickSmartHome() throws InterruptedException {
        WebWaitUntilClickableNClick(20, webElementButtonElectronics); //explicit wait to click on  electronics tab
        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebWaitUntilClickableNClick(20, webElementLinkSmartHome);
        // Robot scrolls down
        robotScrollDownByChunks(4);
        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebWaitUntilClickableNClick(20, webElementLinkGoogleItems);

    }

    /**
     * Action Method #2
     * 1. Explicit Wait then click on Electronics Link
     * 2. Hover over Like-New Cams using Actions
     * 3. Click on Like-New Cams link using JavaScriptExecutor
     * 4. Scroll down using Robot
     */
    public void purchaseArloWireFreeSecurityCamera() throws InterruptedException {
        //Click on electronics
        waitTimeExplicit(webElementButtonElectronics);
        clickOnElement1(webElementButtonElectronics);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(webElementLinkLikeNewCams));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
        //Click on Like-New Cams link using JavaScriptExecutor
        waitTimeExplicit(webElementLinkLikeNewCams);
        clickUsingJavaScript(By.xpath(webElementLinkLikeNewCams));
        robotScrollDownByChunks(4);
        //Wait explicitly then clean on Arlo Wireless Camera
        waitTimeExplicit(webElementLinkArloCam);
        clickUsingJavaScript(By.xpath(webElementLinkArloCam));
        // This  will scroll down the page by  1000 pixel vertical
        robotScrollDownByChunks(3);
        //Click on Add to Cart
        waitTimeExplicit(webElementClickAddToCart);
        clickUsingJavaScript(By.xpath(webElementClickAddToCart));

    }

    /**
     * Action Method #3
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    public void findItemWithin50MilesOf19082() throws InterruptedException, AWTException {
        WebWaitUntilClickableNClick(10, WEB_ELEMENT_LINK_SMART_HOME);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_CHECKBOX_IRIS));
        scrollToElementUsingJavaScript(WEB_ELEMENT_RADIOBUTTON_IRIS);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_RADIOBUTTON_IRIS));
        scrollToElementUsingJavaScript(WEB_ELEMENT_DROPDOWN_MILES);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_DROPDOWN_MILES));
        typeOnElementNEnter(WEB_ELEMENT_DROPDOWN_MILES, WEB_ELEMENT_DROPDOWN_ENTER_KEYS_MILES);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_ZIP_CODE_MILES));
        clearField1(WEB_ELEMENT_ZIP_CODE_MILES);
        implicitWait(10);
        typeOnElementNEnter(WEB_ELEMENT_ZIP_CODE_MILES, WEB_ELEMENT_ENTER_KEYS_MILES);
    }

    /**
     * Action Method #4
     * Send Multiple Entries into Search Bar and Enter
     *
     * @throws IOException
     * @throws AWTException
     */

    public void searchItemUsingExcel() throws IOException, AWTException {
        enterExcelDataInSearchNRefresh();
        WebWaitUntilClickableNClick(20, webElementSearchBox);

    }

    /**
     * Action Method #5
     * Send a Single Entry into Search Bar
     * Get Attribute of Search Bar after Clicked
     *
     * @throws Exception
     */

    public void enterMacBookIntoSearchUsingExcel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String username = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_HEAD, username);
        implicitWait(10);
    }

    /**
     * Action Method #6
     *
     * @throws Exception
     */

    public void findAffordableLaptopUsingExcel() throws Exception {
        robotScrollDownByChunks(4);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_LAPTOP));
        scrollToElementUsingJavaScript(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String laptop = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS, laptop);
        scrollToElementUsingJavaScript(WEB_ELEMENT_CHECKBOX_$230_TO_$450);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_CHECKBOX_$230_TO_$450));
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_TO_MACBOOK);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_TO_MACBOOK));

    }

    /**
     * Action Method #7
     *
     * @throws Exception
     */

    public void findAffordableLaptopUsingMYSQLDB() throws Exception {
        robotScrollDownByChunks(4);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_LAPTOP));
        scrollToElementUsingJavaScript(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS);
        ElectronicsHome.ElectricData.DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String laptop = elementFromDatabase.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS, laptop);
        scrollToElementUsingJavaScript(WEB_ELEMENT_CHECKBOX_$230_TO_$450);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_CHECKBOX_$230_TO_$450));
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_TO_MACBOOK);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_TO_MACBOOK));
    }

    /**
     * Action Method #8
     *
     * @throws InterruptedException
     */

    public void hoverOverFeaturedItems() throws InterruptedException {
        robotScrollDownByChunks(4);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_LAPTOP));
        robotScrollDownByChunks(3);
        basicHover(By.xpath(WEB_ELEMENT_DROPDOWN_FEATURE_ITEMS));
    }

    /**
     * Action Method #9
     *
     * @throws InterruptedException
     */

    public void hoverOverFeaturedItemsNClick() throws InterruptedException {
        robotScrollDownByChunks(6);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_LAPTOP));
        robotScrollDownByChunks(3);
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_DROPDOWN_FEATURE_ITEMS, WEB_ELEMENT_LINK_LOWEST_PRICE);
        implicitWait(10);
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_DROPDOWN_VIEW_OPTIONS, WEB_ELEMENT_LINK_VIEW_OPTIONS);
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_CHROMEBOOK);
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_CHROMEBOOK));
        clickUsingJavaScript(By.xpath(webElementClickAddToCart));
    }

    /**
     * Action Method #10
     *
     * @throws InterruptedException
     */

    public void doubleClickOnDropDown() throws InterruptedException {
        clickUsingJavaScript(By.xpath(WEB_ELEMENT_LINK_SMART_HOME));
        robotScrollDownByChunks(6);
        WebWaitUntilClickableNClick(20, WEB_ELEMENT_CHECKBOX_IRIS1);
        robotScrollDownByChunks(10);
        doubleClickUsingXAndCSS(WEB_ELEMENT_DROPDOWN_DOUBLE_CLICK);
        sleepFor(3);
    }

    /**
     * Action Method #11
     */

    public void rightClick() {
        rightClick(WEB_ELEMENT_LINK_NEW_ARLO);
        implicitWait(15);
    }

    /**
     * Action Method #12
     */

    public void scrollDownPageUsingRobot() {
        try {
            robotScrollDown(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Action Method #13
     */

    public void scrollDownToBottomPageUsingJavaScript() {
        scrollToBottomOfPage();
    }

    /**
     * Action Method #14
     */

    public void scrollDownToElementUsingJavaScript() throws InterruptedException {
            scrollToElementUsingJavaScript(WEB_ELEMENT_HEADER);
        sleepFor(3);
}

    /**
     * Action Method #15
     */

    public void scrollDownUsingActionsClass() throws InterruptedException {
        WebElement head = driver.findElement(By.xpath(WEB_ELEMENT_HEADER));
        scrollDownUsingActions(head);
    }

    public void searchSamsungGalaxyUsingExcel() throws Exception {
        //Create a List -> Get Method from DataSource Class -> getItemsListFromExcel
        List<String> sheet = DataSource.getItemsListFromExcel();
        //Create a String -> Call the List -> use get() method to get a index from excel sheet
        String galaxy = sheet.get(5);
        //Send keys to Search Bar -> String galaxy
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_HEAD,galaxy);
    }

    public void searchAirpodsNAddToCartUsingExcel() throws Exception{
        //Created a List -> From DataSource Class -> Called getItemsListFromExcel method
        List<String> air = DataSource.getItemsListFromExcel();
        //Created a string named pods -> called the List<String> air and used get() method for index
        String pods = air.get(2);
        //Send keys to search field -> pods
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_HEAD,pods);
        //Scroll to element
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_AIRPODS);
        //Click element
        click(WEB_ELEMENT_LINK_AIRPODS);
        //Click Add to Cart
        click(WEB_ELEMENT_BUTTON_ADD_TO_CART_AIRPODS);
        //Click No Thanks Button
        click(WEB_ELEMENT_BUTTON_NO_THANKS_AIRPODS);
    }



}
