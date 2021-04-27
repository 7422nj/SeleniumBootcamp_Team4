package DealsTestPage;

import DealsHomePage.dealsHomePage;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DealsHomePage.dealsLocators.*;


public class dealsTestPage extends WebAPI {

    dealsHomePage Deals = new dealsHomePage();

    @Test
    public void Deals() throws Exception{
        Deals.Deals();
        String expectedText ="Offer code FRIEND'";
        assertEqualByXpath(WEB_ELEMENT_DEALS_WOMEN_CODE, expectedText);

    }

    @Test
    public void Men() throws Exception{
        Deals.Men();
        String expectedText = "All Men's Clothing";
        assertEqualByXpath(WEB_ELEMENT_DEALS_MEN_VERIFY,expectedText);
    }

    @Test
    public void kidsandBabaies() throws Exception{
        Deals.kidsandBabies();
        String expectedText = "Toddler Girls (2T-5T)";
        assertEqualByXpath(WEB_ELEMENT_DEALS_KIDSANDBABIES_VERIFY,expectedText);
    }

    @Test





}
