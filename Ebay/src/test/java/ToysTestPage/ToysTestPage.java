package ToysTestPage;

import ToysHome.ToysHomepage;
import common.WebAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

import static ToysHome.ToysWebElements.*;

public class ToysTestPage extends WebAPI {

    //Object of ToysHomepage class
    ToysHomepage toys = new ToysHomepage();
    //////////////////////////////////////////////////////

    @Test(enabled = true)
    public void testExamples() throws InterruptedException, AWTException {
        toys.exampleHover(); //called a method from toysHomepage class
        String actualAttributeValue = driver.findElement(By.className("")).getAttribute("value");
        String expectedAttributeValue = "";
        Assert.assertEquals(actualAttributeValue,expectedAttributeValue,"Color does not match");

    }

    @Test(enabled = false)
    public void testFindGames() {
        toys.clickGames();
        String expectedText = "Other Chess";
        assertEqualByXpath(WEB_ELEMENT_HEADER_OTHER_CHESS, expectedText);
    }

    @Test(enabled = false)
    public void testSearchBar() {
        toys.SearchBar();
    String expectedText= "Under $40.00\n" + "Remove filter";
    assertEqualByXpath(WEB_ELEMENT_HEADER_PRICE_FILTER, expectedText);
    }

}

