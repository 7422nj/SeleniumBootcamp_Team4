package ShoppingTestPage;

import ShoppingHomePage.ShoppingHomePage;
import common.WebAPI;
import org.testng.annotations.Test;
import java.awt.*;
import static ShoppingHomePage.ShoppingLocators.*;


public class ShoppingTestPage extends WebAPI {

    ShoppingHomePage Shopping = new ShoppingHomePage();

    @Test
    public void Shopping() throws Exception{
        Shopping.Shopping();
        assertEqualsGetTitle("Next: Vechile Option");
    }

    @Test
    public void Payment() throws Exception{
        Shopping.Payment();
        assertEqualsGetTitle("Estimated Add-On Value");
    }

    @Test
    public void Quote() throws Exception{
        Shopping.Quote();
        assertEqualsGetTitle("");
    }

    @Test
    public void Parts() throws Exception{
        Shopping.Parts();
        assertEqualsGetTitle("");
    }

    @Test
    public void OnlineShopping() throws Exception{
        Shopping.OnlineShopping();
        assertEqualsGetTitle("Search");
    }

    @Test
    public void Lease() throws Exception{
        Shopping.Lease();
        assertEqualsGetTitle("Search");
    }

    @Test
    public void Offer() throws Exception{
        Shopping.Offer();
        assertEqualsGetTitle("Submit");
    }

    @Test
    public void Finance() throws Exception{
        Shopping.Finance();
        assertEqualsGetTitle("Zip Code");
    }

    @Test
    public void Services() throws Exception{
        Shopping.Services();
        assertEqualsGetTitle("Search");
    }



}
