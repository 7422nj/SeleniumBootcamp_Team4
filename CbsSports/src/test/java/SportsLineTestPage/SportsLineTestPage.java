package SportsLineTestPage;

import SportsLineHome.SpotsLineHomepage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static SportsLineHome.SpotsLineWebElements.*;
import static SportsLineHome.SpotsLineWebElements.WEB_ELEMENT_LINK_SPORTS_LINE;

public class SportsLineTestPage extends WebAPI {

    //Object of SportsLineHomepage class
    SpotsLineHomepage SportsLine = new SpotsLineHomepage();

    // Test #1
    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    // Test #2
    @Test(enabled = false)
    public void testExamples() throws InterruptedException, AWTException {
        SportsLine.exampleHover(); //called a method from SportsLineHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Color does not match");

    }


    // Test #3
    @Test
    public void testFindMasters() throws InterruptedException, AWTException {
        SportsLine.Masters();
        String expectedText = "MASTERS";
        assertEqualByXpath(WEB_ELEMENT_LINK_MASTERS, expectedText);

//    }@Test(enabled = false)
//    public void testFindOdds() {
//      SportsLine.Odds();
//     String expectedText = "Page opens";
//        assertEqualByXpath(WEB_ELEMENT_LINK_ODDS, expectedText);
    }

    // Test #4
    @Test
    public void testVerifyPageTitle () {
        String exp = "Sports Line";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #5
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "Sports LIne";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }

    // Test #6
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        SportsLine.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Scores");



    }











}
