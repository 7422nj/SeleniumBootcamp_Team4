package PlaceToStayTestPage;

import PlacetoStayHomePage.PlaceToStay;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

import static PlacetoStayHomePage.PlaceToStayLocators.*;



public class PlaceToStayTest extends WebAPI {

    PlaceToStay PlacetoStay = new PlaceToStay();

    @Test(enabled = true)
    public void PlacetoStay() throws Exception{
        PlacetoStay.PlacetoStay();
        assertEqualsGetTitle("Search");
    }

    @Test(enabled = false)
    public void OceanCity() throws Exception{
        PlacetoStay.OceanCity();
        assertEqualsGetTitle("Save");
    }
    @Test(enabled = false)
    public void VirginiaBeach() throws Exception{
        PlacetoStay.Virginiabeach();
        assertEqualsGetTitle((""));
    }

    @Test(enabled = false)
    public void DevilHills() throws Exception{
        PlacetoStay.DevilHills();
        assertEqualsGetTitle("Save");
    }
    @Test(enabled = false)
    public void Norfolk() throws Exception{
        PlacetoStay.Norfolk();
        assertEqualsGetTitle("Save");
    }



}
