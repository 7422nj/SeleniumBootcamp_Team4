package SpecialOffersHome;

import SpecialOffersHome.OffersData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static SpecialOffersHome.SpecialOffersWebElements.*;

public class SpecialOffersHomePage extends WebAPI {


    //Constructor of class
    public SpecialOffersHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_SPECIAL_OFFERS)
    public WebElement SpecialOffers;

    // new offers
    @FindBy(xpath = WEB_ELEMENT_LINK_NEW_VEHICLE_OFFERS)
    public WebElement NewOffers;
    @FindBy(xpath = WEB_ELEMENT_CLICK_SHOW_FILTERS)
    public WebElement FilerOffers;




















    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_SPECIAL_OFFERS));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void clickSpecialOffers() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_SPECIAL_OFFERS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SPECIAL_OFFERS);
    }
    public void clickNewVehicleOffers(){
        waitTimeUsingFluent(WEB_ELEMENT_LINK_NEW_VEHICLE_OFFERS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_NEW_VEHICLE_OFFERS);

        waitTimeUsingFluent(WEB_ELEMENT_CLICK_SHOW_FILTERS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CLICK_SHOW_FILTERS);

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


    public void SendKeysGLA250SUV() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String GLA250SUV = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,GLA250SUV);
    }

    public void SendKeysA220Sedan() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String A220Sedan = elementFromExcel.get(1);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,A220Sedan);
    }






}
