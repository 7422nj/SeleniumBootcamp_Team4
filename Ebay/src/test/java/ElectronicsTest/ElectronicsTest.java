package ElectronicsTest;

import ElectronicsHome.ElectronicsHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ElectronicsHome.ElectronicsWebElements.webElementVerifyGoogleLinkText;

public class ElectronicsTest extends WebAPI {

    ///////////////////  Object of Electronics Class /////////////////////
    ElectronicsHomePage electronics = new ElectronicsHomePage();
    /////////////////////////////////////////////////////////////////////

    @Test
    public void testGoogleLinkInElectronics() throws InterruptedException {
        electronics.ElectronicsClickSmartHome();
        String expectedText = "Google";
        String actualText = driver.findElement(By.xpath(webElementVerifyGoogleLinkText)).getText();
        Assert.assertEquals(actualText,expectedText,"\n*** Test Fail - Try Again ***");

    }
}
