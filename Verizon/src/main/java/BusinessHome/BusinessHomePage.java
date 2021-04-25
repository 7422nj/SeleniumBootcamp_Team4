package BusinessHome;

import BusinessHome.BusinessData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static BusinessHome.BusinessWebElements.*;

public class BusinessHomePage extends WebAPI {


    //Constructor of class
    public BusinessHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_BUSINESS)
    public WebElement Business;









    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BUSINESS));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }

    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String business = elementFromExcel.get(0);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,business);
    }

    public void SendKeySupport() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Support = elementFromExcel.get(4);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Support);
    }


    public void SendKeysWifi() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Wifi = elementFromExcel.get(5);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Wifi);
    }



}
