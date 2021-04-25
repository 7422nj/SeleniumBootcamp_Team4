package MyBmwTestPage;

import MyBMWHome.MyBMWHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import static MyBMWHome.MyBMWWebElements.*;

public class MyBmwTestPage extends WebAPI {

    MyBMWHomePage MyBMW = new MyBMWHomePage();

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
        String exp = "My BMW Page";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }

    // Test #3
    @Test
    public void testPageTitleInspection () {
        String expectedTitle = "My BMW Page";
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
        MyBMW.exampleHover(); //called a method from Deals class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "");
    }

    // Test #5
    @Test(enabled = true)
    public void testFindModels(){
        MyBMW.clickModels();
        String expectedText = "Get Models";
        assertEqualByXpath(WEB_ELEMENT_LINK_MODELS, expectedText);

    }

    // Test #6
    @Test(enabled = true)
    public void testFindAllModels(){
        MyBMW.clickAllModels();
        String expectedText = "Get AllModels";
        assertEqualByXpath(WEB_ELEMENT_LINK_ALL_MODELS, expectedText);

    }

    // Test #7
    @Test
    public void testSendKeysToSearchBarUsingExel() throws Exception {
        MyBMW.SendKeysToSearchBarUsingExel();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"serie X1");

    }


    // Test #8
    @Test(enabled = false)
    public void testSearchserieX2UsingExel() throws Exception {
        MyBMW.SendKeyserieX2();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"serieX2");
    }


    // Test #9
    @Test(enabled = false)
    public void testSearchserieX5UsingExel() throws Exception {
        MyBMW.SendKeyserieX5();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_SEARCH_BAR,"value"),"serieX5");
    }

}
