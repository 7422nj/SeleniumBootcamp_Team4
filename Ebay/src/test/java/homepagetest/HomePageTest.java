package homepagetest;

import common.WebAPI;
import MercedesMainPage.HomePage;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePageTest extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    HomePage homePage = new HomePage();

    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(enabled = false)
    public void testRefreshPage() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F5);
        sleepFor(5);



    }
}