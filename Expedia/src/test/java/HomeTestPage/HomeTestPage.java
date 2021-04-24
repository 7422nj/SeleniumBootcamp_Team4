package HomeTestPage;

import HomeHome.HomeHomePage;
import common.WebAPI;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static HomeHome.HomeWebElements.*;

public class HomeTestPage extends WebAPI {

    HomeHomePage Home = new HomeHomePage();


    // Test #1
    @Test(enabled = false)
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    // Test #2
    @Test(enabled = false)
    public void testVerifyPageTitle () {
        String exp = "Home Page Search";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #3
    @Test(enabled = false)
    public void testPageTitleInspection () {
        String expectedTitle = "Home Page Search";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }

    //Test #4
    @Test(enabled = false)
    public void testFindScrollDown() {
        Home.SearchBar();
        String expectedText = "Search Bar";
        assertEqualByXpath(WEB_ELEMENT_DROP_DOWN_HEADER, expectedText);
    }

    // Test #5
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        Home = new HomeHomePage();
        Home.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Hotels");



    }



}
