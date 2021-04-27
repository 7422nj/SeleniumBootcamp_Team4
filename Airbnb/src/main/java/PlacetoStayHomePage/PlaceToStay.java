package PlacetoStayHomePage;

import common.WebAPI;
import org.openqa.selenium.support.PageFactory;

import static PlacetoStayHomePage.PlaceToStayLocators.*;



public class PlaceToStay extends WebAPI {
    public PlaceToStay() { PageFactory.initElements(driver,this);}

    public void PlacetoStay() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_PLACETOSTAY);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_LOCATION);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_DESTINATION);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_CHECKIN);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_MONTH);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_DAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_CHECKOUT);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_CHECKOUT_DAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_VERIFY);
    }

    public void OceanCity() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_OCEANCITY);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_OCEANCITY_PLACE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_OCEANCITY_HOTEL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_OCEANCITY_VERIFY);
    }

    public void Virginiabeach() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_VIRGINIABEACH);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_PRICE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_PRICE_RANGE);
        typeOnElement(WEB_ELEMENT_AIRBNB_PRICE_RANGE,WEB_ELEMENT_AIRBNB_PRICE_RANGE1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_VIRGINIABEACH_VERIFY);
    }

    public void DevilHills() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_DEVILHILLS);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_DEVILHILLS_CANCELLATION);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_DEVILHILLS_CANCELLATION_BUTTON);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_DEVILHILLS_VERIFY);
    }

    public void Norfolk() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_NORFOLK);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_NORFOLK_PRICE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_NORFOLK_PRICE1);
        typeOnElement(WEB_ELEMENT_AIRBNB_NORFOLK_PRICE1,WEB_ELEMENT_AIRBNB_NORFOLK_PRICE2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_AIRBNB_NORFOLK_VERIFY);
    }




}
