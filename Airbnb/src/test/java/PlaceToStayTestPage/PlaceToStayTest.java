package PlaceToStayTestPage;

import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

import static PlacetoStayHomePage.PlaceToStayLocators.*;



public class PlaceToStayTest extends WebAPI {

    PlaceToStayTest PlacetoStay = new PlaceToStayTest();

    @Test
    public void PlacetoStay() throws Exception{
        PlacetoStay.PlacetoStay();
        assertEqualsGetTitle("Search");
    }

    @Test
    public void OceanCity() throws Exception{
        PlacetoStay.OceanCity();
        assertEqualsGetTitle("Save");
    }
    @Test
    public void VirginiaBeach() throws Exception{
        PlacetoStay.VirginiaBeach();
        assertEqualsGetTitle((""));
    }

    @Test
    public void DevilHills() throws Exception{
        PlacetoStay.DevilHills();
        assertEqualsGetTitle("Save");
    }
    @Test
    public void Norfolk() throws Exception{
        PlacetoStay.Norfolk();
        assertEqualsGetTitle("Save");
    }



}
