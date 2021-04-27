package ShoppingTestPage;

import ShoppingHomePage.ShoppingHomePage;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import static ShoppingHomePage.ShoppingLocators.*;


public class ShoppingTestPage extends WebAPI {

    ShoppingHomePage Shopping = new ShoppingHomePage();

    @Test(enabled = false)
    public void Shopping() throws Exception{
        Shopping.Shopping();
        assertEqualsGetTitle("Next: Vechile Option");
    }

    @Test(enabled = false)
    public void Payment() throws Exception{
        Shopping.Payment();
        Assert.assertTrue(isTitleTrue("Car Payment Estimator - Lease and Finance Options - BMW USA"));
    }

    @Test(enabled = false)
    public void Quote() throws Exception{
        Shopping.Quote();
        Assert.assertTrue(isTitleTrue("Request a Quote - Pricing, Offers & Product Information - BMW USA"));
    }

    @Test(enabled = false)
    public void Parts() throws Exception{
        Shopping.Parts();
        assertEqualsGetTitle("");
    }

    @Test(enabled = false)
    public void OnlineShopping() throws Exception{
        Shopping.OnlineShopping();
        assertEqualsGetTitle("Shop From Home – Online Retail Experience | BMW USA");
    }

    @Test(enabled = false)
    public void Lease() throws Exception{
        Shopping.Lease();
        assertEqualsGetTitle("Lease & Finance Offers - BMW USA");
    }

    @Test(enabled = false)
    public void Offer() throws Exception{
        Shopping.Offer();
        assertEqualsGetTitle("Submit");
    }

    @Test(enabled = false)
    public void Finance() throws Exception{
        Shopping.Finance();
        assertEqualsGetTitle("Apply for Financing - BMW Credit Application");
    }

    @Test(enabled = true)
    public void Services() throws Exception{
        Shopping.Services();
        assertEqualsGetTitle("Lease & Finance Offers - BMW USA");
    }



}
