package BusinessTestPage;

import BusinessHome.BusinessHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static BusinessHome.BusinessWebElements.*;

public class BusinessTestPage extends WebAPI {

BusinessHomePage Business= new BusinessHomePage();


    // Test #1
    @Test(enabled = false)
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    // Test #2
    @Test(enabled = false)
    public void testVerifyPageTitle () {
        String exp = "Verizon Business";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #3
    @Test(enabled = false)
    public void testPageTitleInspection () {
        String expectedTitle = "Verizon Business";
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
        Business.exampleHover(); //called a method from WatchHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Watch Sports");

    }

    // Test #5
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        Business.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"SmallBusiness");



    }



}
