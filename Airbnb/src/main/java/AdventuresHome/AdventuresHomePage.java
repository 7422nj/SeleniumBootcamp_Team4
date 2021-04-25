package AdventuresHome;

import AdventuresHome.AdventuresData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static AdventuresHome.AdventuresWebElements.*;

public class AdventuresHomePage extends WebAPI {


    //Constructor of class
    public AdventuresHomePage() {
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

    @FindBy(xpath = WEB_ELEMENTS_LINK_ADVENTURES)
    public WebElement Toys;

    @FindBy(xpath = WEB_ELEMENT_BUTTON_START_YOUR_SEARCH)
    public WebElement Search;

    @FindBy(xpath = WEB_ELEMENT_LINK_CALENDAR)
    public WebElement Calendar;

    @FindBy(xpath = WEB_ELEMENT_LINK_WEEKEND)
    public WebElement Weekend;


    @FindBy(xpath = WEB_ELEMENT_LINK_BECOME_A_HOST )
    public WebElement Become;
    @FindBy(xpath = WEB_ELEMENT_BUTTON_GET_STARTED)
    public WebElement Start;










    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENTS_LINK_ADVENTURES));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }





    public void SearchBar() {
        waitTimeUsingFluent(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH);
        typeOnElementNEnter(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH, WEB_ELEMENT_TEXT_SEARCH_BAR);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_CALENDAR);


        waitTimeUsingFluent(WEB_ELEMENT_LINK_CALENDAR);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CALENDAR);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_WEEKEND);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_WEEKEND);


    }
    public void clickBecomeAHost(){

        waitTimeUsingFluent(WEB_ELEMENT_LINK_BECOME_A_HOST);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BECOME_A_HOST);

        waitTimeUsingFluent(WEB_ELEMENT_BUTTON_GET_STARTED);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_GET_STARTED);

    }


    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Location  = elementFromExcel.get(0);
        typeOnElementNEnter(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH,Location);
    }
    public void SendKeysAfrica() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Africa  = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH,Africa);
    }
    public void SendKeysAlgeria() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Algeria  = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH,Algeria);
    }



    }