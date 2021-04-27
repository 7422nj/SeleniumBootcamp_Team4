package BetHomePage;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static BetHomePage.BetLocators.*;

public class BetHomePage extends WebAPI {

    public BetHomePage() { PageFactory.initElements(driver,this);}

    public void Bet() throws Exception {
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_FOOTBALL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_PLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_FOOTBALL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_VERIFY);
    }

    public void Basketball() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_BASKETBALL);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASKETBALL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASKETBALL_PLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASKETBALL2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASKETBALL_VERIFY);
    }
    public void Baseball() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_BASEBALL);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASEBALL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASEBALL_PLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASEBALL2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BASEBALL_VERIFY);
    }
    public void Hockey() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_HOCKEY);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_HOCKEY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_HOCKEY_PLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_HOCKEY2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_HOCKEY_VERIFY);

    }
    public void Golf() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_GOLF);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_GOLF);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_GOLF_PLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_GOLF2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_GOLF_VERIFY);
    }

    public void Futures() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_FUTURES);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_FUTURES);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_FUTURES_VERIFY);
    }

    public void Inplay() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_LINK_CBS_BET_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_BET_INPLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_INPLAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_LINK_CBS_INPLAY_VERIFY);
    }




}
