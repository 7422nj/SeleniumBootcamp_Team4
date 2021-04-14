package homepagetest;

import common.WebAPI;
import HomePage.ChaseMainPage;
import org.testng.annotations.Test;

import java.awt.*;

import static HomePage.ChaseMainWebElements.*;

public class HomePageTest extends WebAPI {
    // Test class
    ChaseMainPage chase = new ChaseMainPage();
////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Test #1
     *
     * @throws InterruptedException
     * @throws AWTException
     */

    @Test(enabled = false)
    public void testNavigateToMainPage() throws InterruptedException, AWTException {
        chase.navigateToMainPage();
        assertEqualsGetCurrentUrl("https://www.chase.com/");
    }

    /**
     * Test #2
     *
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverOpenAccount() throws InterruptedException {
        chase.hoverOverOpenAccount();
        assertEqualsGetAttribute("Open an account", WEB_ELEMENT_BUTTON_OPEN_ACCOUNT, "aria-label");
    }

    /**
     * Test #3
     */

    @Test(enabled = false)
    public void testOpenAccountButtonIsDisplayed() {
        chase.hoverOverOpenAccount();
        assertTrueIsDisplayed(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT);
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testOpenAccountButtonIsEnabled() {
        chase.hoverOverOpenAccount();
        assertTrueIsEnabled(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT);

    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testOpenAccountButtonIsNotSelected() {
        chase.hoverOverOpenAccount();
        assertFalseIsSelected(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT);

    }

    /**
     * Test #6
     * @throws Exception
     */

    @Test(enabled = false)
    public void testSignWithInvalidCredsUsingExcelNIframeHandling() throws Exception {
        chase.signInUsingInvalidCredsUsingExcel();
        assertEqualsGetText("Important:\n" +
                "We can't find that username and password. You can reset your password or try again.",WEB_ELEMENT_VERIFY_ERROR_HEADER);
    }

    /**
     * Test #7
     */

    @Test(enabled = false)
    public void testChangeLanguageToSpanish(){
        chase.changeLanguageToEspanol();
        assertEqualsGetCurrentUrl("https://www.chase.com/espanol");
    }

    /**
     * Test #8
     */

    @Test(enabled = false)
    public void testScrollToBottomFindCompanyOwnerJPMorganChaseNCo(){
        chase.scrollToBottomFindCompanyOwnerJPMorganChaseNCo();
        assertEqualsGetText("© 2021 JPMorgan Chase & Co..",WEB_ELEMENT_TEXT_JPMORGAN);
    }

    /**
     * Test #9
     */

    @Test
    public void testChaseLogoInspectionIsClickable(){
        chase.chaseLogoInspectionIsClickable();
        assertTrueIsEnabled(WEB_ELEMENT_LOGO_CHASE);
    }

    /**
     * Test 10
     */

    @Test
    public void testChaseLogoInspectionIsDisplayed(){
        chase.chaseLogoInspectionIsDisplayed();
        assertTrueIsDisplayed(WEB_ELEMENT_LOGO_CHASE);
    }

    /**
     * Test #11
     */

    @Test
    public void testChaseLogoInspectionIsSelected(){
        chase.chaseLogoInspectionIsSelected();
        assertFalseIsSelected(WEB_ELEMENT_LOGO_CHASE);
    }

    /**
     * Test #12
     */

    @Test
    public void testRefreshPageUsingChaseLogo(){
        chase.chaseLogoInspectionIsSelected();
        assertEqualsGetCurrentUrl("https://www.chase.com/");
    }
}
