package ElectronicsHome;

import DataDriver.DataSource;
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
    @FindBy(xpath = WEB_ELEMENT_DROPDOWN_MILES)
    public WebElement miles;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Action Method #1
     * @throws InterruptedException
     */

    // Action Method class
    public void ElectronicsClickSmartHome() throws InterruptedException {
        WebWaitUntilClickableNClick(20, webElementButtonElectronics); //explicit wait to click on  electronics tab
        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebWaitUntilClickableNClick(20, webElementLinkSmartHome);
        // Robot scrolls down
        robotScrollDown(4);
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
        clickByXpathUsingJavaScript(webElementLinkLikeNewCams);
        robotScrollDown(4);
        //Wait explicitly then clean on Arlo Wireless Camera
        waitTimeExplicit(webElementLinkArloCam);
        clickByXpathUsingJavaScript(webElementLinkArloCam);
        // This  will scroll down the page by  1000 pixel vertical
        robotScrollDown(3);
        //Click on Add to Cart
        waitTimeExplicit(webElementClickAddToCart);
        clickByXpathUsingJavaScript(webElementClickAddToCart);

    }

    /**
     * Action Method #3
     * @throws InterruptedException
     * @throws AWTException
     */
    public void findItemWithin50MilesOf19082() throws InterruptedException, AWTException {
        WebWaitUntilClickableNClick(10,WEB_ELEMENT_LINK_SMART_HOME);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHECKBOX_IRIS);
        scrollToElementUsingJavaScript(WEB_ELEMENT_RADIOBUTTON_IRIS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_RADIOBUTTON_IRIS);
        scrollToElementUsingJavaScript(WEB_ELEMENT_DROPDOWN_MILES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DROPDOWN_MILES);
        typeOnElementNEnter(WEB_ELEMENT_DROPDOWN_MILES, WEB_ELEMENT_DROPDOWN_ENTER_KEYS_MILES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_ZIP_CODE_MILES);
        clearField1(WEB_ELEMENT_ZIP_CODE_MILES);
        implicitWait(10);
        typeOnElementNEnter(WEB_ELEMENT_ZIP_CODE_MILES, WEB_ELEMENT_ENTER_KEYS_MILES);
    }

    /**
     * Action Method #4
     * Send Multiple Entries into Search Bar and Enter
     * @throws IOException
     * @throws AWTException
     */

    public void searchItemUsingExcel() throws IOException, AWTException {
        enterExcelDataInSearchNRefresh();
        WebWaitUntilClickableNClick(20,webElementSearchBox);

    }

    /**
     * Action Method #5
     * Send a Single Entry into Search Bar
     * Get Attribute of Search Bar after Clicked
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
     * @throws Exception
     */

    public void findAffordableLaptopUsingExcel() throws Exception {
        robotScrollDown(4);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_LAPTOP);
        scrollToElementUsingJavaScript(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String laptop = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS, laptop);
        scrollToElementUsingJavaScript(WEB_ELEMENT_CHECKBOX_$230_TO_$450);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHECKBOX_$230_TO_$450);
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_TO_MACBOOK);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_TO_MACBOOK);

    }

    /**
     * Action Method #7
     * @throws Exception
     */

    public void findAffordableLaptopUsingMYSQLDB() throws Exception {
        robotScrollDown(4);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_LAPTOP);
        scrollToElementUsingJavaScript(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS);
        DataSource.insertDataIntoDB();
        List<String> elementFromDatabase = DataSource.getItemsListFromDB();
        String laptop = elementFromDatabase.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_ELECTRONICS, laptop);
        scrollToElementUsingJavaScript(WEB_ELEMENT_CHECKBOX_$230_TO_$450);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHECKBOX_$230_TO_$450);
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_TO_MACBOOK);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_TO_MACBOOK);
    }

    /**
     * Action Method #8
     * @throws InterruptedException
     */

    public void hoverOverFeaturedItems() throws InterruptedException {
        robotScrollDown(4);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_LAPTOP);
        robotScrollDown(3);
        basicHoverUsingXpath(WEB_ELEMENT_DROPDOWN_FEATURE_ITEMS);
    }

    public void hoverOverFeaturedItemsNClick() throws InterruptedException {
        robotScrollDown(6);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_LAPTOP);
        robotScrollDown(3);
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_DROPDOWN_FEATURE_ITEMS, WEB_ELEMENT_LINK_LOWEST_PRICE);
        implicitWait(10);
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_DROPDOWN_VIEW_OPTIONS,WEB_ELEMENT_LINK_VIEW_OPTIONS);
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_CHROMEBOOK);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CHROMEBOOK);
        clickByXpathUsingJavaScript(webElementClickAddToCart);
    }

    public void doubleClickOnDropDown() throws InterruptedException {
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SMART_HOME);
        robotScrollDown(6);
        WebWaitUntilClickableNClick(20,WEB_ELEMENT_CHECKBOX_IRIS1);
        fluentWait();
        robotScrollDown(10);
        doubleClickUsingXpath(WEB_ELEMENT_DROPDOWN_DOUBLE_CLICK);
        sleepFor(3);

    }
}
