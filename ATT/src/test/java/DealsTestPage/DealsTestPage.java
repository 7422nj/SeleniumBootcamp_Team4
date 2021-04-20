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


        @Test
        public void testGetCurrentUrl() throws AWTException, InterruptedException{
            String expect="";
            String actual= driver.getCurrentUrl();
            Assert.assertEquals(actual,expect);
        }
        @Test(enabled = true)
        public void testExamples() throws InterruptedException, AWTException {
            Deals.exampleHover(); //called a method from Deals class
            String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
            String expectedAttributeValue = "";
            Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "");
        }

            @Test(enabled = false)
            public void testFindWireless(){
                Deals.clickWireless();
                String expectedText = "Get Started";
                assertEqualByXpath(WEB_ELEMENT_LINK_WIRELESS, expectedText);

            }
            @Test
            public void testVerifyPageTitle () {
                String exp = "ATT Deals";
                String act = driver.getTitle();
                Assert.assertTrue(exp.equalsIgnoreCase(act));
            }
            @Test
            public void testPageTitleInspection () {
                String expectedTitle = "ATT  Deals";
                String actualTitle = driver.getTitle();
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertEquals(actualTitle, expectedTitle);
                softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
                softAssert.assertNotSame(actualTitle, expectedTitle);
                softAssert.assertAll();
            }

        @Test(enabled = false)
        public void testFindAccessories(){
            Deals.clickAccessories();
            String expectedText = "Get accessories";
            assertEqualByXpath(WEB_ELEMENT_BUTTON_ACCESSORIES, expectedText);

        }
        @Test(enabled = false)
        public void testFindCases(){
            Deals.clickCases();
            String expectedText = "Get Cases";
            assertEqualByXpath(WEB_ELEMENT_BUTTON_CASES, expectedText);

        }


        }








