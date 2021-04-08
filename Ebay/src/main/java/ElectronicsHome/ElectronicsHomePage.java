package ElectronicsHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

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


    // Action Method class
    public void ElectronicsClickSmartHome() throws InterruptedException {
        waitTimeExplicit(webElementButtonElectronics); //explicit wait to click on  electronics tab
        electronics.click();

        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebElement firstResult = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLinkSmartHome)));
        smartHome.click();

        robot.keyPress(KeyEvent.VK_DOWN);//scrolls down
        WebDriverWait wait = new WebDriverWait(driver, 20); //waits for 20 seconds
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait3 = new WebDriverWait(driver, 20);
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait4 = new WebDriverWait(driver, 20);

        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebElement secondResult = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLinkGoogleItems)));
        googly.click();
    }

    /**
     * 1. Explicit Wait then click on Electronics Link
     * 2. Hover over Like-New Cams using Actions
     * 3. Click on Like-New Cams link using JavaScriptExecutor
     * 4. Scroll down using Robot
     */
    public void purchaseArloWireFreeSecurityCamera() {
        //Click on electronics
        waitTimeExplicit(webElementButtonElectronics);
        electronics.click();

        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(webElementLinkLikeNewCams));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

        //Click on Like-New Cams link using JavaScriptExecutor
        waitTimeExplicit(webElementLinkLikeNewCams);
        clickByXpathUsingJavaScript(webElementLinkLikeNewCams);

        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollBy(0,1000)");

        //Wait explicitly then clean on Arlo Wireless Camera
        waitTimeExplicit(webElementLinkArloCam);
        clickByXpathUsingJavaScript(webElementLinkArloCam);

        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,1000)");

        //Click on Add to Cart
        waitTimeExplicit(webElementClickAddToCart);
        clickByXpathUsingJavaScript(webElementClickAddToCart);

    }

    public void findItemWithin50MilesOf19082() throws InterruptedException, AWTException {
        clickByXpathUsingJavaScript(webElementButtonElectronics);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SMART_HOME);
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

}
