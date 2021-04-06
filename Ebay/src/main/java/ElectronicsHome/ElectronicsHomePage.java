package ElectronicsHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Find By Annotation: First Approach <- Used to Convert String into WebElements
    @FindBy(how = How.XPATH, using = exampleLocator)
    public WebElement ExampleName;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Action Method class
    public void ElectronicsClickSmartHome() throws InterruptedException {
        waitTimeExplicit(webElementButtonElectronics); //explicit wait to click on  electronics tab
        clickByXpath(webElementButtonElectronics); //click on electronics tab

        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebElement firstResult = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLinkSmartHome)));
        clickByXpath(webElementLinkSmartHome); //click on smart home

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
        clickByXpath(webElementLinkGoogleItems);
    }

    /**
     * 1. Explicit Wait then click on Electronics Link
     * 2. Hover over Like-New Cams using Actions
     * 3. Click on Like-New Cams link using JavaScriptExecutor
     * 4. Scroll down using Robot
     */
    public void purchaseArloWireFreeSecurityCamera() {
        //Click on electronics
        WebDriverWait sleep = new WebDriverWait(driver,10);
        sleep.until(ExpectedConditions.elementToBeClickable(By.xpath(webElementButtonElectronics)));
        clickByXpath(webElementButtonElectronics); //click on electronics tab

        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(webElementLinkLikeNewCams));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

        //Click on Like-New Cams link using JavaScriptExecutor
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLinkLikeNewCams)));
        WebElement element = driver.findElement(By.xpath(webElementLinkLikeNewCams));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);

        //Scroll down using robot
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait deep = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait down = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait its = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait okay = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait to = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait pawri = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait hawri = new WebDriverWait(driver,10);

        //Wait explicitly then clean on Arlo Wireless Camera
        waitTimeExplicit(webElementLinkArloCam);
        clickByXpathUsingJavaScript(webElementLinkArloCam);

        //Scroll down using robot
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait deep1 = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait down1 = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait its1 = new WebDriverWait(driver,10);
        robot.keyPress(KeyEvent.VK_DOWN);
        WebDriverWait okay1 = new WebDriverWait(driver,10);

        //Click on Add to Cart
        waitTimeExplicit(webElementClickAddToCart);
        clickByXpathUsingJavaScript(webElementClickAddToCart);




    }
}
