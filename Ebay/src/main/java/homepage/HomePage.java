package homepage;

import common.WebAPI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static homepage.HomePageWebElement.*;

public class HomePage  extends WebAPI {

    //Constructor of class
    public HomePage () {
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
//    @FindBy(how = How.XPATH, using = exampleLocator)
//    public WebElement ExampleName;

    @FindBy( xpath = WEB_ELEMENT_SEARCH_BAR)
    public WebElement SearchBar;

    @FindBy( xpath = WEB_ELEMENT_TEXT_SEARCH_BAR)
    public WebElement SearchText;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Action Method class
    public void exampleActionMethod() throws InterruptedException {
    waitTimeExplicit(WEB_ELEMENT_SEARCH_BAR);
    typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR, WEB_ELEMENT_TEXT_SEARCH_BAR);//this line work with line 48 and 49
       // SearchBar.sendKeys(WEB_ELEMENT_TEXT_SEARCH_BAR);
        robot.keyPress(KeyEvent.VK_ENTER);
        lowestLaptopPrice();

    }
    public void lowestLaptopPrice(){
       // waitTimeExplicit(WEB_ELEMENT_LAPTOP_PRICE_SEARCH);
        clickByXpath(WEB_ELEMENT_LAPTOP_PRICE_SEARCH);
        clickByXpath(WEB_ELEMENT_CHEAP_DELL_LAPTOP);
    }
}



















