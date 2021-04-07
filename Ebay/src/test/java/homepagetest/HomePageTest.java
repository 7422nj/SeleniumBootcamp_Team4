package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static homepage.HomePageWebElement.*;

public class HomePageTest extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    HomePage homePage = new HomePage();

    //////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(enabled = true)
    public void testSearchBox() throws InterruptedException, AWTException {
//       Robot robot = new Robot();
//       robot.keyPress(KeyEvent.VK_F5);
//       sleepFor(5);

        homePage.exampleActionMethod();
        String expectedText = "US $74.99/ea";
        assertEqualByXpath(WEB_ELEMENT_VERIFY_PRICE, expectedText);

    }


    }

