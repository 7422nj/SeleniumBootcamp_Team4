package BuyTestPage;

import BuyHome.BuyHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static BuyHome.BuyWebElements.*;

public class BuyTestPage extends WebAPI {

BuyHomePage Buy= new BuyHomePage();




    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    @Test
    public void testVerifyPageTitle () {
        String exp = "Trulia Buy Products";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "Trulia Buy Products";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        Buy.exampleHover(); //called a method from BuyHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Buy Home");

    }

    //Test Buy
    @Test(enabled = false)
    public void testFindSearch() {
        Buy.clickSearch();
        String expectedText = "search area";
        assertEqualByXpath(WEB_ELEMENT_LINK_SEARCH, expectedText);
    }



}
