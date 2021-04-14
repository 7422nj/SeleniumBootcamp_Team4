package homepagetest;

import common.WebAPI;
import HomePage.HomePage;
import org.testng.annotations.Test;

import java.awt.*;

public class HomePageTest extends WebAPI {
    // Test class
    HomePage homePage = new HomePage();
    //////////////////////////////////////////////////////////////////////////////////////////////////

    //@Ignore
    @Test(enabled = true)
    public void testSearchBox() throws InterruptedException, AWTException {
        refresh();

    }


    }

