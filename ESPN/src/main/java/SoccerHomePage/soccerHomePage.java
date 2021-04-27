package SoccerHomePage;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;

import static SoccerHomePage.SoccerLocators.*;


public class soccerHomePage extends WebAPI {

    public soccerHomePage() { PageFactory.initElements(driver,this);}

    public void clickonSoccer() throws Exception{
       // WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME));
       // iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_HOME);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_VERIFY);
    }

    public void clickonScore() throws Exception{
       // WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME));
       // iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_SCORE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_SCORE1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_SCORE_DAY);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_SCORE_VERIFY);
    }

    public void clickonSchedule() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_S);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_SCHEDULE);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_SCHEDULE_VERIFY);
    }

    public void clickonTransfer() throws Exception{
        //WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_TRANSFER);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_TRANSFER1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_TRANSFER_VERIFY);
    }

    public void clickonTeams() throws Exception{
       // WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME));
        //iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_TEAMS);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_TEAMS1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_SOCCER_TEAMS_VERIFY);

    }





}
