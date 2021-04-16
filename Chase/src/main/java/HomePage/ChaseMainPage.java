package HomePage;

import HomePage.ChaseDataDriver.DataSource;
import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static HomePage.ChaseMainWebElements.*;

public class ChaseMainPage extends WebAPI {

    public ChaseMainPage() {
        PageFactory.initElements(driver, this);
    }
    /////////////////////////////////////////////////////////////////////////////////////////


    // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;


    /**
     * Action Method #1
     * @throws InterruptedException
     */

    public void navigateToMainPage() throws InterruptedException {
        robotScrollDownByChunks(10);
        find(WEB_ELEMENT_LINK_CAREERS);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_LINK_CAREERS);
        navigateBack();
    }

    /**
     * Action Method #2
     */

    public void hoverOverOpenAccount() {
        basicHoverUsingXpath(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT);
    }

    /**
     * Action Method #3
     * @throws Exception
     */

    public void signInUsingInvalidCredsUsingExcel() throws Exception {
        WebElement element = driver.findElement(By.xpath(WEB_ELEMENT_IFRAME_HANDLE));
        iframeHandle(element);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_USER_ID);
        List<String> elementFromExcel = DataSource.getItemsListFromExcel();
        String username = elementFromExcel.get(1);
        typeOnElement(WEB_ELEMENT_INPUT_USER_ID, username);
        implicitWait(20);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_INPUT_PASSWORD);
        String password = elementFromExcel.get(2);
        typeOnElement(WEB_ELEMENT_INPUT_PASSWORD, password);
        implicitWait(20);
        clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SUBMIT_SIGN_IN);
        sleepFor(30);
    }

    /**
     * Action Method #4
     */
    public void changeLanguageToEspanol() {
        hoverOverDropdownNClickUsingXpath(WEB_ELEMENT_LINK_ESPANOL, WEB_ELEMENT_LINK_ESPANOL);
    }

    /**
     * Action Method #5
     */

    public void scrollToBottomFindCompanyOwnerJPMorganChaseNCo() {
        scrollToBottomOfPage();
        find(WEB_ELEMENT_TEXT_JPMORGAN);
    }

    /**
     * Action Method #6
     */

    public void chaseLogoInspectionIsClickable() {
        find(WEB_ELEMENT_LOGO_CHASE);
    }

    /**
     * Action Method #7
     */

    public void chaseLogoInspectionIsDisplayed() {
        find(WEB_ELEMENT_LOGO_CHASE);
    }

    /**
     * Action Method #8
     */

    public void chaseLogoInspectionIsSelected() {
        find(WEB_ELEMENT_LOGO_CHASE);
        click(WEB_ELEMENT_LOGO_CHASE);

    }
}
























