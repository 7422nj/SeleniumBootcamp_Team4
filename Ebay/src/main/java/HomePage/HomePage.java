package HomePage;

import common.WebAPI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

import static HomePage.HomePageWebElement.*;

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
    @FindBy(xpath = exampleLocator)
    public WebElement ExampleName;



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Action Method
    public void exampleActionMethod() throws InterruptedException, IOException {


    }

}



















