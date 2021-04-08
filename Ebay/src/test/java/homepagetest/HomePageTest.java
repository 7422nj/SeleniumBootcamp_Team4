package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomePageTest extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    HomePage homePage = new HomePage();
    //////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(enabled = false)
    public void testRefreshPage() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F5);
        sleepFor(5);
    }
}