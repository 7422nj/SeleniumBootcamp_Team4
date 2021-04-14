package ShopsTestPage;

import ShopsPage.ShopsPage;
import common.WebAPI;
import org.testng.annotations.Test;

import java.awt.*;

import static ShopsPage.ShopsWebElements.*;

public class ShopsTestPage extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////
    ShopsPage shop = new ShopsPage();
    //////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testFindPerfectEaglesJerseyUsingWebTable() throws InterruptedException, AWTException {
        shop.findPerfectEaglesJerseyUsingSizeTable();
        assertEqualsGetAttribute("Size S",WEB_ELEMENT_VERIFY_SMALL,"aria-label");
    }
}
