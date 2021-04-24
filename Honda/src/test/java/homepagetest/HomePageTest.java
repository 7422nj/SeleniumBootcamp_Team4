package homepagetest;

import HomePage.HondaMainPage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static HomePage.HondaWebElement.*;

public class HomePageTest extends WebAPI {

    //////////////////////////////////////////
    HondaMainPage honda = new HondaMainPage();
    SoftAssert softAssert = new SoftAssert();
    /////////////////////////////////////////

    /**
     * Test #1
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchReliabilitiesUsingExcel() throws Exception {
      honda.searchReliabilitiesUsingExcel();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_SEARCH_RESULTS),"Reliabilities");

    }

    /**
     * Test #2
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSearchHybridNGetMoreDetailsUsingMYSQLDB()throws Exception{
        honda.searchHybridNGetMoreDetailsNSwitchTabsUsingMYSQLDB();
        softAssert.assertTrue(isElementDisplayed(WEB_ELEMENT_VERIFY_HYBRID));
        softAssert.assertTrue(isCurrentUrlTrue("https://automobiles.honda.com/vehicle-electrification?source=https%3a%2f%2fautomobiles.honda.com%2falternative-fuel-vehicles%2f&statusCode=301"));
        softAssert.assertTrue(isTitleTrue("Vehicle Electrification – Benefits and Technologies | Honda"));
        softAssert.assertEquals(getTextFromElement(WEB_ELEMENT_VERIFY_HEADER_HYBRID),"Benefits of Electrified Vehicles");
        softAssert.assertAll();
    }

    /**
     * Test #3
     * @param author
     * @param searchKey
     * @throws InterruptedException
     */

    @Test(dataProvider = "SearchProvider", dataProviderClass = HondaMainPage.class)
    public void testMethod(String author, String searchKey) throws InterruptedException {
        honda.searchItemsUsingDataProvider();
        WebElement searchText = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_FIELD));
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue + "::::" + searchKey);
        searchText.clear();
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }


    }

