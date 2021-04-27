package ShoppingHomePage;

import  common.WebAPI;
import org.openqa.selenium.support.PageFactory;

import static ShoppingHomePage.ShoppingLocators.*;


public class ShoppingHomePage extends WebAPI {

    public ShoppingHomePage() { PageFactory.initElements(driver,this);}

    public void Shopping() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_TRADEIN);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_TRADEIN_OK);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SEARCH);
        typeOnElement(WEB_ELEMENT_LINK_BMW_SEARCH,WEB_ELEMENT_LINK_BMW_SEARCH1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_MILEAGE);
        typeOnElement(WEB_ELEMENT_LINK_BMW_MILEAGE,WEB_ELEMENT_LINK_BMW_MILEAGE1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_ZIP);
        typeOnElement(WEB_ELEMENT_LINK_BMW_ZIP,WEB_ELEMENT_LINK_BMW_ZIP1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_VERIFY);
    }

    public void Payment() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SHOPPING_PAYMENT);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PAYMENT);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PAYMENT_SERIES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PAYMENT_MODEL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PAYMENT_ZIP);
        typeOnElement(WEB_ELEMENT_LINK_BMW_PAYMENT_ZIP,WEB_ELEMENT_LINK_BMW_PAYMENT_ZIP1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PAYMENT_TRADEIN);
        typeOnElement(WEB_ELEMENT_LINK_BMW_PAYMENT_TRADEIN,WEB_ELEMENT_LINK_BMW_PAYMENT_TRADEIN1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PAYMENT_VALUE);
        typeOnElement(WEB_ELEMENT_LINK_BMW_PAYMENT_VALUE,WEB_ELEMENT_LINK_BMW_PAYMENT_VERIFY);
    }

    public void Quote() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpath(WEB_ELEMENT_LINK_BMW_QUOTE_SHOPPING);
        sleepFor(3);
        clickByXpath(WEB_ELEMENT_LINK_BMW_QUOTE);
        clickByXpath(WEB_ELEMENT_LINK_BMW_QUOTE_SERIES);
        clickByXpath(WEB_ELEMENT_LINK_BMW_QUOTE_SERIES1);
        clickByXpath(WEB_ELEMENT_LINK_BMW_QUOTE_MODEL);
        clickByXpath(WEB_ELEMENT_LINK_BMW_QUOTE_VERIFY);
    }

    public void Parts() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PARTS_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PARTS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PARTS_SHOP);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PARTS_EXTERIOR);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PARTS_INTERIOR);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_PARTS_VERIFY);
    }

    public void OnlineShopping() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_ONLINE_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_ONLINE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_ONLINE_ZIP);
        typeOnElement(WEB_ELEMENT_LINK_BMW_ONLINE_ZIP,WEB_ELEMENT_LINK_BMW_ONLINE_ZIP1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_ONLINE_VERIFY);
    }

    public void Lease() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_LEASE_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_LEASE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_LEASE_ZIP);
        typeOnElement(WEB_ELEMENT_LINK_BMW_LEASE_ZIP,WEB_ELEMENT_LINK_BMW_LEASE_ZIP1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_LEASE_VERIFY);
    }

    public void Offer() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_PAYMENT);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_FIRSTNAME);
        typeOnElement(WEB_ELEMENT_LINK_BMW_OFFER_FIRSTNAME,WEB_ELEMENT_LINK_BMW_OFFER_FIRSTNAME1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_LASTNAME);
        //typeOnElement(WEB_ELEMENT_LINK_BMW_OFFER_LASTNAME,WEB_ELEMENT_LINK_BMW_OFFER_LASTNAME1);
        //clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_EMAIL);
        //scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_ZIP);
        //clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_ZIP);
        //typeOnElement(WEB_ELEMENT_LINK_BMW_OFFER_ZIP,WEB_ELEMENT_LINK_BMW_OFFER_ZIP2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_OFFER_VERIFY);
    }

    public void Finance() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_FINANCE_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_FINANCE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_FINANCE_CHECKBOX);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_FINANCE_LASTNAME);
        typeOnElement(WEB_ELEMENT_LINK_BMW_FINANCE_LASTNAME,WEB_ELEMENT_LINK_BMW_FINANCE_LASTNAME1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_FINANCE_SSN);
        typeOnElement(WEB_ELEMENT_LINK_BMW_FINANCE_SSN,WEB_ELEMENT_LINK_BMW_FINANCE_SSN1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_FINANCE_ZIP);
        typeOnElement(WEB_ELEMENT_LINK_BMW_FINANCE_ZIP,WEB_ELEMENT_LINK_BMW_FINANCE_VERIFY);
    }

    public void Services() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_BMW_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SERVICES_SHOPPING);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SERVICES);
        scrollToElementUsingJavaScript(WEB_ELEMENT_LINK_BMW_SERVICES_OFFERS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SERVICES_OFFERS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SERVICES_ZIP);
        typeOnElement(WEB_ELEMENT_LINK_BMW_SERVICES_ZIP,WEB_ELEMENT_LINK_BMW_SERVICES_ZIP1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_BMW_SERVICES_VERIFY);
    }

}
