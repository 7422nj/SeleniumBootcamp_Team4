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


    @Test
    public void testGetCurrentUrl() throws AWTException, InterruptedException{
        String expect="";
        String actual= driver.getCurrentUrl();
        Assert.assertEquals(actual,expect);
    }

    @Test
    public void testVerifyPageTitle () {
        String exp = "My BMW Page";
        String act = driver.getTitle();
        Assert.assertTrue(exp.equalsIgnoreCase(act));
    }
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


    @Test(enabled = false)
    public void testExamples() throws InterruptedException, AWTException {
        MyBMW.exampleHover(); //called a method from Deals class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue, expectedAttributeValue, "");
    }

    @Test(enabled = true)
    public void testFindModels(){
        MyBMW.clickModels();
        String expectedText = "Get Models";
        assertEqualByXpath(WEB_ELEMENT_LINK_MODELS, expectedText);

    }

    @Test(enabled = true)
    public void testFindAllModels(){
        MyBMW.clickAllModels();
        String expectedText = "Get AllModels";
        assertEqualByXpath(WEB_ELEMENT_LINK_ALL_MODELS, expectedText);

    }

}
