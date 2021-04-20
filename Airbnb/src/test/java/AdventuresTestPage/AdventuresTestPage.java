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


    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }


    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        Adventures.exampleHover(); //called a method from SportsLineHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"");

    }

    @Test
    public void testVerifyPageTitle(){
        String exp="Air BNB Adventures";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }
    @Test
    public void testPageTitleInspection(){
        String expectedTitle= "Air BNB Adventures";
        String actualTitle= driver.getTitle();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle,expectedTitle);
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void testSearchBar() {
        Adventures.SearchBar();
        String expectedText= "Adventures";
        assertEqualByXpath(WEB_ELEMENT_BUTTON_START_YOUR_SEARCH, expectedText);
    }

    @Test(enabled = false)
    public void testFindBecomeAHOst() {
        Adventures.clickBecomeAHost();
        String expectedText = "Get Started";
        assertEqualByXpath(WEB_ELEMENT_LINK_BECOME_A_HOST, expectedText);

    }
    @Test(enabled = false)
    public void testFindGetStarted() {
        Adventures.clickBecomeAHost();
        String expectedText = "Get Started";
        assertEqualByXpath(WEB_ELEMENT_BUTTON_GET_STARTED, expectedText);

    }

    }
















