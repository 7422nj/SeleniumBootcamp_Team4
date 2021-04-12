package homepagetest;

import SupportHome.SupportHome;
import common.WebAPI;
import homepage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static SupportHome.SupportWebElements.WEB_ELEMENT_SEARCH_BOX_MAIN;


public class HomePageTest extends WebAPI {

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    SupportHome support = new SupportHome();
    //////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Test #1
     * @param author
     * @param searchKey
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = SupportHome.class)
    @Ignore
    public void testSearchUsingDataProvider(String author, String searchKey) {
        WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_BOX_MAIN));
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }

    /**
     * Test #2
     * @param searchKey
     */

    @Test(dataProvider = "SearchInterests", dataProviderClass = SupportHome.class)
    public void testSearchUsingDataProvider2(String searchKey){
        WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_BOX_MAIN));
        searchText.sendKeys(searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }
}

