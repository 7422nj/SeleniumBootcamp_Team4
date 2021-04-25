package HomeLoansHomePage;

import common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import static HomeLoansHomePage.HomeLoansLocators.*;


public class HomeLoansPage extends WebAPI {

    public HomeLoansPage() { PageFactory.initElements(driver,this);}

    public void Homeloans() throws Exception{

        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_LOANS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_LOANS_MORTAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_LOANS_VERIFY);
    }

    public void Mortage() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOMELOANS_MORTAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_MORTAGE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_MORTAGE_VERIFY);
    }

    public void Apply() throws Exception{

        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_MORTAGE_APPLY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_MORTAGE1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_APPLY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_APPLY1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CONTRACT);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_VERIFY);
    }

    public void Refinance() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE_HOMELOAN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE_VERIFY);
    }

    public void Apply1() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE_HOME_LOAN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE1_APPLY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE1_BUTTON);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE1_LOWERPAYMENT);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_REFINANCE1_VERIFY);
    }

    public void HomeEquity() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_EQUITY_LOAN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_EQUITY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_EQUITY_STATE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_HOME_EQUITY_VERIFY);
    }

    public void Specialest() throws Exception{
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SPECIALST_LOAN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SPECIALST_HOMEEQUITY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SPECIALST);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_SPECIALST_VERIFY);
    }



}
