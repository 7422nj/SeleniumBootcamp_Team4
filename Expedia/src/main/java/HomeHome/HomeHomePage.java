package HomeHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
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
