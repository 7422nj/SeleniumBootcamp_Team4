package SportsLineHome;

import SportsLineHome.SportsLineData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static SportsLineHome.SpotsLineWebElements.*;

public class SpotsLineHomepage extends WebAPI {

    //Constructor of class
    public SpotsLineHomepage() {
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


    @FindBy(xpath =WEB_ELEMENT_LINK_SPORTS_LINE)
    public WebElement SportsLine;

    @FindBy(xpath = WEB_ELEMENT_LINK_MASTERS)
    public WebElement Masters;

    @FindBy(xpath = WEB_ELEMENT_LINK_ODDS)
    public WebElement Odds;

    @FindBy(xpath = WEB_ELEMENT_Ad)
    public WebElement Ads;

    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_SPORTS_LINE));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void Masters() throws InterruptedException, AWTException {
        robotScrollDown(4);
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_LINK_MASTERS);
       WebWaitUntilClickByXpath(20,WEB_ELEMENT_LINK_ODDS);

    }


    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String SportsLine = elementFromExcel.get(0);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,SportsLine);
    }


    public void SendKeyPlay() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Play = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Play);
    }


    public void SendKeysBet() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Bet = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Bet);
    }






    }
