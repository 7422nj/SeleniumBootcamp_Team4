package WatchHome;

import WatchHome.WatchData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static WatchHome.WatchWebElements.*;

public class WatchHomePage extends WebAPI {

    //Constructor of class
    public WatchHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_WATCH)
    public WebElement Watch;

    //SOCCER
    @FindBy(xpath = WEB_ELEMENT_LINK_SOCCER)
    public WebElement Soccer;
    @FindBy(xpath = WEB_ELEMENT_LINK_SCORES)
    public WebElement Scores;


    //NFL
    @FindBy(xpath = WEB_ELEMENT_LINK_NFL)
    public WebElement Nfl;
    @FindBy(xpath = WEB_ELEMENT_LINK_NEWS)
    public WebElement News;









    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_WATCH));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }

    public void clickSoccer() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_SOCCER);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SOCCER);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_SCORES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SCORES);

    }
    public void clickNFL() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_NFL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_NFL);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_NEWS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_NEWS);

    }


    public void SearchBar() {
        waitTimeUsingFluent(WEB_ELEMENT_SEARCH_BAR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR, WEB_ELEMENT_SEARCH_BAR);
    }

        public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Watch = elementFromExcel.get(0);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Watch);
    }

    public void SendKeyTennis() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Tennis = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Tennis);
    }

    public void SendKeysGolf() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Golf = elementFromExcel.get(4);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Golf);
    }


}
