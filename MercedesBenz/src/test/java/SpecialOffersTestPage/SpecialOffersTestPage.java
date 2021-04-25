package SpecialOffersTestPage;

import SpecialOffersHome.OffersData.DataSource;
import SpecialOffersHome.SpecialOffersHomePage;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.List;

import static SpecialOffersHome.SpecialOffersWebElements.*;

public class SpecialOffersTestPage extends WebAPI {

    SpecialOffersHomePage SpecialOffers = new SpecialOffersHomePage();



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
        String exp = "Mercedes Offers";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #3
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

    // Test #4
    //Test Special Offers
    @Test(enabled = false)
    public void testFindSpecialOffers() {
        SpecialOffers.clickSpecialOffers();
        String expectedText = "other offers";
        assertEqualByXpath(WEB_ELEMENT_LINK_SPECIAL_OFFERS, expectedText);
    }

    // Test #5
    @Test(enabled = false)
    public void testFindNewVehicleOffers() {
        SpecialOffers.clickNewVehicleOffers();
        String expectedText = "New Vehicles";
        assertEqualByXpath(WEB_ELEMENT_LINK_NEW_VEHICLE_OFFERS, expectedText);
        assertEqualByXpath(WEB_ELEMENT_CLICK_SHOW_FILTERS, expectedText);
    }

    // Test #6
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        SpecialOffers.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"2021 C 300 Sedan");
    }


    // Test #7
    @Test(enabled = false)
    public void testSearchGLA250SUVUsingExel() throws Exception {
        SpecialOffers.SendKeysGLA250SUV();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"GLA250SUV");
    }


    // Test #8
    @Test(enabled = false)
    public void testSearchA220SedanUsingExel() throws Exception {
        SpecialOffers.SendKeysA220Sedan();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"A220Sedan");
    }




}
