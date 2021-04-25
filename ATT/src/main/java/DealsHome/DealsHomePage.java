package DealsHome;

import DealsHome.DealsData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static DealsHome.DealsWebElement.*;

public class DealsHomePage extends WebAPI {


    //Constructor of class
    public DealsHomePage() {
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

    @FindBy(xpath = WEB_ELEMENT_LINK_DEALS)
    public WebElement DEALS;

    @FindBy(xpath = WEB_ELEMENT_LINK_WIRELESS)
    public WebElement Wireless;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_ACCESSORIES)
    public WebElement Accessories;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_CASES)
    public WebElement Cases ;




    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_DEALS));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }

    public void clickWireless() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_WIRELESS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_WIRELESS);

    }

    public void clickAccessories() {
        waitTimeUsingFluent(WEB_ELEMENT_BUTTON_ACCESSORIES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_ACCESSORIES);

    }
    public void clickCases() {
        waitTimeUsingFluent(WEB_ELEMENT_BUTTON_CASES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CASES);

    }

    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Deals = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Deals);

    }

    public void SendKeysInternet() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Internet = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Internet);
    }

    public void SendKeysTelevision() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Television = elementFromExcel.get(4);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Television);
    }







    }
