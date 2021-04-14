package ShopsPage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

import static ShopsPage.ShopsWebElements.*;

public class ShopsPage extends WebAPI {

    public ShopsPage() {
        PageFactory.initElements(driver, this);
    }
    /////////////////////////////////////////////////////////////////////////////////////////

//    // Find By Annotation: First Approach
    @FindBy(xpath = WEB_ELEMENT_BUTTON_NFL)
    public WebElement NFL;

    public void findPerfectEaglesJerseyUsingSizeTable() throws InterruptedException, AWTException {
        implicitWait(25);
        basicHoverUsingXpath(WEB_ELEMENT_BUTTON_NFL);
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_BUTTON_NFL,WEB_ELEMENT_LINK_EAGLES);
        implicitWait(25);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_RADIO_BUTTON_MEN);
        implicitWait(15);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_TABLE_SMALL);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_JERSEY);
        implicitWait(15);
        click(WEB_ELEMENT_TABLE_SMALL);

    }




}
