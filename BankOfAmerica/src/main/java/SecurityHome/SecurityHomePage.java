package SecurityHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import static SecurityHome.SecurityWebElement.*;


public class SecurityHomePage extends WebAPI {

    //Constructor of class
    public SecurityHomePage() {
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


    @FindBy(xpath = exampleLocator)
    public WebElement ExampleName;
    @FindBy(xpath = WEB_ELEMENT_LINK_SECURITY)
    public WebElement Security;

    @FindBy(xpath = WEB_ELEMENT_LINK_LOCATIONS)
    public WebElement Locations ;







    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_SECURITY));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }
    public void clickSecurity() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_SECURITY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SECURITY);

    }

    public void clickLocations () {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_LOCATIONS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_LOCATIONS);

    }









}
