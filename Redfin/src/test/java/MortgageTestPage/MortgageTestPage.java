package MortgageTestPage;

import MortgageHome.MortgageHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static MortgageHome.MortgageWebElements.*;

public class MortgageTestPage extends WebAPI {

    MortgageHomePage Mortgage = new MortgageHomePage();





    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    @Test
    public void testVerifyPageTitle () {
        String exp = "Redfin Mortgage";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "Redfin Mortgage";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
        softAssert.assertNotSame(actualTitle, expectedTitle);
        softAssert.assertAll();
    }


    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        Mortgage.exampleHover(); //called a method from MortgageHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Current Mortgage Rate");

    }


    //Test Lender
    @Test(enabled = false)
    public void testFindlender() {
        Mortgage.clickLender();
        String expectedText = "Semper Home Loans, Inc";
        assertEqualByXpath(WEB_ELEMENT_LINK_LENDER, expectedText);
    }

    @Test(enabled = false)
    public void testFindImage() {
        Mortgage.clickLender();
        String expectedText = "NMLS:1053";
        assertEqualByXpath(WEB_ELEMENT_LINK_IMAGE, expectedText);
    }
    @Test(enabled = false)
    public void testFindLoanType() {
        Mortgage.clickLender();
        String expectedText = "NMLS:1053";
        assertEqualByXpath(WEB_ELEMENT_SELECT_LOAN_TYPE, expectedText);
    }

    // Test SecondPage

    @Test(enabled = false)
    public void testFindSecondPage() {
        Mortgage.clickSecondPage();
        String expectedText = "More Loan Options";
        assertEqualByXpath(WEB_ELEMENT_LINK_SECOND_PAGE, expectedText);
    }

    @Test(enabled = false)
    public void testFindGetStarted() {
        Mortgage.clickSecondPage();
        String expectedText = "BNC national Bank";
        assertEqualByXpath(WEB_ELEMENT_CLICK_GET_STARTED, expectedText);
    }
    @Test(enabled = false)
    public void testFindContinue() {
        Mortgage.clickSecondPage();
        String expectedText = "Verify Zip Code";
        assertEqualByXpath(WEB_ELEMENT_CLICK_CONTINUE, expectedText);
    }





}
