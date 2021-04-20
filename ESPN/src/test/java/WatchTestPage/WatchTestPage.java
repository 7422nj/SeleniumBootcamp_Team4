package WatchTestPage;

import WatchHome.WatchHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static WatchHome.WatchWebElements.*;

public class WatchTestPage extends WebAPI {


    //Object of WatchHomepage class
    WatchHomePage Watch = new WatchHomePage();
    //////////////////////////////////////////////////////



    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
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


    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        Watch.exampleHover(); //called a method from WatchHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Watch Sports");

    }

    //Test Soccer
    @Test(enabled = false)
    public void testFindSoccer() {
        Watch.clickSoccer();
        String expectedText = "other games";
        assertEqualByXpath(WEB_ELEMENT_LINK_SOCCER, expectedText);
    }

    @Test(enabled = false)
    public void testFindScores() {
        Watch.clickSoccer();
        String expectedText = "Soccer Scores";
        assertEqualByXpath(WEB_ELEMENT_LINK_SCORES, expectedText);
    }

    //test NFL
    @Test(enabled = false)
    public void testFindNFL() {
        Watch.clickNFL();
        String expectedText = "other games";
        assertEqualByXpath(WEB_ELEMENT_LINK_NFL, expectedText);
    }

    @Test(enabled = false)
    public void testFindNews() {
        Watch.clickNFL();
        String expectedText = "Soccer Scores";
        assertEqualByXpath(WEB_ELEMENT_LINK_NEWS, expectedText);
    }



}
