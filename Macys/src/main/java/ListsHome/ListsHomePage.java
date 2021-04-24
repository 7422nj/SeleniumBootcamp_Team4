package ListsHome;

import ListsHome.ListsData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static ListsHome.ListsWebElements.*;

public class ListsHomePage extends WebAPI {


    //Constructor of class
    public ListsHomePage() {
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

    // Find By Annotation: First Approach <- Used to Convert String into WebElements
    @FindBy(xpath = exampleLocator)
    public WebElement ExampleName;
    @FindBy(xpath = WEB_ELEMENT_LINK_LISTS)
    public WebElement Toys;

    // GUEST LIST
    @FindBy(xpath = WEB_ELEMENT_LINK_GUEST_LIST)
    public WebElement GuestList;
    @FindBy(xpath = WEB_ELEMENT_CLICK_KEEP_BROWSING)
    public WebElement KeepBrowsing;
    @FindBy(xpath = WEB_ELEMENT_LINK_HOME)
    public WebElement Home;
























    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_LISTS));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void clickGuestList() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_GUEST_LIST);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_GUEST_LIST);

    }

    public void clickKeepBrowsing() {
        waitTimeUsingFluent(WEB_ELEMENT_CLICK_KEEP_BROWSING);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CLICK_KEEP_BROWSING);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_HOME);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME);

    }

    public void SearchBar() {
        waitTimeUsingFluent(WEB_ELEMENT_SEARCH_BAR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR, WEB_ELEMENT_SEARCH_BAR);
    }
    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Toys = elementFromExcel.get(0);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Toys);
    }

    }
