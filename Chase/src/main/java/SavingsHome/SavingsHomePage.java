package SavingsHome;

import SavingsHome.SavingsData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static SavingsHome.SavingsWebElements.*;

public class SavingsHomePage extends WebAPI{


    //Constructor of class
    public SavingsHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_SAVINGS)
    public WebElement Savings;

    // OPEN ACCOUNT
    @FindBy(xpath = WEB_ELEMENT_LINK_WAIVE_FEES)
    public WebElement Fees;
    @FindBy(xpath = WEB_ELEMENT_LINK_OPEN_NOW)
    public WebElement Open;

    //INTEREST RATES
    @FindBy(xpath = WEB_ELEMENT_LINK_SEE_INTEREST_RATES)
    public WebElement Interest;
    @FindBy(xpath = WEB_ELEMENT_LINK_ENTER_ZIP_CODE)
    public WebElement ZipCode;



















    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_SAVINGS));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void clickWaiveFees() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_WAIVE_FEES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_WAIVE_FEES);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_OPEN_NOW);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_OPEN_NOW);

    }

    public void clickSeeInterestRates() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_SEE_INTEREST_RATES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SEE_INTEREST_RATES);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_ENTER_ZIP_CODE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_ENTER_ZIP_CODE);

    }

    public void SearchBar() {
        waitTimeUsingFluent(WEB_ELEMENT_SEARCH_BAR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR, WEB_ELEMENT_SEARCH_BAR);
    }


    public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Savings = elementFromExcel.get(2);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Savings);
    }

    public void SendKeysSignin() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Signin = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Signin);
    }

    public void SendKeysTotal() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Total = elementFromExcel.get(5);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Total);
    }


}









