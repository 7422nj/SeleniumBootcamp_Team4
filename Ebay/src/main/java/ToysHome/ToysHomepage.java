package ToysHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static ToysHome.ToysWebElements.*;

public class ToysHomepage extends WebAPI {

    //Constructor of class
    public ToysHomepage() {
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
    @FindBy(xpath = exampleLocator)
    public WebElement ExampleName;

    @FindBy(xpath = WEB_ELEMENT_DROPDOWN_GAMES)
    public WebElement Games;

    @FindBy(xpath = WEB_ELEMENT_LINK_CHESS)
    public WebElement Chess;

    @FindBy(xpath = WEB_ELEMENT_LINK_OTHER_CHESS)
    public WebElement OtherChess;

    @FindBy(xpath = WEB_ELEMENT_LINK_TOYS)
    public WebElement Toys;




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_TOYS));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }
    public void clickGames(){
        waitTimeUsingFluent(WEB_ELEMENT_DROPDOWN_GAMES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DROPDOWN_GAMES);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_CHESS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CHESS);

        waitTimeExplicit(WEB_ELEMENT_LINK_OTHER_CHESS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_OTHER_CHESS);

    }
    public void SearchBar(){
        waitTimeUsingFluent(WEB_ELEMENT_SEARCH_BAR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,WEB_ELEMENT_TEXT_SEARCH_BAR);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_AUCTION);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_AUCTION);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_PRICE_FILTER);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_PRICE_FILTER);
    }

}
