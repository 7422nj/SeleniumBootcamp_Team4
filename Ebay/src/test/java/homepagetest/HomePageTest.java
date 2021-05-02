package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePageTest extends WebAPI {


    //initialized HomePage or create and object of the HomePage class  in HomePageTest in order to access elements
    HomePage homePage = new HomePage();

    @Test
    public void testDosearch() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F5);
        sleepFor(5);

    }

    @Test(priority = 1)
    public void testInputSearchAnything() throws InterruptedException {
        homePage.searchPhonesAndAccessories();

    }
}
















