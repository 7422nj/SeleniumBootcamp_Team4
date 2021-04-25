package BuyHome;

import BuyHome.BuyData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static BuyHome.BuyWebElements.*;

public class BuyHomePage extends WebAPI {


    //Constructor of class
    public BuyHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_BUY)
    public WebElement Buy;

    // test Search
   @FindBy(xpath = WEB_ELEMENT_LINK_SEARCH)
    public WebElement Search;












    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BUY));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void clickSearch() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_SEARCH);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SEARCH);

    }
    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SEARCH);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Buy= elementFromExcel.get(0);
        typeOnElementNEnter(WEB_ELEMENT_LINK_SEARCH,Buy);
    }


    public void SendKeysCar() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Car = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Car);
    }


    public void SendKeysMore() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String More = elementFromExcel.get(4);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,More);
    }
}
