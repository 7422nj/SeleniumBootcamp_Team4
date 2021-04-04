package ElectronicsHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static ElectronicsHome.ElectronicsWebElements.*;
//packageName.className.*;
public class ElectronicsHomePage extends WebAPI {

    //Constructor of class
    public ElectronicsHomePage () {
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
        WebElement firstResult = new WebDriverWait(driver,20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLinkSmartHome)));
        clickByXpath(webElementLinkSmartHome); //click on smart home

        robot.keyPress(KeyEvent.VK_DOWN);//scrolls down
        WebDriverWait wait = new WebDriverWait(driver,20); //waits for 20 seconds
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait2 = new WebDriverWait(driver,20);
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait3 = new WebDriverWait(driver,20);
        robot.keyPress(KeyEvent.VK_DOWN); //scrolls down
        WebDriverWait wait4 = new WebDriverWait(driver,20);

        // Initialize and wait till element(link) became clickable - timeout in 20 seconds
        WebElement secondResult = new WebDriverWait(driver,20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(webElementLinkGoogleItems)));
        clickByXpath(webElementLinkGoogleItems);





    }
}
