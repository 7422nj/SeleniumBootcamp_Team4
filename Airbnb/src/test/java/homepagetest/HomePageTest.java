package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePageTest extends WebAPI {
    // Test class
    public static HomePage homePage = new HomePage();
    // Registration registration;


    //@Ignore
    @Test(enabled = true)
    public void testSearchBox() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F5);
        sleepFor(5);


    }

    @Test(priority = 1)
    public void experienceEntertainment() throws InterruptedException {
        homePage.onLineCustomerExperience();

    }


}



