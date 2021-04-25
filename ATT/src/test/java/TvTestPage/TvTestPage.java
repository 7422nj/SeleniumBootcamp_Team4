package TvTestPage;

import common.WebAPI;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

import TvHomePage.TvLocators.*;

public class TvTestPage extends WebAPI {

    TvTestPage TV = new TvTestPage();

    @Test
    public void Tv() throws Exception{
        TV.Tv();
        assertEqualsGetTitle("");
    }
}
