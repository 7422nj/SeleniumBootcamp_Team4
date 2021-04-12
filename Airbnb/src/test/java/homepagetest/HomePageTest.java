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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    HomePage home = new HomePage();
    ////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Test #1
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testGetCurrentUrl() throws AWTException, InterruptedException {
       home.getCurrentSiteUrl();
       assertEqualsGetCurrentUrl("https://www.airbnb.com/");
    }

    /**
     * Test #2
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testLocationSearchFieldIsEnabled() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        assertTrueIsEnabled(WEB_ELEMENT_SEARCH_LOCATION);
    }

    /**
     * Test #3
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test
    public void testLocationSearchFieldIsDisplayed() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        assertTrueIsDisplayed(WEB_ELEMENT_SEARCH_LOCATION);
    }

    /**
     * Test #4
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testLocationSearchFieldIsSelected() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        assertFalseIsSelected(WEB_ELEMENT_SEARCH_LOCATION);
    }

    /**
     * Test #5
     * @throws AWTException
     * @throws InterruptedException
     */

    @Test
    public void testLocationSearchFieldGetAttribute() throws AWTException, InterruptedException {
        home.enterTextInLocationField();
        assertEqualsGetAttribute("bootcamp404",WEB_ELEMENT_SEARCH_LOCATION,"value");
    }
}

