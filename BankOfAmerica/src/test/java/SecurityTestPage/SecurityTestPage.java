package SecurityTestPage;

import SecurityHome.SecurityHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.security.Security;

import static SecurityHome.SecurityWebElement.*;

public class SecurityTestPage extends WebAPI {

    SecurityHomePage Security= new SecurityHomePage();


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
        String exp = "Home Page Search";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #3
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


    // Test #4
    @Test(enabled = false)
    public void testExamples() throws InterruptedException, AWTException {
        Security.exampleHover(); //called a method from Deals class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "");
    }

    // Test #5
    @Test(enabled = false)
    public void testFindSecurity(){
        Security.clickSecurity();
        String expectedText = "Get Locations";
        assertEqualByXpath(WEB_ELEMENT_LINK_SECURITY, expectedText);

    }

    // Test #6
    @Test(enabled = false)
    public void testFindLocations(){
        Security.clickLocations();
        String expectedText = "Get Locations";
        assertEqualByXpath(WEB_ELEMENT_LINK_LOCATIONS, expectedText);

    }

    // Test #7
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        Security.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"See how to spot fraud");

    }


    // Test #8
    @Test(enabled = false)
    public void testSearchCheckingUsingExel() throws Exception {
        Security.SendKeyChecking();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Checking");
    }


    // Test #9
    @Test(enabled = false)
    public void testSearchHelpUsingExel() throws Exception {
        Security.SendKeysHelp();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Help");
    }


}
