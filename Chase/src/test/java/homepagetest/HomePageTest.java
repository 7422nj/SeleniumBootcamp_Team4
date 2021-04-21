package homepagetest;

import common.WebAPI;
import HomePage.ChaseMainPage;
import org.testng.Assert;
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
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.chase.com/");
    }

    /**
     * Test #2
     *
     * @throws InterruptedException
     */

    @Test(enabled = false)
    public void testHoverOverOpenAccount() throws InterruptedException {
        chase.hoverOverOpenAccount();
        Assert.assertEquals(getAttributeFromElement(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT, "aria-label"),"Open an account");
    }

    /**
     * Test #3
     */

    @Test(enabled = false)
    public void testOpenAccountButtonIsDisplayed() {
        chase.hoverOverOpenAccount();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT));
    }

    /**
     * Test #4
     */

    @Test(enabled = false)
    public void testOpenAccountButtonIsEnabled() {
        chase.hoverOverOpenAccount();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT));
    }

    /**
     * Test #5
     */

    @Test(enabled = false)
    public void testOpenAccountButtonIsNotSelected() {
        chase.hoverOverOpenAccount();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_BUTTON_OPEN_ACCOUNT));
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
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.chase.com/espanol");
    }

    /**
     * Test #8
     */

    @Test(enabled = false)
    public void testScrollToBottomFindCompanyOwnerJPMorganChaseNCo(){
        chase.scrollToBottomFindCompanyOwnerJPMorganChaseNCo();
        Assert.assertEquals(getTextFromElement(WEB_ELEMENT_TEXT_JPMORGAN),"© 2021 JPMorgan Chase & Co..");
    }

    /**
     * Test #9
     */

    @Test(enabled = false)
    public void testChaseLogoInspectionIsClickable(){
        chase.chaseLogoInspectionIsClickable();
        Assert.assertTrue(isElementEnabled(WEB_ELEMENT_LOGO_CHASE));
    }

    /**
     * Test 10
     */

    @Test(enabled = false)
    public void testChaseLogoInspectionIsDisplayed(){
        chase.chaseLogoInspectionIsDisplayed();
        Assert.assertTrue(isElementDisplayed(WEB_ELEMENT_LOGO_CHASE));
    }

    /**
     * Test #11
     */

    @Test(enabled = false)
    public void testChaseLogoInspectionIsSelected(){
        chase.chaseLogoInspectionIsSelected();
        Assert.assertFalse(isElementSelected(WEB_ELEMENT_LOGO_CHASE));
    }

    /**
     * Test #12
     */

    @Test(enabled = true)
    public void testRefreshPageUsingChaseLogo(){
        chase.chaseLogoInspectionIsSelected();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.chase.com/");
    }

    @Test(enabled = false)
    public void testScroll(){
        try {
            robotScrollDown2(5);
            sleepFor(3);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
