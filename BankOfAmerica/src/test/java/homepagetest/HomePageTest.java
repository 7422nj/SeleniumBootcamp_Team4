package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class HomePageTest extends WebAPI {
    // Test class
    HomePage homePage;
    // Registration registration;

        @Test(enabled = true)
        public void testSearchBox () throws InterruptedException, AWTException {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F5);
            sleepFor(5);

        }
        @Test
        public void testVerifyPageTitle () {
            String exp = "Home Page Search";
            String act = driver.getTitle();
            Assert.assertTrue(exp.equalsIgnoreCase(act));
        }
        @Test
        public void testPageTitleInspection () {
            String expectedTitle = "Home Page Search";
            String actualTitle = driver.getTitle();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(actualTitle, expectedTitle);
            softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
            softAssert.assertNotSame(actualTitle, expectedTitle);
            softAssert.assertAll();
        }


    }


