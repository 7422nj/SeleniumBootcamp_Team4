package MortgageHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static MortgageHome.MortgageWebElements.*;

public class MortgageHomePage extends WebAPI {


    //Constructor of class
    public MortgageHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_MORTGAGE)
    public WebElement Mortgage;
    //TEST LENDER
    @FindBy(xpath = WEB_ELEMENT_LINK_LENDER)
    public WebElement Lender;
    @FindBy(xpath = WEB_ELEMENT_LINK_IMAGE)
    public WebElement Image;
    @FindBy(xpath = WEB_ELEMENT_SELECT_LOAN_TYPE)
    public WebElement LoanType;

    //TEST SecondPage
    @FindBy(xpath = WEB_ELEMENT_LINK_SECOND_PAGE)
    public WebElement SecondPage;
    @FindBy(xpath = WEB_ELEMENT_CLICK_GET_STARTED)
    public WebElement GetStarted;
    @FindBy(xpath = WEB_ELEMENT_CLICK_CONTINUE)
    public WebElement Continue;















    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_MORTGAGE));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void clickLender() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_LENDER);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_LENDER);

        waitTimeUsingFluent(WEB_ELEMENT_LINK_IMAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_IMAGE);
        waitTimeUsingFluent(WEB_ELEMENT_SELECT_LOAN_TYPE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SELECT_LOAN_TYPE);

    }
    public void clickSecondPage() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_SECOND_PAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SECOND_PAGE);

        waitTimeUsingFluent(WEB_ELEMENT_CLICK_GET_STARTED);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CLICK_GET_STARTED);
        waitTimeUsingFluent(WEB_ELEMENT_CLICK_CONTINUE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CLICK_CONTINUE);

    }






}
