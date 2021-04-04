package ElectronicsTest;

import ElectronicsHome.ElectronicsHomePage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ElectronicsHome.ElectronicsWebElements.webElementVerifyGoogleLinkGetText;

public class ElectronicsTest extends WebAPI {

    ElectronicsHomePage Electronics;

    @Test
    public void testGoogleLinkInElectronics() throws InterruptedException {
        ElectronicsHomePage electronics = new ElectronicsHomePage();
        electronics.ElectronicsClickSmartHome();
        String expectedText = "Google";
        String actualText = driver.findElement(By.xpath(webElementVerifyGoogleLinkGetText)).getText();
        Assert.assertEquals(actualText,expectedText,"\n*** Test Fail - Try Again ***");

    }
}
