package DealsHomePage;

import common.WebAPI;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import static DealsHomePage.dealsLocators.*;



public class dealsHomePage extends WebAPI {



    public dealsHomePage(){
        PageFactory.initElements(driver, this);
    }

    Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void Deals() throws Exception {
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_WOMEN);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_WOMEN_CODE);
    }

    public void Men() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_MEN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_MEN1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_MEN_VERIFY);
    }

    public void kidsandBabies() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_KIDSANDBABIES);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_KIDSANDBABIES1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_DEALS_KIDSANDBABIES_VERIFY);
    }



}
