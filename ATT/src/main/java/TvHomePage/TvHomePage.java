package TvHomePage;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;

import static TvHomePage.TvLocators.*;

public class TvHomePage extends WebAPI {
    public TvHomePage() { PageFactory.initElements(driver,this);}

    public void Tv() throws Exception{
        WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME));
        iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_TV);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_ATT_TV);
        clickByXpathUsingJavaScript(WEB_ELEMENT_ATT_TV_VERIFY);
    }

    public void Channel() throws Exception{

    }

}
