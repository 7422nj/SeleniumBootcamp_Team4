package AdventuresTestPage;

import AdventuresHome.AdventuresHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;


import static AdventuresHome.AdventuresWebElements.*;

public class AdventuresTestPage extends WebAPI {


    AdventuresHomePage Adventures = new AdventuresHomePage();

    // Test #1
    @Test(enabled = false)
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    // Test #2
    @Test(enabled = false)
    public void testExamples() throws InterruptedException, AWTException {
        Adventures.exampleHover(); //called a method from SportsLineHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"");

    }

    // Test #3
    @Test(enabled = false)
    public void testVerifyPageTitle(){
        String exp="Air BNB Adventures";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #4
    @Test(enabled = false)
    public void testPageTitleInspection(){
        String expectedTitle= "Air BNB Adventures";
        String actualTitle= driver.getTitle();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle,expectedTitle);
        softAssert.assertAll();
    }

    // Test #5
    @Test(enabled = false)
    public void testSearchBar() {
        Adventures.SearchBar();
        String expectedText= "Adventures";
        assertEqualByXpath(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH, expectedText);
    }

    // Test #6
    @Test(enabled = false)
    public void testFindBecomeAHOst() {
        Adventures.clickBecomeAHost();
        String expectedText = "Get Started";
        assertEqualByXpath(WEB_ELEMENT_LINK_BECOME_A_HOST, expectedText);

    }

    // Test #7
    @Test(enabled = false)
    public void testFindGetStarted() {
        Adventures.clickBecomeAHost();
        String expectedText = "Get Started";
        assertEqualByXpath(WEB_ELEMENT_BUTTON_GET_STARTED, expectedText);

    }

    // Test #8
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        Adventures.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"USA");

    }


    // Test #9
    @Test(enabled = false)
    public void testSearchAfricaUsingExel() throws Exception {
        Adventures.SendKeysAfrica();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Africa");
    }


    // Test #10
    @Test(enabled = false)
    public void testSearchAlgeriaUsingExel() throws Exception {
        Adventures.SendKeysAlgeria();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Algeria");
    }
















    }
















