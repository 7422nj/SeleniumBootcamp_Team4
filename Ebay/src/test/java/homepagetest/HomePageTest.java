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

public class HomePageTest extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    HomePage homePage;
    //////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(enabled = true)
    public void testRefreshPage() throws InterruptedException, AWTException {
       Robot robot = new Robot();
       robot.keyPress(KeyEvent.VK_F5);
       sleepFor(5);

    }


    }

