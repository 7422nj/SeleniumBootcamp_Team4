package MyBMWHome;

import MyBMWHome.MyBMWData.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static MyBMWHome.MyBMWWebElements.*;
public class MyBMWHomePage extends WebAPI {



        //Constructor of class
        public MyBMWHomePage() {
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
    @FindBy(xpath = WEB_ELEMENT_LINK_MyBMW)
    public WebElement MyBMW;

    @FindBy(xpath = WEB_ELEMENT_LINK_MODELS)
    public WebElement Models;
    @FindBy(xpath = WEB_ELEMENT_LINK_ALL_MODELS)
    public WebElement AllModels;










    // Action Method class
    public void exampleHover() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(WEB_ELEMENT_LINK_MyBMW));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();

    }


    public void clickModels() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_MODELS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_MODELS);

    }
    public void clickAllModels() {
        waitTimeUsingFluent(WEB_ELEMENT_LINK_ALL_MODELS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_MODELS);

    }

    public void SearchBar() {
        waitTimeUsingFluent(WEB_ELEMENT_SEARCH_BAR);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR, WEB_ELEMENT_SEARCH_BAR);
    }

        public void SendKeysToSearchBarUsingExel() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_SEARCH_BAR);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String Toys = elementFromExcel.get(3);
        typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR,Toys);



    }









}




