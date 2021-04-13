package Brandoutlethome;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

import static Brandoutlethome.BrandOutletLocators.*;
import static homepage.HomePageWebElement.exampleLocator;

public class BrandOutletHome extends WebAPI {

    //Constructor of class
    public BrandOutletHome() {
        PageFactory.initElements(driver, this);

    }
    /////////////////////////////////////////////////////////////////////////////////////////

    //Robot Available for All Below Methods
    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Find By Annotation: First Approach <- Used to Convert String into WebElements
    @FindBy(xpath = exampleLocator)
    public WebElement ExampleName;

    @FindBy(xpath = WEB_ELEMENT_ADIDAS_LINK)
    public WebElement AdidasLink;

    @FindBy(xpath = WEB_ELEMENT_LINK_WOMEN_ADIDAS)
    public WebElement WomenAdidas;

    @FindBy(xpath = WEB_ELEMENT_PUMA_LINK)
    public WebElement PumaLink;

    @FindBy(xpath = WEB_ELEMENT_PRICE)
    public WebElement PumaPrice;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Action Method class
    public void Adidas() throws InterruptedException {
        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_ADIDAS_LINK);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_LINK_WOMEN_ADIDAS);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_LINK_ADD_CART);

    }

    public void Puma() throws InterruptedException {
        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_PUMA_LINK);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_PRICE);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_PUMA_WOMEN);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_WOMEN_COLOR);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_PUMA_HOODIE_BUY);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_VERIFY_PUMA);

    }

    public void Reebok() throws InterruptedException {
        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_REEBOK_LINK);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_FREE_SHIPPING);

        WebDriverWait0(20);
        scrollToElementUsingJavaScript(WEB_ELEMENT_REEBOK_WOMEN);
        clickByXpath(WEB_ELEMENT_REEBOK_WOMEN);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_WOMEN_LEGGING);

        WebDriverWait0(20);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LEGGING_SIZE);

        WebDriverWait0(20);
        clickByXpathUsingJavaScript(WEB_ELEMENT_VERIFY_REEBOK);

    }

    public void HP() throws InterruptedException {
        // WebDriverWait0(20);
        //clickByXpath(WEB_ELEMENT_HP_LINK);
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_HP_LINK);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_COMPUTERS);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_HP_ENVY);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_HP_WARRANTY);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_HP_ADDTOCART);

        WebDriverWait0(20);
        clickByXpath(WEB_ELEMENT_HP_CHECKOUT);

    }

    public void MICROSOFT() throws InterruptedException {
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_MICROSOFT_LINK);
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_ACCESSORIES);
        scrollToElementUsingJavaScript(WEB_ELEMENT_FREESHIPPING);
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_FREESHIPPING);
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_MICROSOFT_SURFACE);
        WebWaitUntilClickByXpath(20, WEB_ELEMENT_MICROSOFT_VERIFY);

    }

    public void Champion() throws InterruptedException {
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_LINK);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_KIDS);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_RED);
        scrollToElementUsingJavaScript(WEB_ELEMENT_CHAMPION_SHIPPING);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_SHIPPING);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_SWEATSHIRT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_COLOR);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_CART);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_CHAMPION_VERIFY);
    }

    public void Hanes() throws InterruptedException {
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_LINK);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_MEN);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_SIZE);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_COLOR);
        scrollToElementUsingJavaScript(WEB_ELEMENT_HANES_BUYIT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_BUYIT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_TSHIRT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_QUANTITY);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_ADDTOCART);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_HANES_VERIFY);
    }

    public void Jewelry() throws InterruptedException {
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_LINK);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_ENG_WED);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_RING);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_RINGSIZE);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_BUYIT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_PLAN);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_JEWELRY_VERIFY);

    }

    public void Levian() throws InterruptedException {
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_LEVIAN_LINK);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_LEVIAN_RING);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_LEVIAN_BUYIT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_LEVIAN_CHECKOUT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_LEVIAN_VERIFY);
    }

    public void Superdry() throws InterruptedException {
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_LINK);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_BUYITNOW);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_WOMEN);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_WOMEN_DRESS);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_DRESS_SIZE);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_DRESS_COLOR);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_BUYIT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_CHECKOUT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_SUPERDRY_VERIFY);

    }

    public void ASICS() throws InterruptedException {
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_LINK);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_WOMEN);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_WOMEN_SIZE);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_WOMEN_RUNNING);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_COLOR);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_SIZE);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_BUYIT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_CHECKOUT);
        WebWaitUntilClickByXpath(30, WEB_ELEMENT_ASICS_VERIFY);

    }

    public void Newbalance() throws InterruptedException {
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_LINK);
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_WOMEN);
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_SIZE);
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_JACKET);
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_BUYIT);
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_CHECKOUT);
        WebWaitUntilClickByXpath(30,WEB_ELEMENT_NEWBALANCE_VERIFY);
    }
}



