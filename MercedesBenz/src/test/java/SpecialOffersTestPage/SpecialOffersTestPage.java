package SpecialOffersTestPage;

import SpecialOffersHome.SpecialOffersHomePage;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static SpecialOffersHome.SpecialOffersWebElements.*;

public class SpecialOffersTestPage extends WebAPI {

    SpecialOffersHomePage SpecialOffers = new SpecialOffersHomePage();




    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    @Test
    public void testVerifyPageTitle () {
        String exp = "Mercedes Offers";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "Mercedes Offers";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }


    //Test Special Offers
    @Test(enabled = false)
    public void testFindSpecialOffers() {
        SpecialOffers.clickSpecialOffers();
        String expectedText = "other offers";
        assertEqualByXpath(WEB_ELEMENT_LINK_SPECIAL_OFFERS, expectedText);
    }
    @Test(enabled = false)
    public void testFindNewVehicleOffers() {
        SpecialOffers.clickNewVehicleOffers();
        String expectedText = "New Vehicles";
        assertEqualByXpath(WEB_ELEMENT_LINK_NEW_VEHICLE_OFFERS, expectedText);
        assertEqualByXpath(WEB_ELEMENT_CLICK_SHOW_FILTERS, expectedText);
    }





}