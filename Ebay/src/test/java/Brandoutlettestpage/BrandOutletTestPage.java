package  Brandoutlettestpage;

import Brandoutlethome.BrandOutletHome;
import common.WebAPI;
import org.testng.annotations.Test;

import java.awt.*;

import static Brandoutlethome.BrandOutletLocators.*;

public class BrandOutletTestPage extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    BrandOutletHome homePage = new BrandOutletHome();
    //////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test(enabled = false)
    public void testAdidas() throws InterruptedException, AWTException {

        homePage.Adidas();
        String expectedText = "adidas Grand Court Shoes Women's";
        assertEqualByXpath(WEB_ELEMENT_VERIFY_SHOES, expectedText);

    }

    @Test(enabled = false)
    public void testPuma() throws InterruptedException, AWTException {

        homePage.Puma();
        String expectedText = "PUMA Women's Rebel Hoodie PL";
        assertEqualByXpath(WEB_ELEMENT_VERIFY_PUMA, expectedText);

    }

    @Test(enabled = false)
    public void testReebok() throws InterruptedException, AWTException {
        homePage.Reebok();
        String expectedText = "Buy It Now";
        assertEqualByXpath(WEB_ELEMENT_VERIFY_REEBOK, expectedText);

    }

    @Test(enabled = false)
    public void testHP() throws InterruptedException, AWTException {
        homePage.HP();
        String expectedText = "Continue with Google";
        assertEqualByXpath(WEB_ELEMENT_HP_VERIFY, expectedText);

    }

    @Test(enabled = false)
    public void testMicrosoft() throws InterruptedException, AWTException {
        homePage.MICROSOFT();
        String expectedText = "Buy It Now";
        assertEqualByXpath(WEB_ELEMENT_MICROSOFT_VERIFY, expectedText);

    }

    @Test(enabled = false)
    public void testChampion() throws InterruptedException, AWTException {
        homePage.Champion();
        String expectedText = "Champion Boys Sweatshirt Fleece Hoodie Embroidered Script Logo Athletics Youth";
        assertEqualByXpath(WEB_ELEMENT_CHAMPION_VERIFY, expectedText);

    }

    @Test(enabled = false)
    public void testHanes() throws InterruptedException, AWTException {
        homePage.Hanes();
        String expectedText = "Hanes T Shirt Beefy-T Adult Short Sleeve Mens Womens Soft Pr...";
        assertEqualByXpath(WEB_ELEMENT_HANES_VERIFY, expectedText);
    }

    @Test(enabled = false)
    public void testJewelry() throws InterruptedException, AWTException {
        homePage.Jewelry();
        String expectedText = "";
        assertEqualByXpath(WEB_ELEMENT_JEWELRY_VERIFY, expectedText);
    }

    @Test(enabled = false)
    public void testLevian() throws InterruptedException, AWTException {
        homePage.Levian();
        String expectedText = "LeVian 14K Rose Gold Pink Amethyst Rhodolite Garnet Brown Diamond Halo Ring";
        assertEqualByXpath(WEB_ELEMENT_LEVIAN_VERIFY, expectedText);
    }

    @Test(enabled = false)
    public void testSuperdry() throws InterruptedException, AWTException {
        homePage.Superdry();
        String expectedText = "Superdry Womens Mahi Bodycon Dress";
        assertEqualByXpath(WEB_ELEMENT_SUPERDRY_VERIFY, expectedText);

    }

    @Test(enabled = false)
    public void testASICS() throws InterruptedException, AWTException {
        homePage.ASICS();
        String expectedText = "ASICS Women's Kate Mesh Capri Running Apparel 2012A833";
        assertEqualByXpath(WEB_ELEMENT_ASICS_VERIFY, expectedText);

    }

    @Test(enabled = true)
    public void testNewbalance() throws InterruptedException, AWTException {
        homePage.Newbalance();
        String expectedText = "New Balance Women's Achiever Bandana Print Jacket White";
        assertEqualByXpath(WEB_ELEMENT_NEWBALANCE_VERIFY, expectedText);
    }
}

