package homepagetest;

import common.WebAPI;
import HomePage.HomePage;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePageTest extends WebAPI {
    // Test class
    HomePage homePage;
////////////////////////////////////////////////////////////////////////////////////////////////////////

    //@Ignore
    @Test(enabled = true)
    public void testSearchBox() throws InterruptedException, AWTException {
       Robot robot = new Robot();
       robot.keyPress(KeyEvent.VK_F5);
       sleepFor(5);

    }


    }

