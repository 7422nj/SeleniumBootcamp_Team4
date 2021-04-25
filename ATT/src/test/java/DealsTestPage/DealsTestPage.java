package DealsTestPage;

import DealsHome.DealsHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.awt.*;
import java.awt.event.KeyEvent;

import static DealsHome.DealsWebElement.*;

    public class DealsTestPage extends WebAPI {
        DealsHomePage Deals = new DealsHomePage();


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
            Deals.exampleHover(); //called a method from Deals class
            String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
            String expectedAttributeValue = "";
            Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "");
        }


        // Test #3
        @Test(enabled = false)
        public void testFindWireless(){
                Deals.clickWireless();
                String expectedText = "Get Started";
                assertEqualByXpath(WEB_ELEMENT_LINK_WIRELESS, expectedText);

            }

        // Test #4
            @Test(enabled = false)
            public void testVerifyPageTitle () {
                String exp = "ATT Deals";
                String act = driver.getTitle();
                Assert.assertTrue(exp.equalsIgnoreCase(act));
            }

        // Test #5
            @Test(enabled = false)
            public void testPageTitleInspection () {
                String expectedTitle = "ATT  Deals";
                String actualTitle = driver.getTitle();
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertEquals(actualTitle, expectedTitle);
                softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
                softAssert.assertNotSame(actualTitle, expectedTitle);
                softAssert.assertAll();
            }


        // Test #6
        @Test(enabled = false)
        public void testFindAccessories(){
            Deals.clickAccessories();
            String expectedText = "Get accessories";
            assertEqualByXpath(WEB_ELEMENT_BUTTON_ACCESSORIES, expectedText);

        }

        // Test #7
        @Test(enabled = false)
        public void testFindCases(){
            Deals.clickCases();
            String expectedText = "Get Cases";
            assertEqualByXpath(WEB_ELEMENT_BUTTON_CASES, expectedText);

        }

        // Test #8
        @Test
        public void testSendKeysToSearchBarUsingExel() throws Exception {
            Deals.SendKeysToSearchBarUsingExel();
            Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Bundles");
        }


        // Test #9
        @Test(enabled = false)
        public void testSearchInternetUsingExel() throws Exception {
            Deals.SendKeysInternet();
            Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Internet");
        }


        // Test #10
        @Test(enabled = false)
        public void testSearchTelevisionUsingExel() throws Exception {
            Deals.SendKeysTelevision();
            Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"Television");
        }


        }








