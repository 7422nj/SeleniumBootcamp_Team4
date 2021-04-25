package ListsTestPage;

import ListsHome.ListsHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static ListsHome.ListsWebElements.*;

public class ListsTestPage extends WebAPI {


    //Object of WatchHomepage class
    ListsHomePage Lists = new ListsHomePage();
    //////////////////////////////////////////////////////


    // Test #1
    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    // Test #2
    @Test
    public void testVerifyPageTitle () {
        String exp = "Macys Lists";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #3
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "Macys Lists";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }

    // Test #4
    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        Lists.exampleHover(); //called a method from toysHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Color does not match");

    }

    // Test #5
    //Test GuestList
    @Test(enabled = false)
    public void testFindGuestList() {
        Lists.clickGuestList();
        String expectedText = "lists";
        assertEqualByXpath(WEB_ELEMENT_LINK_GUEST_LIST, expectedText);
    }

    // Test #6
    @Test(enabled = false)
    public void testFindKeepBrowsing() {
        Lists.clickKeepBrowsing();
        String expectedText = "other lists";
        assertEqualByXpath(WEB_ELEMENT_CLICK_KEEP_BROWSING, expectedText);
    }

    // Test #7
    @Test(enabled = false)
    public void testFindHome() {
        Lists.clickKeepBrowsing();
        String expectedText = "home stuff";
        assertEqualByXpath(WEB_ELEMENT_LINK_HOME, expectedText);
    }

    // Test #8
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        Lists.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"cloths");

    }


    // Test #9
    @Test(enabled = false)
    public void testSearchtoysUsingExel() throws Exception {
        Lists.SendKeystoys();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"toys");
    }


    // Test #10
    @Test(enabled = false)
    public void testSearchTVUsingExel() throws Exception {
        Lists.SendKeysTV();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"TV");
    }




}
