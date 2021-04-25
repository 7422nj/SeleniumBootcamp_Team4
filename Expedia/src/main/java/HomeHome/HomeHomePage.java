package HomeHome;

import HomeHome.HomeData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static HomeHome.HomeWebElements.*;

public class HomeHomePage extends WebAPI {


    //Constructor of class
    public HomeHomePage() {
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

    @FindBy(xpath = WEB_ELEMENT_DROP_DOWN_HEADER)
    public WebElement MoreTravel;






    public void SearchBar() {
        waitTimeUsingFluent(WEB_ELEMENT_SEARCH_BAR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR, WEB_ELEMENT_SEARCH_BAR);
    }

    public void SendKeysToSearchBarUsingExel() throws Exception {
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Home = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Home);
    }

    public void clickGames() {
        waitTimeUsingFluent(WEB_ELEMENT_DROP_DOWN_HEADER);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DROP_DOWN_HEADER);
    }


    public void SendKeysFlights() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Flights = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Flights);
    }

    public void SendKeysTrips() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Trips = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Trips);
    }











        // Action Method class
//        public void exampleHover() throws InterruptedException {
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            //Hover over Like-New Cams link using Actions
//            WebElement ele = driver.findElement(By.xpath());
//            //Creating object of an Actions class
//            Actions action = new Actions(driver);
//            //Performing the mouse hover action on the target element.
//            action.moveToElement(ele).perform();
//
//        }










    }
