package SavingsTestPage;

import SavingsHome.SavingsHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static SavingsHome.SavingsWebElements.*;

public class SavingsTestPage extends WebAPI {

    //Object of ToysHomepage class
    SavingsHomePage Savings = new SavingsHomePage();


    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }



    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        Savings.exampleHover(); //called a method from toysHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Color does not match");

    }


    @Test
    public void testVerifyPageTitle () {
        String exp = "Savings Account";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "Savings Account";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }


    //Test OPEN SAVINGS
    @Test(enabled = false)
    public void testFindWaiveFees() {
        Savings.clickWaiveFees();
        String expectedText = "FEES";
        assertEqualByXpath(WEB_ELEMENT_LINK_WAIVE_FEES, expectedText);
    }

    @Test(enabled = false)
    public void testFindOpenNow() {
        Savings.clickWaiveFees();
        String expectedText = "OPEN SAVING";
        assertEqualByXpath(WEB_ELEMENT_LINK_OPEN_NOW, expectedText);
    }


    //Test SEE INTEREST RATES
    @Test(enabled = false)
    public void testFindSeeInterestRates() {
        Savings.clickSeeInterestRates();
        String expectedText = "other";
        assertEqualByXpath(WEB_ELEMENT_LINK_SEE_INTEREST_RATES, expectedText);
    }

    @Test(enabled = false)
    public void testFindEnterZipCode() {
        Savings.clickSeeInterestRates();
        String expectedText = "Soccer Scores";
        assertEqualByXpath(WEB_ELEMENT_LINK_ENTER_ZIP_CODE, expectedText);
    }



}